package com.wzq.food.web.controller.backstage;

import com.wzq.food.domain.FeedBack;
import com.wzq.food.service.FeedBackService;
import com.wzq.food.web.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "${api.path.v1}/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    //管理员删除
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(Long id){
        if (feedBackService.getById(id)!=null){
            feedBackService.delete(id);
            return BaseResult.success("成功");
        }
        return BaseResult.fail("失败");
    }

    //用户增
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public BaseResult insert(FeedBack feedBack){
        feedBackService.insert(feedBack);
        return BaseResult.success("成功");
    }

}
