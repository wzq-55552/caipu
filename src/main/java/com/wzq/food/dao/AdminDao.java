package com.wzq.food.dao;

import com.wzq.food.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    //登录
    Admin getByAccount(String account);

}
