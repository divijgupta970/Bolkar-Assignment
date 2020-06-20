package com.divijgupta.bolkarassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divijgupta.bolkarassignment.R;
import com.divijgupta.bolkarassignment.model.Response;

import java.util.List;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder> {
    private Context context;
    private List<Response> itemList;
    private ChildRecyclerAdapter childRecyclerAdapter;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public ParentRecyclerAdapter(Context context, List<Response> itemList) {
        this.context = context;
        this.itemList = itemList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_container_layout, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        Response item = itemList.get(position);

        holder.tvTitle.setText(item.getTitle());

        childRecyclerAdapter = new ChildRecyclerAdapter(item.getData(), context);
        holder.rvChild.setAdapter(childRecyclerAdapter);
        holder.rvChild.setRecycledViewPool(recycledViewPool);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ParentViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rvChild;
        private TextView tvTitle;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            rvChild = itemView.findViewById(R.id.rv_child);
            tvTitle = itemView.findViewById(R.id.tv_title);

            rvChild.setHasFixedSize(true);
            rvChild.setNestedScrollingEnabled(false);
            rvChild.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            rvChild.setItemAnimator(new DefaultItemAnimator());
        }
    }
}
