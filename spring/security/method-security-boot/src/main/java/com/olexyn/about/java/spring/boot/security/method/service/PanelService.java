package com.olexyn.about.java.spring.boot.security.method.service;

import com.olexyn.about.java.spring.boot.security.method.model.DummyDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelService {

    @Secured("hasRole('ADMIN')")
    // @PostFilter("filterObject.value.equals('VALUE')") TODO fix this.
    public List<DummyDto> getDummy() {
        var dto = new DummyDto();
        dto.setValue("VALUE");
        return List.of(dto);
    }

}
