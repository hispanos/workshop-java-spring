package com.workshop.workshopmaven.validator.service.validateFiles;

import com.workshop.workshopmaven.validator.model.CsvModelValidator;
import com.workshop.workshopmaven.validator.service.Validator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidatorCsvService extends Validator<CsvModelValidator> {

    @Override
    public boolean validateRow(CsvModelValidator csvModelValidator) {
        return validateEmail(csvModelValidator.getEmail()) && validateDateOfBirth(csvModelValidator.getDateOfBirth()) && validateJobTitle(csvModelValidator.getJobTitle());
    }

    @Override
    public String getType() {
        return "csv";
    }

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static List<String> validJobTitles = Arrays.asList("Haematologist", "Phytotherapist", "Building surveyor", "Insurance account manager", "Educational psychologist");

    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false; // El correo electrónico no puede ser nulo o vacío
        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Validar el Date of birth , se cuenta como linea valida si es mayor al 1980-01-01
    public static boolean validateDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            return false; // La fecha de nacimiento no puede ser nula o vacía
        }
        return dateOfBirth.compareTo("1980-01-01") > 0;
    }

    //Validar el Job Title , si es Haematologist, Phytotherapist, Building surveyor, Insurance
    //account manager, Educational psychologist, si es alguno de estas , se tomara como
    //valida.
    public static boolean validateJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            return false; // El título del trabajo no puede ser nulo o vacío
        }
        return validJobTitles.contains(jobTitle);
    }
}
