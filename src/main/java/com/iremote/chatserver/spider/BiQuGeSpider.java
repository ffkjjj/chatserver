package com.iremote.chatserver.spider;

import com.iremote.chatserver.vo.BookVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

public class BiQuGeSpider {
    private String url;
    private String indexPage;
    private Integer endIndex;

    public BiQuGeSpider(String url, String indexPage, Integer endIndex) {
        this.url = url;
        this.indexPage = indexPage;
        this.endIndex = endIndex;
    }

    private Document getDocument(String indexPage) {
        try {
            System.out.println(url+indexPage);
            Document doc = Jsoup.connect(url + indexPage)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36")
                    .timeout(3000)
                    .get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }

    public void start(){
        if (this.endIndex == null) {
            return;
        }
        Integer endIndex;

        do {
            Document doc = getDocument(indexPage);

            String bookName = doc.body().select("div.con_top > a:nth-child(4)").text();
            Element element = doc.selectFirst("div.bottem2 > a:nth-child(3)");
            String href = element.attr("href");
            String partName = doc.body().select("div.bookname > h1").text();
            Element content = doc.body().getElementById("content");
            endIndex = getEndIndex(href);
            indexPage = href;

            BookVO bookVO = new BookVO();
            bookVO.setBookcontent(content.toString());
            bookVO.setBookname(bookName);
            bookVO.setBookwebid(href);
            bookVO.setChaptername(partName);
            bookVO.setCreatetime(new Date());

        } while (endIndex <= this.endIndex);
    }

    private Integer getEndIndex(String s){
        return Integer.valueOf(s.split("/")[2].split("\\.")[0]);
    }
}
