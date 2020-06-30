package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class UnitImage {

    String url;
    UnitImageSize size;

    public UnitImage(String url, UnitImageSize size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public UnitImageSize getSize() {
        return size;
    }
}
