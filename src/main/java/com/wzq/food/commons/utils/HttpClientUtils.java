package com.wzq.food.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Title：HttpClient工具类
 * Description：
 * @author WZQ
 * @version 1.0.0
 * @date 2019/10/25
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";
    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";

    /**
     * get请求
     * @return
     */
    public static String doGet(String url){
        return createRequest(url,GET,null);
    }

    //带cookie
    public static String doGet(String url,String cookie){
        return createRequest(url,GET,cookie);
    }

    /**
     * post请求
     * @return params可选参数
     */
    public static String doPost(String url,BasicNameValuePair... params){
        return createRequest(url,POST,null,params);
    }

    //带cookie
    public static String doPost(String url,String cookie,BasicNameValuePair... params){
        return createRequest(url,POST,cookie,params);
    }

    /**
     * 创建请求
     * @param url 地址
     * @param requestMethod 方式
     * @param cookie cookie
     * @param params 请求参数 仅限于POST
     * @return
     */
    //带cookie
    private static String createRequest(String url, String requestMethod,String cookie, BasicNameValuePair... params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求结果
        String result = null;

        try{

           result = null;

            //请求方式
            HttpGet httpGet = null;
            HttpPost httpPost = null;

            //响应
            CloseableHttpResponse httpResponse = null;

            if (GET.equals(requestMethod)){//GET
                httpGet = new HttpGet(url);
                // 设置长连接
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                // 设置 Cookie
                httpGet.setHeader("Cookie", cookie);

                httpResponse = httpClient.execute(httpGet);
            }else if (POST.equals(requestMethod)){//POST
                httpPost = new HttpPost(url);
                // 设置长连接
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                // 设置 Cookie
                httpPost.setHeader("Cookie", cookie);

                if (params!=null&&params.length>0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params),"UTF-8"));
                }

                httpResponse = httpClient.execute(httpPost);
            }

            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }


}
