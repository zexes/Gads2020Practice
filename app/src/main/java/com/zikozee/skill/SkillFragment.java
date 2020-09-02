package com.zikozee.skill;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zikozee.ApiUtil;
import com.zikozee.R;
import com.zikozee.RecyclerViewAdapter;

import java.net.URL;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    View v;
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
        v = inflater.inflate(R.layout.fragment_skill, container, false);
//        myRecyclerView = v.findViewById(R.id.skill_recyclerView);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), mSkillList);
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

}