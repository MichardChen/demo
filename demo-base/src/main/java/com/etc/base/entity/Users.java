package com.etc.base.entity;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
public class Users {

    private String userName;
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.address+"-"+this.userName;
    }
}
