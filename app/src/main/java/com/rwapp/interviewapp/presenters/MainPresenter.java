package com.rwapp.interviewapp.presenters;

import com.rwapp.interviewapp.events.UnitApiEvent;
import com.rwapp.interviewapp.model.ApiDataRepository;
import com.rwapp.interviewapp.view.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Purpose: MainActivity presenter contains logic connected to model layer
 */
public class MainPresenter {

    ApiDataRepository mApiDataRepository;
    MainView mMainView;

    public MainPresenter(ApiDataRepository mApiDataRepository, MainView mMainView) {
        this.mApiDataRepository = mApiDataRepository;
        this.mMainView = mMainView;
    }

    /**
     * Getting data for the list on the MainActivity
     */
    public void getData() {
        mApiDataRepository.getUnitsData();
    }

    /**
     * Unpack the response from UnitApi call.
     */
    @Subscribe
    public void inflateDataList(UnitApiEvent event) {
        if (event.getmData().size() > 0 && event.getmErrorMessage() == null) {
            mMainView.inflateData(event.getmData());
        } else {
            mMainView.showError(event.getmErrorMessage());
        }
    }
//TODO 3 scenarios - 1) Success -> inflating response data 2) Failure -> Inflating last success response data
    //TODO 3) Failure -> Nothing to inflate so just show error message
    /**
     * Register eventbus subscribers
     */
    public void registerSubscribers() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * Unregister eventbus subscribers
     */
    public void unregisterSubscribers() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
