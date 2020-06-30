package com.rwapp.interviewapp.presenters;

import com.rwapp.interviewapp.events.UnitApiEvent;
import com.rwapp.interviewapp.model.ApiDataRepository;
import com.rwapp.interviewapp.models.Card;
import com.rwapp.interviewapp.models.Cards;
import com.rwapp.interviewapp.models.CardsAttributes;
import com.rwapp.interviewapp.models.Description;
import com.rwapp.interviewapp.models.Title;
import com.rwapp.interviewapp.models.UnitFont;
import com.rwapp.interviewapp.models.UnitImage;
import com.rwapp.interviewapp.models.UnitImageSize;
import com.rwapp.interviewapp.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    MainPresenter mainPresenter;

    @Mock
    MainView mainView;

    @Mock
    ApiDataRepository apiDataRepository;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(apiDataRepository, mainView);
    }

    @Test
    public void testForInflatingData() {
        List<Cards> list = new ArrayList<>();
        list.add(new Cards("type", new Card(new Title("Title", new CardsAttributes("color", new UnitFont(1))), new Description("description",new CardsAttributes("color", new UnitFont(1)) ), new UnitImage("url", new UnitImageSize(1,1)))));
        UnitApiEvent event = new UnitApiEvent(list, null);
        mainPresenter.inflateDataList(event);
        verify(mainView, times(1)).inflateData(list);
    }

    @Test
    public void testForShowError() {
        String errorMessage = "Error Message";
        List<Cards> list = new ArrayList<>();
        UnitApiEvent event = new UnitApiEvent(list, errorMessage);
        mainPresenter.inflateDataList(event);
        verify(mainView, times(1)).showError(errorMessage);
    }
}

