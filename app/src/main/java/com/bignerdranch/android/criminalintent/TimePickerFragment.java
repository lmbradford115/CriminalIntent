package com.bignerdranch.android.criminalintent;

//import android.app.DialogFragment;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by Luke on 10/22/15.
 */
public class TimePickerFragment extends AbstractPickerDialogFragment {



        private TimePicker mTimePicker;

        public static TimePickerFragment newInstance(Date date) {
            Bundle args = getArgs(date);
            TimePickerFragment fragment = new TimePickerFragment();
            fragment.setArguments(args);
            return fragment;
        }


        protected View initLayout() {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

            mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
            mTimePicker.setIs24HourView(false);
            mTimePicker.setCurrentHour(mCalendar.get(Calendar.HOUR_OF_DAY));
            mTimePicker.setCurrentMinute(mCalendar.get(Calendar.MINUTE));

            return v;
        }

        protected Date getDate() {

            int year = mCalendar.get(Calendar.YEAR);
            int month = mCalendar.get(Calendar.MONTH);
            int day = mCalendar.get(Calendar.DAY_OF_MONTH);


            int hour = mTimePicker.getCurrentHour();
            int minute = mTimePicker.getCurrentMinute();

            return new GregorianCalendar(year, month, day, hour, minute).getTime();
        }
    }


