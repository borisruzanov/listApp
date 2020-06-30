package com.rwapp.interviewapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Parse UnitApi response
 */
public class UnitPage {

    List<Cards> cards = new ArrayList<>();

    public List<Cards> getCards() {
        return cards;
    }
}
