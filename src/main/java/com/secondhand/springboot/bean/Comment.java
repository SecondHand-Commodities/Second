package com.secondhand.springboot.bean;

import java.util.Date;

/**
 * @author rzw
 * @create 2019-12-13-16:31
 */
public class Comment {
    private String cid;
    private String aId;
    private String bId;
    private String comment;
    private Date cDate;

    public String getCid() {
        return cid;
    }

    public String getaId() {
        return aId;
    }

    public String getbId() {
        return bId;
    }

    public String getComment() {
        return comment;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }
}
