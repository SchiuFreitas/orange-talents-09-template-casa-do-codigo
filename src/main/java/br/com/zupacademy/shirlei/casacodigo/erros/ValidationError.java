package br.com.zupacademy.shirlei.casacodigo.erros;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldError> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldError fieldError = new FieldError(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldError> getErrors() {
        return fieldErrors;
    }

    public int getNumberOfErrors() {
        return this.globalErrorMessages.size() + this.fieldErrors.size();
    }
}
