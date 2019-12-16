package com.secondhand.springboot.bean;

import java.util.Date;

/**
 * @author rzw
 * @create 2019-12-13-16:31
 */
public class Comment {
    private String cid;
    private Person perAId;
    private Person perBId;
    private String comment;
    private Date cDate;

    public void setPerAId(Person perAId) {
        this.perAId = perAId;
    }

    public void setPerBId(Person perBId) {
        this.perBId = perBId;
    }

    public Person getPerAId() {
        return perAId;
    }

    public Person getPerBId() {
        return perBId;
    }

    public String getCid() {
        return cid;
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


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }
}
