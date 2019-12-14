package com.wzq.food.web.controller.api;

import com.wzq.food.domain.FoodContent;
import com.wzq.food.service.FoodContentService;
import com.wzq.food.web.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title：食物api接口
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/11/15
 */
//默认全部都是RequestBody，获取的都是Json数据
@RestController
@RequestMapping(value = "${api.path.v1}/food/content")
public class FoodContentApiController {

    @Autowired
    private FoodContentService foodContentService;

    //返回所有
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public BaseResult selectAll(){

        List<FoodContent> foodContents = foodContentService.selectAll();

        if(foodContents.size()>0){
            return BaseResult.success("成功",foodContents);
        }else{
            return BaseResult.fail("失败");
        }
    }

    //模糊搜索
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public BaseResult search(String keyword){

        List<FoodContent> foodContents = foodContentService.selectByKeyword(keyword);

        if(foodContents.size()>0){
            return BaseResult.success("成功",foodContents);
        }else{
            return BaseResult.fail("失败");
        }
    }

}
