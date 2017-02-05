package mvvm.sgarts.com.mvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import mvvm.sgarts.com.mvvm.PeopleApplication;
import mvvm.sgarts.com.mvvm.data.PeopleResponse;
import mvvm.sgarts.com.mvvm.data.PeopleService;
import mvvm.sgarts.com.mvvm.model.People;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class PeopleViewModel extends Observable {

    public ObservableInt peopleProgress;
    public ObservableInt peopleRecycler;
    public ObservableInt peopleLabel;
    public ObservableField<String> messageLabel;

    private List<People> peopleList;
    private Context context;
    private Subscription subscription;

    public PeopleViewModel(@NonNull Context context) {

        this.context = context;
        this.peopleList = new ArrayList<>();
        peopleProgress = new ObservableInt(View.GONE);
        peopleRecycler = new ObservableInt(View.GONE);
        peopleLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_people));
    }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPeopleList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        peopleLabel.set(View.GONE);
        peopleRecycler.set(View.GONE);
        peopleProgress.set(View.VISIBLE);
    }

    private void fetchPeopleList() {

        final String URL = "http://api.randomuser.me/?results=10&nat=en";
        unSubscribeFromObservable();
        PeopleApplication peopleApplication = PeopleApplication.create(context);
        PeopleService peopleService = peopleApplication.getPeopleService();
        subscription = peopleService.fetchPeople(URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(peopleApplication.subscribeScheduler())
                .subscribe(new Action1<PeopleResponse>() {
                    @Override public void call(PeopleResponse peopleResponse) {
                        peopleProgress.set(View.GONE);
                        peopleLabel.set(View.GONE);
                        peopleRecycler.set(View.VISIBLE);
                        changePeopleDataSet(peopleResponse.getPeopleList());
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        messageLabel.set(context.getString(R.string.error_loading_people));
                        peopleProgress.set(View.GONE);
                        peopleLabel.set(View.VISIBLE);
                        peopleRecycler.set(View.GONE);
                    }
                });
    }

    private void changePeopleDataSet(List<People> peoples) {
        peopleList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    private void unSubscribeFromObservable() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        subscription = null;
        context = null;
    }
}