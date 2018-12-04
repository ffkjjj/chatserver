package ml.myll.web.vo;

import java.util.Date;

public class ContentVO {
    private String content;
    private String autor;
    private Date creastedate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getCreastedate() {
        return creastedate;
    }

    public void setCreastedate(Date creastedate) {
        this.creastedate = creastedate;
    }
}
