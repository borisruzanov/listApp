package com.rwapp.interviewapp.view;

import com.rwapp.interviewapp.models.Cards;

import java.util.List;

/**
 * Purpose: Methods of MainActivity.class
 */
public interface MainView {
    void inflateData(List<Cards> data);

    void showError(String s);
}
