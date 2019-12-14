package com.wzq.food.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * Title：反馈
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/11/15
 */
@Data
public class FeedBack implements Serializable {

    private Long id;

    private String content;

}
