package com.wzq.food.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * Title：管理员数据传输对象
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/10/26
 */
@Data
public class AdminDTO implements Serializable {

    private String account;
    @JsonIgnore
    private String password;

}
