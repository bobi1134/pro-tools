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
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/2/9
 * Description:爬虫测试
 */
public class TestNovel {


    /**
     * 以笔趣阁为例
     * 解析首页推荐
     */
    @Test
    public void test01(){
        String url = "http://www.biquge.com";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
//        document.setBaseUri(url);
        List<Novel> novels = new ArrayList<Novel>();
        Elements elements = document.select(".novelslist .content ul li");
        for (Element element : elements) {
            Novel novel = new Novel();
            novel.setTitle(element.text().replace("/", "- "));
            novel.setUrl(url + element.select("a").attr("href"));
            novels.add(novel);
            novel.setKind(element.parent().parent().select("h2").text());
        }

        for (Novel novel : novels){
            System.out.println(novel);
        }
    }

    /**
     * 以笔趣阁为例
     * 解析章节列表
     */
    @Test
    public void test02(){
        String url = "http://www.biquge.com/0_161/";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
//        document.setBaseUri(url);
        Elements elements = document.select("#list dl dd a");
        for (Element element : elements) {
            System.out.println(element.text() +","+ element.absUrl("href"));
        }
    }

    /**
     * 以笔趣阁为例
     * 解析搜索结果
     */
    @Test
    public void test03(){
        String url = "http://zhannei.baidu.com/cse/search?s=287293036948159515&q=" + "很纯";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
//        document.setBaseUri(url);
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

        for (Novel novel : novels){
            System.out.println(novel);
        }
    }

    /**
     * 以笔趣阁为例
     * 解析章节列表
     */
    @Test
    public void test04(){
        String url = "http://www.biquge.com/1_1819/";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        document.setBaseUri(url);
        List<Novel> novels = new ArrayList<Novel>();
//        Elements elements = document.select("#list dl dd a");
//        for (Element element : elements) {
//            Novel novel = new Novel();
//            novel.setUrl(element.absUrl("href"));;
//            novel.setTitle(element.text());//标题
//            novels.add(novel);
//        }
//
//        for (Novel novel : novels){
//            System.out.println(novel);
//        }

        Elements elements2 = document.select("#info");
        for (Element element : elements2){
            System.out.println(element.select("h1").text());
            System.out.println(element.select("p").get(0).text().substring(element.select("p").get(0).text().indexOf("：")+1));
        }
    }

    /**
     * 以笔趣阁为例
     * 解析章节内容
     */
    @Test
    public void test05(){
        String url = "http://www.biquge.com/0_630/1634002.html";
        String html = getHtml(url);
        Document document = Jsoup.parse(html);
        document.setBaseUri(url);
        List<Novel> novels = new ArrayList<Novel>();

//        System.out.println(document.select(".bookname h1").text());
//        System.out.println(document.select("#content").html());
//        System.out.println(document.select("#content").html().replace("<script>readx();</script>\uFEFF\n<br>", ""));
        System.out.println(document.select("#content").html().substring(0,"<script>readx();</script>\uFEFF\n<br>".length()));
//        System.out.println(document.select(".bookname .bottem1 a").get(0).absUrl("href"));
//        System.out.println(document.select(".bookname .bottem1 a").get(1).absUrl("href"));
//        System.out.println(document.select(".bookname .bottem1 a").get(2).absUrl("href"));
    }


    /**
     *
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

    @Test
    public void testtt(){
        System.out.println("作    者：鱼人二代".substring("作    者：鱼人二代".indexOf("：")+1));
    }

}
