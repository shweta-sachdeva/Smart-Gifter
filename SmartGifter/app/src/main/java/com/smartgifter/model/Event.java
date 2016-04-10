package com.smartgifter.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

/**
 * Created by Shweta Sachdeva on 4/7/2016.
 */
public class Event implements Parcelable {

    private int eventId;
    private String eventTitle;
    private String eventDate;
    private long eventOwnerId;
    private String itemName;
    private String itemDescription;
    private int itemPrice;

    /**
     * Parcelable creator. Do not modify this function.
     */
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel p) {
            return new Event(p);
        }
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    //Default constructor
    public Event() {
    }

    /**
     * Create a Event model object from a Parcel. This
     * function is called via the Parcelable creator.
     */
    public Event(Parcel p) {
        eventId = p.readInt();
        eventTitle = p.readString();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(p.readLong());
        eventDate = p.readString();
        eventOwnerId = p.readLong();
        itemName = p.readString();
        itemDescription = p.readString();
        itemPrice = p.readInt();
    }

    /**
     * Create a Event model object from arguments
     */
    public Event(int eventId,String eventTitle,String eventDate,long eventOwnerId,String itemName, String itemDescription,int itemPrice) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventOwnerId = eventOwnerId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }


    /**
     * Serialize Event object by using writeToParcel.
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
        dest.writeInt(this.eventId);
        dest.writeString(this.eventTitle);
        dest.writeString(this.eventDate);
        dest.writeLong(this.eventOwnerId);
        dest.writeString(this.itemName);
        dest.writeString(this.itemDescription);
        dest.writeInt(this.itemPrice);
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getEventIdId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public long getEventOwnerId() {
         return eventOwnerId;
    }
    public void setEventOwnerId(long eventOwnerId) {
        this.eventOwnerId = eventOwnerId;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
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
