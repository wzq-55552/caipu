package com.wzq.food.service;

import com.wzq.food.domain.FoodContent;

import java.util.List;

public interface FoodContentService {
    //模糊搜索
    List<FoodContent> selectByKeyword(String keyword);

    //查询所有
    List<FoodContent> selectAll();

    //增加数据
    void insert(FoodContent foodContent);

    //修改数据
    void update(FoodContent foodContent);

    //删除
    void delete(Long id);

    FoodContent getByKeyword(String keyword);

    FoodContent getById(Long id);
}
