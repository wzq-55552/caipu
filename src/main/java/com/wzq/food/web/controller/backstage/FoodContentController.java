package com.wzq.food.web.controller.backstage;

import com.wzq.food.domain.FoodContent;
import com.wzq.food.service.FoodContentService;
import com.wzq.food.web.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.path.v1}/food/content")
public class FoodContentController {

    @Autowired
    private FoodContentService foodContentService;

    //增加
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public BaseResult insert(FoodContent foodContent){
        if (foodContentService.getByKeyword(foodContent.getKeyword())==null){
            foodContentService.insert(foodContent);
            return BaseResult.success("成功");
        }
        return BaseResult.fail("失败");
    }

    //删除
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(Long id){
        if (foodContentService.getById(id)!=null){
           foodContentService.delete(id);
            return BaseResult.success("成功");
        }
        return BaseResult.fail("失败");
    }

    //修改
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseResult update(FoodContent foodContent){
        if (foodContentService.getById(foodContent.getId())!=null){
            foodContentService.update(foodContent);
            return BaseResult.success("成功");
        }
        return BaseResult.fail("失败");
    }

}
