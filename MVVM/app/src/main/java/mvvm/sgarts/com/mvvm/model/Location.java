package mvvm.sgarts.com.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class Location implements Serializable {

    @SerializedName("street") public String street;

    @SerializedName("city") public String city;

    @SerializedName("state") public String state;

    @SerializedName("zip") public String zip;
}