package com.workshop.workshopmaven.reader.services.readerFiles;

import com.opencsv.bean.CsvToBeanBuilder;
import com.workshop.workshopmaven.reader.model.CsvModel;
import com.workshop.workshopmaven.reader.model.ResponseReader;
import com.workshop.workshopmaven.reader.services.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderCsvService extends Reader {

    @Override
    public ResponseReader readerFile(String urlFile) throws IOException {
        List<CsvModel> elements = new CsvToBeanBuilder(new FileReader(urlFile))
                .withType(CsvModel.class)
                .build()
                .parse();

        elements.forEach((element) -> {
            boolean response = this.connection.webClient().post().uri("validateData/csv")
                    .bodyValue(element).retrieve()
                    .bodyToMono(boolean.class).block();
            System.out.println(response);
            if (!response) {
                this.invalidLines++;
            }else {
                this.validLines++;
            }
        });

        ResponseReader responseReader = new ResponseReader(this.validLines, this.invalidLines);
        return responseReader;
    }
}
