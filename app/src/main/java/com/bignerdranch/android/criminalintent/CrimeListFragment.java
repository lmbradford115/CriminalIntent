package com.bignerdranch.android.criminalintent;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.List;
import java.util.UUID;

/**
 * Created by Luke on 10/12/15.
 */
public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    public UUID mChanged;
    private static final int num  = 1;
    //private static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume(){

        super.onResume();
        updateUI();

    }


    private void updateUI(){


        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();




        //Challenge



        //Original
       if(mAdapter == null) {
            mAdapter = new CrimeAdapter(crimes);
           mCrimeRecyclerView.setAdapter(mAdapter);
        }else{
           for (int i = 0; i < crimes.size(); i++){
               if (crimes.get(i).getId() == mChanged){
                   mAdapter.notifyItemChanged(i);
                   break;
               }
           }
        }
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Crime mCrime;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        public CrimeHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_list_item_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_list_item_date_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.crime_list_item_solved_check_box);
        }


        @Override
        public void onClick(View v){
            mChanged = mCrime.getId();
            //Intent intent = CrimeActivity.newIntent(getActivity(), mChanged);
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mChanged);
            startActivityForResult(intent, num);

        }

        public void bindCrime(Crime crime){

            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            // Dates according to Chapter 8 Challenge
            //mDateTextView.setText(mCrime.longDate(mCrime.getDate()));
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedCheckBox.setChecked(mCrime.isSolved());

        }


    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType){

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position){
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount(){
            return mCrimes.size();
        }

    }

}


