package com.divijgupta.bolkarassignment.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.divijgupta.bolkarassignment.model.Datum;

import java.util.List;

public class MyDiffUtilCB extends DiffUtil.Callback {
    private List<Datum> oldList;
    private List<Datum> newList;

    public MyDiffUtilCB(List<Datum> oldList, List<Datum> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId().equals(newList.get(newItemPosition).getId());
    }
}
