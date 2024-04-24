package com.ruoyi.system.test;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


/**
 * @packageName: com.ruoyi.system.test
 * @author:
 * @date: 2024/4/7 16:57
 * @description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String url = "http://vdb3.soil.csdb.cn/front/detail-%E6%95%B4%E5%90%88%E6%95%B0%E6%8D%AE%E5%BA%93$integ_cou_soiltype?id=40039";
        Document doc = Jsoup.connect(url).get();
        Elements body = doc.getElementsByTag("body");
        System.out.println(body);
        Elements elementsByClass = doc.getElementsByClass("qy-video-info-tips2");
        System.out.println(elementsByClass);

    }
}