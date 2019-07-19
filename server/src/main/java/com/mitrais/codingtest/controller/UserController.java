package com.mitrais.codingtest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mitrais.codingtest.model.User;
import com.mitrais.codingtest.service.UserService;
import com.mitrais.codingtest.utils.customHttpResponse.HttpResponse;
import com.mitrais.codingtest.utils.validator.ValidationErrorHttpResponse;
import com.mitrais.codingtest.utils.validator.ValidationErrorProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public HttpResponse create(@Valid @RequestBody User user, BindingResult bindingResult, HttpServletRequest req,
                               HttpServletResponse res) {
        JsonNode bindingError = ValidationErrorProcess.run(bindingResult);
        if (bindingError != null) {
            return new ValidationErrorHttpResponse(false, 400, "INVALID_INFO", "Invalid field(s)",
                    res, bindingError);
        }

        return userService.create(user, res);
    }
}
