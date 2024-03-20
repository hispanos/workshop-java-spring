package com.workshop.workshopmaven.reader.controller;

import com.workshop.workshopmaven.reader.exception.FileException;
import com.workshop.workshopmaven.reader.model.ReaderRequest;
import com.workshop.workshopmaven.reader.model.ResponseReader;
import com.workshop.workshopmaven.reader.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReaderController {

    //Add ReaderCsvService
    @Autowired
    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/loadFile")
    public ResponseEntity<ResponseReader> loadFile(@RequestBody ReaderRequest request) {
        return ResponseEntity.ok(readerService.processFile(request.getUrlFile()));
    }




}