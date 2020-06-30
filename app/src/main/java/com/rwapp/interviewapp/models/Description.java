package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class Description {
    String value;
    CardsAttributes attributes;

    public Description(String value, CardsAttributes attributes) {
        this.value = value;
        this.attributes = attributes;
    }

    public String getValue() {
        return value;
    }

    public CardsAttributes getAttributes() {
        return attributes;
    }
}
