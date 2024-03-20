package com.workshop.workshopmaven.reader.services;

import com.workshop.workshopmaven.reader.exception.FileException;
import com.workshop.workshopmaven.reader.model.ResponseReader;
import com.workshop.workshopmaven.reader.util.MapFiles;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private Reader readerServices;

    public ResponseReader processFile(String urlFile) {
        String fileType = urlFile.substring(urlFile.lastIndexOf(".") + 1);
        readerServices = new MapFiles().getReaderService(fileType);
        if (readerServices == null) {
            throw new FileException("File type not supported");
        }
        try {
            return readerServices.readerFile(urlFile);
        } catch (Exception e) {
            throw new FileException("Ocurred a problem reading the file");
        }
    }

}
