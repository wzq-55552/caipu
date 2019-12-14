package com.wzq.food.web.controller.api;


import com.wzq.food.domain.FeedBack;
import com.wzq.food.service.FeedBackService;
import com.wzq.food.web.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title：反馈api接口
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/11/15
 */
@RestController
@RequestMapping(value = "${api.path.v1}/feedback")
public class FeedBackApiController {

    @Autowired
    private FeedBackService feedBackService;

    //返回所有
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public BaseResult selectAll(){

        List<FeedBack> feedBacks = feedBackService.selectAll();

        if(feedBacks.size()>0){
            return BaseResult.success("成功",feedBacks);
        }else{
            return BaseResult.fail("失败");
        }
    }


}
