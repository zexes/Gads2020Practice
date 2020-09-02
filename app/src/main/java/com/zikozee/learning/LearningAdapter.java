package com.zikozee.learning;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zikozee.Contact;
import com.zikozee.R;
import com.zikozee.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningViewHolder> {

    ArrayList<Learning> mLearnings;

    public LearningAdapter(ArrayList<Learning> learnings){
        this.mLearnings =learnings;
    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_learning, parent, false);
        return new LearningViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        Learning learning  = mLearnings.get(position);
        holder.bind(learning);
    }

    @Override
    public int getItemCount() {
        return mLearnings.size();
    }

    public class LearningViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView score;

        public LearningViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.learner_id);
            score = itemView.findViewById(R.id.learner_score_id);
        }

        @SuppressLint("SetTextI18n")
        public void bind(Learning learning){
            name.setText(learning.getName());
            score.setText(learning.getHours() +" learning hours, " + learning.getCountry());
        }
    }
}
