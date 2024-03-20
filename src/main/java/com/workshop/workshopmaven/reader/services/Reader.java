package com.workshop.workshopmaven.reader.services;

import com.workshop.workshopmaven.reader.model.ResponseReader;
import com.workshop.workshopmaven.reader.util.Connection;
import java.io.IOException;

public abstract class Reader {

    protected Connection connection = new Connection();
    protected Integer validLines = 0;
    protected Integer invalidLines = 0;
    protected ResponseReader responseReader;

    public abstract ResponseReader readerFile(String urlFile) throws IOException;

}
