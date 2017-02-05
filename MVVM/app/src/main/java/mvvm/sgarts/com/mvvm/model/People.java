package mvvm.sgarts.com.mvvm.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sankar Ganesh on 2/5/2017.
 */

public class People implements Serializable {

    @SerializedName("gender") public String gender;

    @SerializedName("name") public Name name;

    @SerializedName("location") public Location location;

    @SerializedName("email") public String mail;

    @SerializedName("login") public Login userName;

    @SerializedName("phone") public String phone;

    @SerializedName("cell") public String cell;

    @SerializedName("picture") public Picture picture;

    public String fullName;

    public boolean hasEmail() {
        return mail != null && !mail.isEmpty();
    }
}