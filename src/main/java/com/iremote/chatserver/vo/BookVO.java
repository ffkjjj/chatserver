package com.iremote.chatserver.vo;

public class BookVO {
    private String bookname;
    private String bookcontent;
    private String charptername;
    private Integer index;

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

    public String getCharptername() {
        return charptername;
    }

    public void setCharptername(String charptername) {
        this.charptername = charptername;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
