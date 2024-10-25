package com.ssafy.mvc.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserSecuInfoMapper {

    void insertInfo(Map<String, String> info);

    String selectSalt(String email);
}
