package mvvm.sgarts.com.mvvm.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mvvm.sgarts.com.mvvm.model.People;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class PeopleResponse {

    @SerializedName("results") private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> mPeopleList) {
        this.peopleList = mPeopleList;
    }
}