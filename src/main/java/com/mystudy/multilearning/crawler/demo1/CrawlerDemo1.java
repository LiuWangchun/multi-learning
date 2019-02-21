package com.mystudy.multilearning.crawler.demo1;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CrawlerDemo1
 * @Description TODO
 * @Author MrLiu
 */
public class CrawlerDemo1 {

    public static void main(String[] args) throws IOException {
//        testGet();

        testPost();
    }

    public static void testGet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://cn.bing.com/");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200) {
            String content = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(content);
        }
        if (response != null) {
            response.close();
        }
    }

    public static void testPost() throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpGet请求
        HttpPost httpPost = new HttpPost("https://cn.bing.com/");

        //声明存放参数的List集合
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("pd", "java"));

        //创建表单数据Entity
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"UTF-8");

        //设置表单Entity到httpPost请求对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        //使用HttpClient发起请求
        response = httpClient.execute(httpPost);
        //判断响应状态码是否为200
        if(response.getStatusLine().getStatusCode() == 200) {
            //如果为200表示请求成功，获取返回数据
            String content = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(content);
        }
        if (response != null) {
            //释放连接
            response.close();
        }
    }
}
