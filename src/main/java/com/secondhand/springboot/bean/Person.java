package com.secondhand.springboot.bean;


/**
 * @author rzw
 * @create 2019-12-13-16:38
 */
public class Person {
    private String id;
    private String name;
    private Boolean sex;
    private String tel;
    private String address;
    private Integer flag;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public int getFlag() {
        return flag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
