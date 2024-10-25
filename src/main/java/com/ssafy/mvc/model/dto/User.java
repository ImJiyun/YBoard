package com.ssafy.mvc.model.dto;

import java.util.Date;

public class User {
    private int id;
    private String name, email, password;
    private Date createdAt, updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 필수 항목입니다.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("이메일은 필수 항목입니다.");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 필수 항목입니다.");
        }
//        if (password.length() < 8 || password.length() > 20) {
//            throw new IllegalArgumentException("비밀번호는 8자 이상 20자 이하로 설정해야 합니다.");
//        }
//        if (!password.matches(".*[A-Z].*")) {
//            throw new IllegalArgumentException("비밀번호에는 최소 한 개의 대문자가 포함되어야 합니다.");
//        }
//        if (!password.matches(".*[a-z].*")) {
//            throw new IllegalArgumentException("비밀번호에는 최소 한 개의 소문자가 포함되어야 합니다.");
//        }
//        if (!password.matches(".*[0-9].*")) {
//            throw new IllegalArgumentException("비밀번호에는 최소 한 개의 숫자가 포함되어야 합니다.");
//        }
//        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
//            throw new IllegalArgumentException("비밀번호에는 최소 한 개의 특수문자가 포함되어야 합니다.");
//        }
//        if (password.contains(" ")) {
//            throw new IllegalArgumentException("비밀번호에는 공백을 포함할 수 없습니다.");
//        }
        this.password = password;
    }



    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
