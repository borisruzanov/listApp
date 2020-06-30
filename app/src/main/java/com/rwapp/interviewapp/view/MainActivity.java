package com.rwapp.interviewapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rwapp.interviewapp.R;
import com.rwapp.interviewapp.model.ApiDataRepository;
import com.rwapp.interviewapp.models.Cards;
import com.rwapp.interviewapp.presenters.MainPresenter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Purpose: Implementation of the ui views on the main screen
 */
public class MainActivity extends AppCompatActivity implements MainListAdapter.ItemClickListener, MainView {

    MainListAdapter mMainAdapter;

    RecyclerView mRecyclerView;

    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(new ApiDataRepository(), this);
        mRecyclerView = findViewById(R.id.recycler_list_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.registerSubscribers();
        mPresenter.getData();
    }

    /**
     * Inflating recycler with data from response
     *
     * @param data - data that was received from API call
     */
    @Override
    public void inflateData(List<Cards> data) {
        mMainAdapter = new MainListAdapter(this, data);
        mMainAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mMainAdapter);
    }

    /**
     * Showing error message that something goes wrong and no data received
     * @param errorMessage - to show the user what happens. Comes from the server
     */
    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * RecyclerView item click listener
     */
    @Override
    public void onItemClick(View view, int position) {
        //TODO Implement OnItemClickListener
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unregisterSubscribers();
    }
}