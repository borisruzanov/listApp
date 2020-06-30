package com.rwapp.interviewapp.model;

import com.rwapp.interviewapp.events.UnitApiEvent;
import com.rwapp.interviewapp.models.PageWrapper;
import com.rwapp.interviewapp.utils.network.RetrofitClient;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Purpose: Contains different HTTP requests
 */
public class ApiDataRepository {

    /**
     * Call to get all units from the API
     */
    public void getUnitsData() {
        //It might be implemented with RxJava as well
        RetrofitClient.
                getApiService()
                .loadData()
                .enqueue(new Callback<PageWrapper>() {
                    @Override
                    public void onResponse(Call <PageWrapper> call, Response<PageWrapper> response) {
                        if (response.isSuccessful()){
                            EventBus.getDefault().post(new UnitApiEvent(response.body().getUnitPage().getCards(), null));
                        }

                        //TODO If I have more time I would save list in the database since it is success
                    }

                    @Override
                    public void onFailure(Call<PageWrapper> call, Throwable t) {
                        EventBus.getDefault().post(new UnitApiEvent(null, t.getMessage()));
                        //TODO We can check if the previous success database exists we can inflate that data
                        //TODO If not just show error message
                    }
                });
    }
}
