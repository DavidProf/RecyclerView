package com.learn.dntl.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<RocketModel> rocketModels;

    public RecyclerAdapter(ArrayList<RocketModel> rocketModels) {
        this.rocketModels = rocketModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RocketModel rocketModel = rocketModels.get(i);

        viewHolder.rocketName.setText("Rocket: " + rocketModel.getRocketName());

        viewHolder.launchDate.setText("Launch Date: " + rocketModel.getLaunchDate());

        if (rocketModel.isLaunchSuccess()) {
            viewHolder.launchSuccess.setText("Launch Success");
        } else {
            viewHolder.launchSuccess.setText("Launch Failed");
        }

        viewHolder.payload.setText(rocketModel.getPayload());

    }

    @Override
    public int getItemCount() {
        return rocketModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_rocketName)
        TextView rocketName;

        @BindView(R.id.text_view_launchDate)
        TextView launchDate;

        @BindView(R.id.text_view_launchSuccess)
        TextView launchSuccess;

        @BindView(R.id.text_view_payload)
        TextView payload;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
