package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;
import java.text.DateFormat;

import android.content.Context;


//import android.text.format.DateFormat;



/**
 * Created by Luke on 10/6/15.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    //private DateFormat mDate;

    private Date mDate;
    private boolean mSolved;



    private String mSuspect;

    public Crime(){
        // Generate unique identifier
       this(UUID.randomUUID());

        //mDate = new DateFormat();
        //mDate = DateFormat.getLongDateFormat(Crime.this);

    }

    public Crime(UUID id){

        mId = id;
        mDate = new Date();

    }


    public String longDate(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        return dateFormat.format(date);
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }


}
