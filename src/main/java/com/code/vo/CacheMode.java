package com.code.vo;

public enum CacheMode {

    UPDATE("update"),
    DELETE("delete"),
    ALLDELETE("allDelete"),
    ADD("add");

    private String mode;

    CacheMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
