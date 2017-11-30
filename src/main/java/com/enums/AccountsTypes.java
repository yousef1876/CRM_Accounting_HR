package com.enums;

public enum AccountsTypes {

    SUPERROLE("superRole"),
    ADMINISTRATOR("admin"),
    USER("user"),QUEST("quest");

    private String url;

    AccountsTypes(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
