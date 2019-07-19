package com.mitrais.codingtest.utils.customHttpResponse;


import lombok.Data;

import javax.servlet.http.HttpServletResponse;

@Data
public class HttpResponse {
    private Boolean success;
    private int statusCode;
    private String message;

    public HttpResponse(Boolean successStatus, int statusCode, String message, HttpServletResponse res) {
        super();
        this.success = successStatus;
        this.statusCode = statusCode;
        this.message = message;

        setHttpStatusCode(res);
    }

    private void setHttpStatusCode(HttpServletResponse res) {
        if (res == null) return;
        res.setStatus(statusCode);
    }
}
