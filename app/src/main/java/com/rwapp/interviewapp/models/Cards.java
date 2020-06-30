package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class Cards {
    String card_type;
    Card card;

    public Cards(String card_type, Card card) {
        this.card_type = card_type;
        this.card = card;
    }

    public String getCard_type() {
        return card_type;
    }

    public Card getCard() {
        return card;
    }
}
