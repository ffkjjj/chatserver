package com.iremote.chatserver.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="bookinfo")
public class BookInfoPO {
    private Integer bookinfoid;
    private String bookwebid;
    private Integer bookinternalid;
    private String bookname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "generator", strategy = "increment")
    public Integer getBookinfoid() {
        return bookinfoid;
    }

    public void setBookinfoid(Integer bookinfoid) {
        this.bookinfoid = bookinfoid;
    }

    public String getBookwebid() {
        return bookwebid;
    }

    public void setBookwebid(String bookwebid) {
        this.bookwebid = bookwebid;
    }

    public Integer getBookinternalid() {
        return bookinternalid;
    }

    public void setBookinternalid(Integer bookinternalid) {
        this.bookinternalid = bookinternalid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
