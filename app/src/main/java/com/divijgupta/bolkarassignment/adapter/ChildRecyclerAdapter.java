package com.divijgupta.bolkarassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.divijgupta.bolkarassignment.R;
import com.divijgupta.bolkarassignment.model.Datum;

import java.util.ArrayList;
import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ChildViewHolder> {
    private List<Datum> dataList;
    private Context context;
    private List<Datum> tempList;

    public ChildRecyclerAdapter(List<Datum> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        tempList = new ArrayList<>();
        tempList.addAll(dataList);
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        Datum item = dataList.get(position);

        Glide.with(context).load(item.getPF()).into(holder.ivThumbnail);
        holder.tvSubtitle.setText(item.getT());

        holder.itemView.setOnClickListener(v -> {
            tempList.remove(position);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCB(dataList, tempList));
            diffResult.dispatchUpdatesTo(this);
            dataList.clear();
            dataList.addAll(tempList);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivThumbnail;
        private TextView tvSubtitle;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
        }
    }
}
