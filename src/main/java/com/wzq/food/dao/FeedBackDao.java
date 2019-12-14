package com.wzq.food.dao;

import com.wzq.food.domain.FeedBack;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackDao {

    List<FeedBack> selectAll();

    void insert(FeedBack feedBack);

    void delete(Long id);

    FeedBack getById(Long id);
}
