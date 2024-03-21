package com.workshop.workshopmaven.validator.util;

import com.workshop.workshopmaven.validator.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapFiles {
    static List<Validator> validator;

    @Autowired
    public MapFiles(List<Validator> validator) {
        this.validator = validator;
    }

    public static Validator getValidatorService(String fileType) {
        return validator.stream().filter(validatorService -> validatorService.getType().equals(fileType)).findFirst().orElse(null);
    }
}
