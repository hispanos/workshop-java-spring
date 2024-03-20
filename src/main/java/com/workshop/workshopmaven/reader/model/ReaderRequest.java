package com.workshop.workshopmaven.reader.model;

public class ReaderRequest {
    private String urlFile;

    public ReaderRequest() {
    }

    public ReaderRequest(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
}
