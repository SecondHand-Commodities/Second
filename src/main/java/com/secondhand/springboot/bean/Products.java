package com.secondhand.springboot.bean;

import java.util.Date;

/**
 * @author rzw
 * @create 2019-12-13-16:40
 */
public class Products {
    private String pid;
    private Person perId;
    private String pName;
    private Double pPrice;
    private String pPhoto;
    private Integer pState;
    private String pDescription;
    private Date createtime;

    public void setPerId(Person perId) {
        this.perId = perId;
    }

    public Person getPerId() {

        return perId;
    }

    public String getPid() {
        return pid;
    }


    public String getpName() {
        return pName;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public Integer getpState() {
        return pState;
    }

    public String getpDescription() {
        return pDescription;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public void setpState(Integer pState) {
        this.pState = pState;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
