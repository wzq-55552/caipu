package com.wzq.food.dao;

import com.wzq.food.domain.FoodContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodContentDao {

    //查询所有
    List<FoodContent> selectAll();

    //模糊搜索
    List<FoodContent> selectByKeyword(String keyword);

    //增加数据
    void insert(FoodContent foodContent);

    //修改数据
    void update(FoodContent foodContent);

    //删除数据
    void delete(Long id);

    FoodContent getByKeyword(String keyword);

    FoodContent getById(Long id);
}
