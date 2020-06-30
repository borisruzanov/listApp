package com.rwapp.interviewapp.events;

import com.rwapp.interviewapp.models.Cards;
import com.rwapp.interviewapp.models.Unit;

import java.util.List;

/**
 * Purpose: Using when sending callback from repository to the presenter
 */
public class UnitApiEvent {
    List<Cards> mData;
    String mErrorMessage;

    public UnitApiEvent(List<Cards> mData, String mErrorMessage) {
        this.mData = mData;
        this.mErrorMessage = mErrorMessage;
    }

    public List<Cards> getmData() {
        return mData;
    }

    public String getmErrorMessage() {
        return mErrorMessage;
    }
}
