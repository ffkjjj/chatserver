package com.iremote.chatserver.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book")
public class BookPO {
    private Integer bookid;
    private String bookname;
    private String bookcontent;
    private String bookwebid;
    private Integer bookinternalid;
    private Integer chapterid;
    private String chaptername;
    private Date createtime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "generator", strategy = "increment")
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public Integer getBookinternalid() {
        return bookinternalid;
    }

    public void setBookinternalid(Integer bookinternalid) {
        this.bookinternalid = bookinternalid;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }
}
