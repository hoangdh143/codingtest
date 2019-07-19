package com.mitrais.codingtest.utils.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.mitrais.codingtest.utils.customHttpResponse.ErrorHttpResponse;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;

@Data
public class ValidationErrorHttpResponse extends ErrorHttpResponse {
    private JsonNode validationError;

    public ValidationErrorHttpResponse(Boolean successStatus, int statusCode, String errorCode, String message,
                                       HttpServletResponse res, JsonNode validationError) {
        super(successStatus, statusCode, errorCode, message, res);

        this.validationError = validationError;
    }

}
