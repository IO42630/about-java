package com.olexyn.about.java.spring.boot.security.method.endpoint;

import com.olexyn.about.java.spring.boot.security.method.model.DummyDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanelEndpoint {

    @GetMapping("/user-panel")
    public String getUserPanel() {
        return "USER PANEL "
            + userPrivateRaw()
            + userPrivate()
            + anyPrivateRaw()
            + anyPrivate()
            + getValue().getValue();
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

    @Secured("hasRole('ADMIN')")
    @PostFilter("filterObject.value == 'VAALUE'")
    private DummyDto getValue() {
        var dto = new DummyDto();
        dto.setValue("VALUE");
        return dto;
    }

}
