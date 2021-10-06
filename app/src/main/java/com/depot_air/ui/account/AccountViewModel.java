package com.depot_air.ui.account;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.depot_air.helper.Bundle;

public class AccountViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    String username;
    public AccountViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("Hallo "+username);
    }

    public LiveData<String> getText() {
        return mText;
    }
}