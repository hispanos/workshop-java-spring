package com.workshop.workshopmaven.validator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidatorController {

    @PostMapping("/validateData/{fileType}")
    public ResponseEntity<Boolean> validateData(@PathVariable String fileType, @RequestBody Object request){
        return ResponseEntity.ok(true);
    }


}