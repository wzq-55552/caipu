package com.wzq.food.web.controller.api;

import com.wzq.food.domain.Admin;
import com.wzq.food.service.AdminService;
import com.wzq.food.web.dto.AdminDTO;
import com.wzq.food.web.dto.BaseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.path.v1}/admin")
public class AdminApiController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param admin
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(Admin admin){
        Admin admin1 = adminService.login(admin);
        if (admin1 == null){
            return BaseResult.fail("账号或密码错误！");
        }else{
            AdminDTO dto = new AdminDTO();
            BeanUtils.copyProperties(admin1,dto);
            return BaseResult.success("成功",dto);
        }
    }
}
