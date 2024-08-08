package com.example.dbdemo.model;

public class contact {
    private int id;
    private String name;
    private String phonenumber;

    public contact(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public contact(int id, String name, String phonenumber) {
        this.id=id;
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
