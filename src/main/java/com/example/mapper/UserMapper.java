package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer SelectById_integral(Integer user_id) ;
    void Update_integral(Integer user_id,Integer current_integral);
}
