package com.wzq.food.service.impl;

import com.wzq.food.dao.FeedBackDao;
import com.wzq.food.domain.FeedBack;
import com.wzq.food.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackDao feedBackDao;

    public List<FeedBack> selectAll() {
        return feedBackDao.selectAll();
    }

    @Transactional(readOnly = false)
    public void insert(FeedBack feedBack) {
        feedBackDao.insert(feedBack);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        feedBackDao.delete(id);
    }

    public FeedBack getById(Long id){
        return feedBackDao.getById(id);
    }
}
