package com.zikozee.learning;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zikozee.ApiUtil;
import com.zikozee.R;

import org.w3c.dom.Text;

import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    View v;
    public LearningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.dummy, container, false);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            URL learningUrl = ApiUtil.buildUrl("/api/hours");
            new LearningQueryTask().execute(learningUrl);
        }catch (Exception e){
            Log.d("error", e.getMessage());
        }

    }


    public class LearningQueryTask extends AsyncTask<URL, Void, String> {

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

            tvResult.setText(result);
        }
    }
}