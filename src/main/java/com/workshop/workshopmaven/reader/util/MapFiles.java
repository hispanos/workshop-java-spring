package com.workshop.workshopmaven.reader.util;

import com.workshop.workshopmaven.reader.services.Reader;
import com.workshop.workshopmaven.reader.services.readerFiles.ReaderCsvService;
import com.workshop.workshopmaven.reader.services.readerFiles.ReaderXlsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapFiles {

    static List<Reader> reader;

    @Autowired
    public MapFiles(List<Reader> reader) {
        this.reader = reader;
    }

    public static Reader getReaderService(String fileType) {
        return reader.stream().filter(readerService -> readerService.getType().equals(fileType)).findFirst().orElse(null);
    }

}
