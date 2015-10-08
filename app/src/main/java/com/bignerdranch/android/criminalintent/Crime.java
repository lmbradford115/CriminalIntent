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

    public Crime(){
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();


        //mDate = new DateFormat();
        //mDate = DateFormat.getLongDateFormat(Crime.this);




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
}
