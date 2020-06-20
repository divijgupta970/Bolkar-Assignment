package com.divijgupta.bolkarassignment.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.divijgupta.bolkarassignment.model.Response;
import com.divijgupta.bolkarassignment.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Repository {
    private MutableLiveData<List<Response>> responseMutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Response>> getResponse() {
        Call<List<Response>> call = RetrofitInstance.getService(application.getApplicationContext()).getData();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                List<Response> responseList = response.body();
                if (responseList != null && !responseList.isEmpty())
                    responseMutableLiveData.setValue(responseList);
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Log.d(getClass().getCanonicalName(), t.getMessage());
            }
        });
        return responseMutableLiveData;
    }
}
