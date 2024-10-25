package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.User;

public interface UserService {
    boolean signup(User user);

    User login(String email, String password);
}
