package com.smartgifter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shweta Sachdeva on 4/7/2016.
 */
public class User implements Parcelable {

    private long fbUserId;
    private String fbUserName;

    /**
     * Parcelable creator. Do not modify this function.
     */
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel p) {
            return new User(p);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    //Default constructor
    public User() {
    }

    /**
     * Create a User model object from a Parcel. This
     * function is called via the Parcelable creator.
     *
     * @param p The Parcel used to populate the
     * Model fields.
     */
    public User(Parcel p) {
        fbUserId = p.readInt();
        fbUserName = p.readString();
    }

    /**
     * Create a User model object from arguments
     */
    public User(long fbUserId,String fbUserName) {
        this.fbUserId = fbUserId;
        this.fbUserName = fbUserName;
    }


    /**
     * Serialize User object by using writeToParcel.
     * This function is automatically called by the
     * system when the object is serialized.
     *
     * @param dest Parcel object that gets written on
     * serialization. Use functions to write out the
     * object stored via your member variables.
     *
     * @param flags Additional flags about how the object
     * should be written. May be 0 or PARCELABLE_WRITE_RETURN_VALUE.
     * In our case, you should be just passing 0.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.fbUserId);
        dest.writeString(this.fbUserName);
    }

    public String getName() {
        return fbUserName;
    }

    public void setName(String fbUserName) {
        this.fbUserName = fbUserName;
    }

    public long getId() {
        return fbUserId;
    }

    public void setId(long fbUserId) {
        this.fbUserId = fbUserId;
    }

    /**
     * Do not implement
     */
    @Override
    public int describeContents() {
        // Do not implement!
        return 0;
    }
}
