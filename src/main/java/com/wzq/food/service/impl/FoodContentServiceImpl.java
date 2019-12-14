package com.wzq.food.service.impl;

import com.wzq.food.dao.FoodContentDao;
import com.wzq.food.domain.FoodContent;
import com.wzq.food.service.FoodContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FoodContentServiceImpl implements FoodContentService {

    @Autowired
    private FoodContentDao foodContentDao;

    public List<FoodContent> selectByKeyword(String keyword) {
        return foodContentDao.selectByKeyword(keyword);
    }

    @Transactional(readOnly = false)
    public void insert(FoodContent foodContent) {
        foodContentDao.insert(foodContent);
    }

    @Transactional(readOnly = false)
    public void update(FoodContent foodContent) {
        foodContentDao.update(foodContent);
    }

    public List<FoodContent> selectAll() {
        return foodContentDao.selectAll();
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        foodContentDao.delete(id);
    }

    public FoodContent getByKeyword(String keyword) {
        return foodContentDao.getByKeyword(keyword);
    }

    public FoodContent getById(Long id) {
        return foodContentDao.getById(id);
    }
}
