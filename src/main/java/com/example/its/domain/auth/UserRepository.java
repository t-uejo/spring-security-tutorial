package com.example.its.domain.auth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("SELECT username, password FROM users WHERE username = #{username}")
    Optional<UserEntity> findByUsername(@Param("username") String username);

    @Select("SELECT * FROM users;")
    List<UserEntity> findAll();

    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password});")
    void create(@Param("username") String username, @Param("password") String password);
}
