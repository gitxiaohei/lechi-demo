package com.lechidemo.producer.dao;
import com.lechidemo.producer.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface Userdao {
    User login(@Param("name") String username, @Param("password") String password);
}
