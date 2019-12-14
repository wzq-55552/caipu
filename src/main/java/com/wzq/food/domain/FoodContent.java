package com.wzq.food.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Title：菜javabean
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/10/26
 */
@Data
public class FoodContent implements Serializable {

    private Long id;

    //关键词
    private String keyword;
    //步骤
    private String step;
    //图片链接
    private String url;

}
