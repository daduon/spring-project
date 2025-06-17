package com.helper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.helper.model.User;

@Mapper
public interface UserMapper {
    User findByUsername(@Param("username") String username);
}