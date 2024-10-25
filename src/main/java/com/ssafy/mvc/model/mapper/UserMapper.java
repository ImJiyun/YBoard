package com.ssafy.mvc.model.mapper;

import com.ssafy.mvc.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    int countEmail(String email);

    void inserUser(User user);

    User login(Map<String, String> info);
}
