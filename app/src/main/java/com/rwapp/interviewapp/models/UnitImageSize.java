package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class UnitImageSize {

    int width;
    int height;

    public UnitImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
