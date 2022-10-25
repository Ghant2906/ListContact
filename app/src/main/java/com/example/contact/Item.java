package com.example.contact;

public class Item {
    private String ten, sdt;

    public Item(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
