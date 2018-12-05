package com.iremote.chatserver.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookInfoPO {
    private Integer bookinfoid;
    private String bookwebid;
    private Integer bookinternalid;

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
}
