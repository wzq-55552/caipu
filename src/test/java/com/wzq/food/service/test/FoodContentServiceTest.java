package com.wzq.food.service.test;

import com.wzq.food.commons.utils.HttpClientUtils;
import com.wzq.food.commons.utils.MapperUtils;
import com.wzq.food.dao.FoodContentDao;
import com.wzq.food.domain.FeedBack;
import com.wzq.food.domain.FoodContent;
import com.wzq.food.service.FeedBackService;
import com.wzq.food.service.FoodContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class FoodContentServiceTest {

    @Autowired
    private FoodContentDao foodContentDao;

    @Autowired
    private FoodContentService foodContentService;

    @Autowired
    private FeedBackService feedBackService;

    @Test
    public void test(){

    }

    //md5加密
    @Test
    public void testmd5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }

    //获取网上数据
    @Test
    public void testdata(){
        List<FoodContent> foodContentList = null;
        String result = HttpClientUtils.doGet("http://101.132.227.53:8080/api/v1/food/content/all");
        try {
            foodContentList = MapperUtils.json2listByTree(result,"data",FoodContent.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (FoodContent foodContent : foodContentList) {
            System.out.println(foodContent.toString());
        }

    }
}
