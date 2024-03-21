package com.workshop.workshopmaven.validator.service;

import com.workshop.workshopmaven.validator.model.CsvModelValidator;
import com.workshop.workshopmaven.validator.model.XlsxRequestModelValidator;
import com.workshop.workshopmaven.validator.service.validateFiles.ValidatorXlsxService;
import com.workshop.workshopmaven.validator.util.MapFiles;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    private Validator  validator;
    public boolean validateXlsx(XlsxRequestModelValidator request) {
        validator = MapFiles.getValidatorService("xlsx");
        if (validator == null) {
            return false;
        }
        try {
            return validator.validateRow(request);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean validateCsv(CsvModelValidator request) {
        validator = MapFiles.getValidatorService("csv");
        if (validator == null) {
            return false;
        }
        try {
            return validator.validateRow(request);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
