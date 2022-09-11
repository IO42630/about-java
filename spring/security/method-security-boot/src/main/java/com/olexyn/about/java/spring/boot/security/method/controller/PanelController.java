package com.olexyn.about.java.spring.boot.security.method.controller;

import com.olexyn.about.java.spring.boot.security.method.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanelController {

    @Autowired
    PanelService panelService;

    @GetMapping("/user-panel")
    public String getUserPanel() {
        return "USER PANEL "
            + userPrivateRaw()
            + userPrivate()
            + anyPrivateRaw()
            + anyPrivate();
    }

    @GetMapping("dummy")
    public String getDummy() {
        return panelService.getDummy().get(0).getValue();
    }

    @GetMapping("/admin-panel")
    public String getAdminPanel() {
        return "ADMIN PANEL";
    }

    @GetMapping("/logout")
    public String getLogout() {
        return "LOGOUT";
    }

    @Secured("ROLE_USER")
    private String userPrivateRaw() {
        return "userPrivate";
    }

    @Secured("hasRole('USER')")
    private String userPrivate() {
        return "userPrivate";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    private String anyPrivateRaw() {
        return "userPrivate";
    }

    @Secured("hasAnyRole('USER,ADMIN')")
    private String anyPrivate() {
        return "userPrivate";
    }



}
