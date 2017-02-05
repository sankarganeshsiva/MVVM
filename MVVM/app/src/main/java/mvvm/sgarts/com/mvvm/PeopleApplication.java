package mvvm.sgarts.com.mvvm;

import android.app.Application;
import android.content.Context;

import mvvm.sgarts.com.mvvm.data.PeopleFactory;
import mvvm.sgarts.com.mvvm.data.PeopleService;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class PeopleApplication extends Application {

    private PeopleService peopleService;
    private Scheduler scheduler;

    private static PeopleApplication get(Context context) {
        return (PeopleApplication) context.getApplicationContext();
    }

    public static PeopleApplication create(Context context) {
        return PeopleApplication.get(context);
    }

    public PeopleService getPeopleService() {
        if (peopleService == null) peopleService = PeopleFactory.create();

        return peopleService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) scheduler = Schedulers.io();

        return scheduler;
    }

    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}