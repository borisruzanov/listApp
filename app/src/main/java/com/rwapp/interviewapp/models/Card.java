package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class Card {
    Title title;
    Description description;
    UnitImage image;

    public Card(Title title, Description description, UnitImage image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public UnitImage getImage() {
        return image;
    }
}
