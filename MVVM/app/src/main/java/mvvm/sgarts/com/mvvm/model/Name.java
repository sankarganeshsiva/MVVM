package mvvm.sgarts.com.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class Name implements Serializable {

    @SerializedName("title") public String title;

    @SerializedName("first") public String firts;

    @SerializedName("last") public String last;
}