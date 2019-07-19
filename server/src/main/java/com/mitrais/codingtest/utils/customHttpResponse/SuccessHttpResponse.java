package com.mitrais.codingtest.utils.customHttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;

@Data
public class SuccessHttpResponse extends HttpResponse {
    private JsonNode data;

    public SuccessHttpResponse(Boolean successStatus, int statusCode, String message,
                               HttpServletResponse res, JsonNode data) {
        super(successStatus, statusCode, message, res);
        this.data = data;
    }
}
