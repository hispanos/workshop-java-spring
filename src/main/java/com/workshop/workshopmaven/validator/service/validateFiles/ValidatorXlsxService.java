package com.workshop.workshopmaven.validator.service.validateFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.workshopmaven.validator.model.XlsxRequestModelValidator;
import com.workshop.workshopmaven.validator.service.Validator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ValidatorXlsxService extends Validator<XlsxRequestModelValidator> {

    private static List<String> validReportTypes = Arrays.asList("Near Miss", "Lost Time", "First Aid");

    @Override
    public boolean validateRow(XlsxRequestModelValidator xlsxModelValidator) {
        return validateInjuryLocation(xlsxModelValidator.getInjuryLocation()) && validateReportType(xlsxModelValidator.getReportType());
    }

    @Override
    public String getType() {
        return "xlsx";
    }

    //Validar el Injury Location que sea diferente de N/A
    public static boolean validateInjuryLocation(String injuryLocation) {
        return !injuryLocation.equals("N/A");
    }

    //Validar el Report Type solo se deben aceptar (Near Miss, Lost Time, First Aid)
    public static boolean validateReportType(String reportType) {
        return validReportTypes.contains(reportType);
    }
}
