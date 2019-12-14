package com.wzq.food.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Title：管理员
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/11/15
 */
@Data
public class Admin implements Serializable {

    private String account;

    private String password;

}
