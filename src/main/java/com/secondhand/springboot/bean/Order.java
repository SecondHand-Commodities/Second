package com.secondhand.springboot.bean;

import java.util.Date;

/**
 * @author rzw
 * @create 2019-12-13-16:35
 */

public class Order {

    private String oid;
    private String pid;
    private String id;
    private Date oDate;
    private Integer oState;

    public String getOid() {
        return oid;
    }

    public String getPid() {
        return pid;
    }

    public String getId() {
        return id;
    }

    public Date getoDate() {
        return oDate;
    }

    public int getoState() {
        return oState;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public void setoState(int oState) {
        this.oState = oState;
    }
}
