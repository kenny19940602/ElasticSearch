package com.kenny.util;

import com.kenny.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HtmlParseUtil
 * Function:  TODO
 * Date:      2020/5/31 19:47
 *
 * @author Kenny
 * version    V1.0
 */
@Component
public class HtmlParseUtil {

    public static void main(String[] args) throws Exception {
//        parseJD("java").forEach(System.out::println);

    }

    public  List<Content> parseJD(String keyword) throws Exception {
        //获取请求 https://search.jd.com/Search?keyword=java&enc=utf-8&wq=java&pvid=17c4a61c7de8471e92a7a9e210be8512
        String url = "https://search.jd.com/Search?keyword="+keyword+"&enc=utf-8&wq="+keyword+"&pvid=17c4a61c7de8471e92a7a9e210be8512";
        //解析网页
        Document document = Jsoup.parse(new URL(url), 30000);
        Element goodList = document.getElementById("J_goodsList");
        Elements elements = goodList.getElementsByTag("li");
        ArrayList<Content> list = new ArrayList<>(elements.size());
        for (Element e : elements) {
            String img = e.getElementsByTag("img").eq(0).attr("src");
            String price = e.getElementsByClass("p-price").eq(0).text();
            String title = e.getElementsByClass("p-name").eq(0).text();
            Content content = new Content(title, img, price);
            list.add(content);
        }
        return list;
    }
}
