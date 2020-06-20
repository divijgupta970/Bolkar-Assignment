package com.divijgupta.bolkarassignment.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divijgupta.bolkarassignment.R;
import com.divijgupta.bolkarassignment.adapter.ParentRecyclerAdapter;
import com.divijgupta.bolkarassignment.model.Response;
import com.divijgupta.bolkarassignment.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private List<Response> responseList;
    private ParentRecyclerAdapter adapter;
    private RecyclerView rvParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        responseList = new ArrayList<>();
        adapter = new ParentRecyclerAdapter(this, responseList);

        rvParent = findViewById(R.id.rv_parent);
        rvParent.setLayoutManager(new LinearLayoutManager(this));
        rvParent.setHasFixedSize(true);
        rvParent.setAdapter(adapter);

        getData();
    }

    public void getData() {
        viewModel.getResponse().observe(this, responses -> {
            removeEmpties(responses);
        });
    }

    public void removeEmpties(List<Response> responses) {
        responseList.clear();
        for (Response r : responses) {
            if (!r.getData().isEmpty()) {
                responseList.add(r);
            }
        }
        adapter.notifyDataSetChanged();
    }
}