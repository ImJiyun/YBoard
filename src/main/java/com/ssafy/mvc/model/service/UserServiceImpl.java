package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.mapper.UserMapper;
import com.ssafy.mvc.model.mapper.UserSecuInfoMapper;
import com.ssafy.mvc.util.OpenCrypt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserSecuInfoMapper userSecuInfoMapper;

    public UserServiceImpl(UserMapper userMapper, UserSecuInfoMapper userSecuInfoMapper) {
        this.userMapper = userMapper;
        this.userSecuInfoMapper = userSecuInfoMapper;
    }

    @Override
    public boolean signup(User user) {
        int count = userMapper.countEmail(user.getEmail());
        if(count>0) {
            return false;
        } else{
            String salt = UUID.randomUUID().toString();
            String hashPw = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(user.getPassword(), salt));
            user.setPassword(hashPw);
            userMapper.inserUser(user);

            Map<String,String> info = new HashMap<>();
            info.put("email", user.getEmail());
            info.put("salt", salt);
            userSecuInfoMapper.insertInfo(info);
            return true;
        }

    }

    @Override
    public User login(String email, String password) {
        String salt = userSecuInfoMapper.selectSalt(email);
        String hashPw = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(password, salt));

        Map<String,String> info = new HashMap<>();
        info.put("email", email);
        info.put("password", hashPw);
        return userMapper.login(info);
    }
}
