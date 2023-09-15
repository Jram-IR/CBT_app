package com.project.cbtapp.fear_ladder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.project.cbtapp.R;
import com.project.cbtapp.fear_ladder.dto.FearModel;

public class FearAdapter extends FirestoreRecyclerAdapter<FearModel, FearAdapter.FearViewHolder > {
    private OnFearClickedListener listener;


    public FearAdapter(@NonNull FirestoreRecyclerOptions<FearModel> options) {
        super(options);
    }

    public void setListener(OnFearClickedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull FearViewHolder holder, int position, @NonNull FearModel model) {
        holder.fearName.setText(model.getFearName());
    }

    @NonNull
    @Override
    public FearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fear_item,parent,false);
        return new FearViewHolder(v,listener);
    }


    class FearViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView fearName;
        private MaterialCardView fearCard;
        private OnFearClickedListener listener;

        public FearViewHolder(@NonNull View itemView, OnFearClickedListener listener) {
            super(itemView);
            this.listener = listener;
            fearCard = itemView.findViewById(R.id.fear_card);
            fearName = itemView.findViewById(R.id.txt_fear_name);
            fearCard.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {


        }
    }

    public interface OnFearClickedListener
    {
        void onFearClicked(DocumentSnapshot snapshot);
    }
}
