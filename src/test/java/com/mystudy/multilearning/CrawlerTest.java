package com.mystudy.multilearning;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName CrawlerTest
 * @Description TODO
 * @Author MrLiu
 */
public class CrawlerTest {

    @Test
    public void testjsoup() throws IOException {
        //    解析url地址
        Document document = Jsoup.parse(new URL("https://cn.bing.com/"), 1000);

        //获取title的内容
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }
}
