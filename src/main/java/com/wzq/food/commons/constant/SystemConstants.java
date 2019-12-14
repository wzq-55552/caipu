package com.wzq.food.commons.constant;

/**
 * Title：系统常量
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/10/27
 */
public class SystemConstants {

    //主机地址，后期改成阿里云
    public static final String  HOST = "http://localhost:8080/api/v1";

    //菜谱内容查询地址
    public static final String API_CONTENTS_FOODALL = HOST + "/food/content/all";

    //反馈内容查询地址
    public static final String API_CONTENTS_FEEDALL = HOST + "/feedback/all";
}
