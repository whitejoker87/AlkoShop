package ru.whitejoker.alkoshop.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.io.InputStreamReader;
import java.util.List;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<InputStreamReader> readerJSON = new MutableLiveData<>();

    public void setReaderJSON(InputStreamReader reader) {
        readerJSON.setValue(reader);
    }

    public LiveData<InputStreamReader> getReaderJSON() {
        return readerJSON;
    }
}
