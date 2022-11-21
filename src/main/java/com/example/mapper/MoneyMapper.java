package com.example.mapper;

import com.example.domain.money;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoneyMapper {
    public money SelectById(Integer id);                //查找捐款目标并返回对应数据
    public void Update(Integer id,Integer update_current);     //更新数据库，如果捐款进度满了？

    public List<money> Select_All(Integer pageNum,Integer pageSize);
}
