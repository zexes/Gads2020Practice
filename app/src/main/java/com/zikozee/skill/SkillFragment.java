package com.zikozee.skill;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zikozee.ApiUtil;
import com.zikozee.R;
import com.zikozee.RecyclerViewAdapter;
import com.zikozee.learning.LearningFragment;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    View v;
    private ProgressBar mLoadingProgress;
    private RecyclerView myRecyclerView;
    private List<Skill> mSkillList;

    public SkillFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        try {
            URL skillUrl = ApiUtil.buildUrl("/api/skilliq");
            String jsonResult = ApiUtil.getJson(skillUrl);

        }catch (Exception e){
            Log.d("error", e.getMessage());
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        v = inflater.inflate(R.layout.fragment_skill, container, false);
//        myRecyclerView = v.findViewById(R.id.skill_recyclerView);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), mSkillList);
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myRecyclerView.setAdapter(recyclerViewAdapter);
//        return v;

        v = inflater.inflate(R.layout.dummy, container, false);
        // Inflate the layout for this fragment
        mLoadingProgress = v.findViewById(R.id.pb_loading);
        mLoadingProgress.setVisibility(View.VISIBLE);

        try {
            URL skillUrl = ApiUtil.buildUrl("/api/skilliq");
            new SkillFragment.LearningQueryTask().execute(skillUrl);
        }catch (Exception e){
            Log.d("error", e.getMessage());
        }

        return v;
    }

    public class LearningQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchURL = urls[0];
            String result = null;

            try{
                result = ApiUtil.getJson(searchURL);
            }catch (Exception e){
                Log.e("error", e.toString());
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tvResult = v.findViewById(R.id.dummyText);
            TextView error = v.findViewById(R.id.error);
            mLoadingProgress.setVisibility(View.GONE);
            if(error == null){
                tvResult.setVisibility(View.INVISIBLE);
                error.setVisibility(View.VISIBLE);
            }else{
                tvResult.setVisibility(View.VISIBLE);
                error.setVisibility(View.INVISIBLE);
            }
            ArrayList<Skill> skills = ApiUtil.getSkillFromJson(result);
            String resultString ="";
            for(Skill skill: skills){
                resultString = resultString + skill.getName() + "\n"+ skill.getCountry()
                        + "\n"+ skill.getScore() + "\n"+ skill.getUrl() + "\n\n";
            }
            tvResult.setText(resultString);
        }
    }

}