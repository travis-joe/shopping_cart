package com.xiedaimala.shopping_cart.session.controller;

import com.xiedaimala.shopping_cart.session.model.Session;
import com.xiedaimala.shopping_cart.session.model.SessionManager;
import com.xiedaimala.shopping_cart.session.view.LoginRequest;
import com.xiedaimala.shopping_cart.user.model.User;
import com.xiedaimala.shopping_cart.user.model.UserDao;
import com.xiedaimala.shopping_cart.user.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class SessionController {
    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";
    private UserDao userDao;
    private SessionManager sessionManager;

    public SessionController(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
    }

    @PostMapping("/session")
    public ResponseEntity login(HttpServletResponse response, @RequestBody LoginRequest login) {
        User user = userDao.getByName(login.getUsername());

        if (user == null || !user.getPassword().equals(login.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        String token = UUID.randomUUID().toString(); // 随机数
        sessionManager.getSessions().put(user.getId(), new Session(user.getId(), token));

        response.addCookie(new Cookie(USER_ID, Long.toString(user.getId())));
        response.addCookie(new Cookie(SESSION_TOKEN, token));

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/current")
    public ResponseEntity<UserView> current(@CookieValue(name = USER_ID, defaultValue = "0") long userId,
                                            @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionManager.getSessions().get(userId);

        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // 认证成功
        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new UserView(user.getId(), user.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/session")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionManager.getSessions().get(userId);

        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        // 删除Session
        sessionManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
