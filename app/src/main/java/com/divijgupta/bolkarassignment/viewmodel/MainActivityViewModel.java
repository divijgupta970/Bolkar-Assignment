package com.divijgupta.bolkarassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.divijgupta.bolkarassignment.model.Response;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private Repository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Response>> getResponse() {
        return repository.getResponse();
    }
}
