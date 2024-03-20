package com.workshop.workshopmaven.reader.exception;

public class FileException extends RuntimeException{

    public FileException(String message) {
        super(message);
    }

    public FileException() {
        super();
    }
}
