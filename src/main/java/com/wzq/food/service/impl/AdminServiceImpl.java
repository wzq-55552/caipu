package com.wzq.food.service.impl;

import com.wzq.food.dao.AdminDao;
import com.wzq.food.domain.Admin;
import com.wzq.food.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    //登录
    public Admin login(Admin admin) {
        Admin admin1 = adminDao.getByAccount(admin.getAccount());

        if (admin1!=null){
            //加密密码
            String md5Password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
            //匹配
            if (md5Password.equals(admin1.getPassword())){
                return admin;
            }
        }

        return null;

    }

}
