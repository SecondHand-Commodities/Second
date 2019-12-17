package com.secondhand.springboot.bean;

import java.util.Date;

/**
 * @author rzw
 * @create 2019-12-13-16:35
 */

public class Order {

    private String oid;
    private Products pid;
    private Person id;
    private Date oDate;
    private Integer oState;

    public void setPid(Products pid) {
        this.pid = pid;
    }

    public Products getPid() {

        return pid;
    }

    public Person getId() {
        return id;
    }

    public void setId(Person id) {
        this.id = id;
    }

    public void setoState(Integer oState) {
        this.oState = oState;
    }

    public String getOid() {
        return oid;
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

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }
}
