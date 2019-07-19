package com.mitrais.codingtest.service;

import com.mitrais.codingtest.model.User;
import com.mitrais.codingtest.repository.UserRepository;
import com.mitrais.codingtest.utils.customHttpResponse.ErrorHttpResponse;
import com.mitrais.codingtest.utils.customHttpResponse.HttpResponse;
import com.mitrais.codingtest.utils.ResponseBody;
import com.mitrais.codingtest.utils.customHttpResponse.SuccessHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpResponse create(User user, HttpServletResponse res) {
        try {
            User userDb;
            try {
                userDb = userRepository.save(user);
            } catch (DataIntegrityViolationException e) {
                return new ErrorHttpResponse(false, 400, "USER_EXISTED", "User has already existed",
                        res);
            }

            ResponseBody responseBody = new ResponseBody();
            responseBody.put("user", userDb);

            // success http response
            return new SuccessHttpResponse(true, 200, "User has been successfully created", res,
                    responseBody.get());

        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorHttpResponse(false, 500, "SYSTEM_ERROR", "An error occurs", res);
        }
    }

}
