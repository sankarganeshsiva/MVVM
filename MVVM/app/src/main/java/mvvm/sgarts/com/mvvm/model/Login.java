package mvvm.sgarts.com.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class Login implements Serializable {

    @SerializedName("username") public String userName;
}