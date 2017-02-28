package cn.mrx.myPro.controller;

import cn.mrx.myPro.pojo.novel.Novel;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/2/9
 * Description:
 */
@Controller
@RequestMapping("/novel")
public class NovelController {

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String novel(Model model){
        //准备首页数据
        String url = "http://www.biquge.com";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        List<Novel> novels = new ArrayList<Novel>();
        Elements elements = document.select(".novelslist .content ul li");
        for (Element element : elements) {
            Novel novel = new Novel();
            novel.setTitle(element.text().replace("/", "- "));
            novel.setUrl(url + element.select("a").attr("href"));
            novels.add(novel);
            novel.setKind(element.parent().parent().select("h2").text());
        }

        //返回页面数据
        model.addAttribute("novels", novels);
        return "novel/index";
    }

    /**
     * 小说搜索
     * @return
     */
    @RequestMapping(value = "/search")
    public String search(Model model, String q){
        System.out.println("q："+q);
        String url = "http://zhannei.baidu.com/cse/search?s=287293036948159515&q=" + q;
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        List<Novel> novels = new ArrayList<Novel>();
        Elements elements = document.select(".result-list .result-item");
        for (Element element : elements) {
            Novel novel = new Novel();
            novel.setUrl(element.children().select(".result-item-title a").attr("href"));//url
            novel.setImg(element.children().select("a img").attr("src"));//图片
            novel.setTitle(element.children().select(".result-item-title").text());//标题
            novel.setDesc(element.children().select(".result-game-item-desc").text());//小说简介
            novel.setAuthor(element.children().select(".result-game-item-info .result-game-item-info-tag").get(0).text());//作者
            novel.setKind(element.children().select(".result-game-item-info .result-game-item-info-tag").get(1).text());//类型
            novel.setUpdatetime(element.children().select(".result-game-item-info .result-game-item-info-tag").get(2).text());//更新时间
            novel.setNewest(element.children().select(".result-game-item-info .result-game-item-info-tag").get(3).text());//最新章节
            novels.add(novel);
        }
        //返回页面数据
        model.addAttribute("novels", novels);
        model.addAttribute("q", q);
        return "novel/search";
    }

    /**
     * 章节列表
      * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, String url){
        System.out.println("url:"+url);
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        document.setBaseUri(url);
        List<Novel> novels = new ArrayList<Novel>();
        Elements elements = document.select("#list dl dd a");
        for (Element element : elements) {
            Novel novel = new Novel();
            novel.setUrl(element.absUrl("href"));;
            novel.setTitle(element.text());//标题
            novels.add(novel);
        }

        Novel novel = new Novel();
        Elements elements2 = document.select("#info");
        for (Element element : elements2){
            novel.setName(element.select("h1").text());//小说名
            novel.setAuthor(element.select("p").get(0).text().substring(element.select("p").get(0).text().indexOf("：")+1));//小说作者
        }

        //返回页面数据
        model.addAttribute("novels", novels);
        model.addAttribute("novel", novel);
        return "novel/list";
    }

    /**
     * 章节内容
     * @param model
     * @param url
     * @return
     */
    @RequestMapping("/content")
    public String content(Model model, String url){
        System.out.println("url:"+url);
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        document.setBaseUri(url);

        //返回页面数据
        model.addAttribute("title", document.select(".bookname h1").text());
        model.addAttribute("content", document.select("#content").html().replace("<script>readx();</script>", "").replace("&lt;!--over--&gt;", ""));
        model.addAttribute("prev", document.select(".bookname .bottem1 a").get(0).absUrl("href"));
        model.addAttribute("list", document.select(".bookname .bottem1 a").get(1).absUrl("href"));
        model.addAttribute("next", document.select(".bookname .bottem1 a").get(2).absUrl("href"));
        return "novel/content";
    }

    /**
     * 工具类：获取该请求页面的html元素
     * @param url
     * @return
     */
    public String getHtml(String url){
        CloseableHttpResponse httpResponse = null;
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            httpResponse = httpClient.execute(new HttpGet(url));
            String html = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            return html;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
