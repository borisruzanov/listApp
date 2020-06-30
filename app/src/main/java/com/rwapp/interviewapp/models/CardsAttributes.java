package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class CardsAttributes {
    String text_color;
    UnitFont font;

    public CardsAttributes(String text_color, UnitFont font) {
        this.text_color = text_color;
        this.font = font;
    }

    public String getText_color() {
        return text_color;
    }

    public UnitFont getFont() {
        return font;
    }
}
