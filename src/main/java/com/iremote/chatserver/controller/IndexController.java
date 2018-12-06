package com.iremote.chatserver.controller;

import com.iremote.chatserver.dao.BookDAO;
import com.iremote.chatserver.po.BookPO;
import com.iremote.chatserver.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private BookDAO bookDAO;

    @RequestMapping("/")
    public String index(){
        return "index/index";
    }

    @RequestMapping("/getbook")
    @ResponseBody
    public BookVO getBook(Integer index){
        if (index == null) {
            index = 1;
        }
        BookPO bookPO = bookDAO.findByBookinternalidAndChapterid(1, index);
        BookVO book = new BookVO();
        book.setBookname(bookPO.getBookname());
        book.setBookcontent(bookPO.getBookcontent());
        book.setCharptername(bookPO.getChaptername());
        book.setIndex(index);
        return book;
    }

}
