package com.iremote.chatserver.spider;

import com.iremote.chatserver.dao.BookDAO;
import com.iremote.chatserver.dao.BookInfoDAO;
import com.iremote.chatserver.po.BookInfoPO;
import com.iremote.chatserver.po.BookPO;
import com.iremote.chatserver.service.GlobalParameterService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class BiQuGeSpider {
    private String url;
    private String indexPage;
    private Integer endIndex;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private BookInfoDAO bookInfoDAO;
    @Autowired
    private GlobalParameterService globalParameterService;
    private Integer bookInternalId;
    private static final String BOOK_INTERNAL_ID = "bookinternalid";

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
        int index = 1;
        boolean isFirst = true;
        do {
            Document doc = getDocument(indexPage);

            String bookName = doc.body().select("div.con_top > a:nth-child(4)").text();
            Element element = doc.selectFirst("div.bottem2 > a:nth-child(3)");
            String href = element.attr("href");
            String partName = doc.body().select("div.bookname > h1").text();
            Element content = doc.body().getElementById("content");
            endIndex = getEndIndex(href);
            indexPage = href;

            if (isFirst) {
                String s = href.split("/")[1];
                BookInfoPO bookInfo = bookInfoDAO.findByBookwebid(s);
                if (bookInfo != null) {
                    return;
                } else {
                    bookInternalId = globalParameterService.addIntValue(BOOK_INTERNAL_ID);

                    BookInfoPO info = new BookInfoPO();
                    info.setBookinternalid(bookInternalId);
                    info.setBookwebid(s);
                    info.setBookname(bookName);
                    bookInfoDAO.save(info);
                }
                isFirst = false;
            }

            BookPO bookPO = new BookPO();
            bookPO.setBookcontent(content.toString());
            bookPO.setBookname(bookName);
            bookPO.setBookwebid(href);
            bookPO.setChaptername(partName);
            bookPO.setCreatetime(new Date());
            bookPO.setBookinternalid(bookInternalId);
            bookPO.setChapterid(index);
            bookDAO.save(bookPO);

            index ++;
        } while (endIndex <= this.endIndex);
    }

    private Integer getEndIndex(String s){
        return Integer.valueOf(s.split("/")[2].split("\\.")[0]);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }
}
