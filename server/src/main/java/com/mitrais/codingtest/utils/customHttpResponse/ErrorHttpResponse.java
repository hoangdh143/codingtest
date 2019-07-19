package com.mitrais.codingtest.utils.customHttpResponse;


import lombok.Data;

import javax.servlet.http.HttpServletResponse;

@Data
public class ErrorHttpResponse extends HttpResponse {
    private String errorCode;

    public ErrorHttpResponse(Boolean successStatus, int statusCode, String errorCode, String message,
                             HttpServletResponse res) {
        super(successStatus, statusCode, message, res);
        this.errorCode = errorCode;
    }

}
