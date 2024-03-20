package com.workshop.workshopmaven.reader.util;

import com.workshop.workshopmaven.reader.services.Reader;
import com.workshop.workshopmaven.reader.services.readerFiles.ReaderCsvService;
import com.workshop.workshopmaven.reader.services.readerFiles.ReaderXlsxService;

import java.util.HashMap;
import java.util.Map;
public class MapFiles {

    private Map<String, Reader> readerServices = new HashMap<>();

    public MapFiles() {
        readerServices.put("csv", new ReaderCsvService());
        readerServices.put("xlsx", new ReaderXlsxService());
    }

    public void addReaderService(String fileType, Reader readerService) {
        readerServices.put(fileType, readerService);
    }

    public Reader getReaderService(String fileType) {
        return readerServices.get(fileType);
    }

}
