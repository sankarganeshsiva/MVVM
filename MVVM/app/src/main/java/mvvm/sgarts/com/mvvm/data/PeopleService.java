package mvvm.sgarts.com.mvvm.data;

import android.database.Observable;

import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public interface PeopleService {
    @GET
    Observable<PeopleResponse> fetchPeople(@Url String url);
}