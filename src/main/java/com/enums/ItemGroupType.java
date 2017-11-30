package com.enums;

public enum ItemGroupType {

    paper("paper"),
    solid("paper"),liquid("liquid"),Computers("computers"),Clothes("clothes"),accessories("accessories")
    ,Cars("cars"),vehicle("vehicle");

    private String url;

    ItemGroupType(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
