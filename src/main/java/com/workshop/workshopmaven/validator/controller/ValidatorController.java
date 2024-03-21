package com.workshop.workshopmaven.validator.controller;

import com.workshop.workshopmaven.validator.model.CsvModelValidator;
import com.workshop.workshopmaven.validator.model.XlsxRequestModelValidator;
import com.workshop.workshopmaven.validator.service.ValidatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidatorController {

    private ValidatorService validatorService;

    public ValidatorController(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @PostMapping("/validateData/xlsx")
    public ResponseEntity<Boolean> validateData(@RequestBody XlsxRequestModelValidator request){
        return ResponseEntity.ok(this.validatorService.validateXlsx(request));
    }

    @PostMapping("/validateData/csv")
    public ResponseEntity<Boolean> validateData(@RequestBody CsvModelValidator request){
        return ResponseEntity.ok(this.validatorService.validateCsv(request));
    }


}