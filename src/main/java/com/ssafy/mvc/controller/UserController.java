package com.ssafy.mvc.controller;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        try {
            if(userService.signup(user)) {
                response.put("success", "회원가입 성공했습니다.");
                return ResponseEntity.ok(response);
            } else{
                response.put("fail", "중복된 이메일 입니다.");
                return ResponseEntity.ok(response);
            }

        } catch (IllegalArgumentException e) {
            response.put("error", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PostMapping("/login")
    public Map<String, String> Login(@RequestBody User user, HttpServletRequest request) {
        User loginUser = userService.login(user.getEmail(),user.getPassword());
        Map<String, String> response = new HashMap<>();

        if(loginUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            response.put("name", loginUser.getName());

        } else {
            response.put("error","다시 로그인 해주세요.");

        }
        return response;
    }
}
