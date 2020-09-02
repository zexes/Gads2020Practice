package com.zikozee;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Contact> lstContact;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contact, container, false);
        myRecyclerView = v.findViewById(R.id.contact_recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstContact);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact  = new ArrayList<>();
        lstContact.add(new Contact("Ezekiel Eromosei", "(234) 7066616366", R.drawable.bb));
        lstContact.add(new Contact("Skill Things", "(234) 7066616366", R.drawable.skill));
        lstContact.add(new Contact("Background Things", "(234) 7066616366", R.drawable.background));
        lstContact.add(new Contact("Ezekiel Eromosei", "(234) 7066616366", R.drawable.bb));
        lstContact.add(new Contact("Skill Things", "(234) 7066616366", R.drawable.skill));
        lstContact.add(new Contact("Background Things", "(234) 7066616366", R.drawable.background));
        lstContact.add(new Contact("Ezekiel Eromosei", "(234) 7066616366", R.drawable.bb));
        lstContact.add(new Contact("Skill Things", "(234) 7066616366", R.drawable.skill));
        lstContact.add(new Contact("Background Things", "(234) 7066616366", R.drawable.background));

    }
}