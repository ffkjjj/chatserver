package com.iremote.chatserver.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="globalparameter")
public class GlobalParameterPO {
    private String globalid;
    private Integer intvalue;
    private String strvalue;

    @Id
    public String getGlobalid() {
        return globalid;
    }

    public void setGlobalid(String globalid) {
        this.globalid = globalid;
    }

    public Integer getIntvalue() {
        return intvalue;
    }

    public void setIntvalue(Integer intvalue) {
        this.intvalue = intvalue;
    }

    public String getStrvalue() {
        return strvalue;
    }

    public void setStrvalue(String strvalue) {
        this.strvalue = strvalue;
    }
}
