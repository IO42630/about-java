package com.olexyn.about.java.spring.boot.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("sessionDemo")
public class SessionController {

    private final static String SESSION_KEY = "SOME_SESSION_KEY";

    @GetMapping(value = {""})
    public String get(HttpSession session) {
        return getSessionKey(session);
    }

    @PostMapping("/persist")
    public void persistMessage(HttpServletRequest request) {
        var key = getSessionKey(request.getSession());
        if (key == null) {
            request.getSession().setAttribute(SESSION_KEY, SESSION_KEY);
        }
    }

    @PostMapping("/destroy")
    public void destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    private String getSessionKey(HttpSession session) {
        var raw = session.getAttribute(SESSION_KEY);
        if (raw instanceof String) {
            return (String) raw;
        }
        return null;
    }
}
