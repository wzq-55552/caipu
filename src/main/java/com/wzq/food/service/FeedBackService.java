package com.wzq.food.service;

import com.wzq.food.domain.FeedBack;

import java.util.List;

public interface FeedBackService {

    List<FeedBack> selectAll();

    void insert(FeedBack feedBack);

    void delete(Long id);

    FeedBack getById(Long id);
}
