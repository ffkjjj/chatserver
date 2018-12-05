package com.iremote.chatserver.vo;

import java.util.Date;

public class BookVO {
    private String bookname;
    private String bookcontent;
    private String bookwebid;
    private String chaptername;
    private Date createtime = new Date();

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    public String getBookwebid() {
        return bookwebid;
    }

    public void setBookwebid(String bookwebid) {
        this.bookwebid = bookwebid;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
