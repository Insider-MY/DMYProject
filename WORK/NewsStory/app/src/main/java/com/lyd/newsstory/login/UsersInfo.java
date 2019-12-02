package com.lyd.newsstory.login;

public class UsersInfo {
    public int _id;
    public String name ;
    public String password;
    public int age;
    public String info;
    //建立构造器
    public UsersInfo(){

    }

    public UsersInfo(String name) {
        this.name = name;
    }

    public UsersInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UsersInfo(String name, int age, String info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }

    public UsersInfo( String name, String password, int age, String info) {
        this._id = _id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.info = info;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
