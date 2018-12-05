package ru.whitejoker.alkoshop.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import ru.whitejoker.alkoshop.model.UserOrder;
import ru.whitejoker.alkoshop.model.UserOrdersResponse;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<InputStreamReader> readerJSON = new MutableLiveData<>();
    private final MutableLiveData<List<UserOrder>> dataFromJSON = new MutableLiveData<>();

    public void setReaderJSON(InputStreamReader reader) {
        readerJSON.setValue(reader);
    }

    public void setDataFromJSON(List<UserOrder> data) {
        dataFromJSON.setValue(data);
    }

    public LiveData<List<UserOrder>> getDataFromJSON() {
        return dataFromJSON;
    }



    public void convertJSON(InputStreamReader reader) {
        setReaderJSON(reader);
        setDataFromJSON(Objects.requireNonNull(UserOrdersResponse.fromJson(reader)).getData());
    }
}
