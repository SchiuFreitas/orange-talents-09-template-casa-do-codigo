package br.com.zupacademy.shirlei.casacodigo.erros;

public class FieldError {
    private String field;
    private String message;

    FieldError() { }

    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
