package com.mitrais.codingtest.utils.validator;

import lombok.Data;

@Data
public class ValidationError extends Error {
    private static final long serialVersionUID = 1L;
    private String field;
    private String errorMessage;

    public ValidationError(String field, String errorMessage) {
        super();
        this.field = field;
        this.errorMessage = errorMessage;
    }
}
