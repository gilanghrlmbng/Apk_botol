package com.depot_air.ui.account;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.depot_air.R;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    private SharedPreferences sharedPreferences;
    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        sharedPreferences = getActivity().getSharedPreferences(com.depot_air.helper.Bundle.SHARED_INIT, Context.MODE_PRIVATE);;
        String username = sharedPreferences.getString(com.depot_air.helper.Bundle.SHARED_PRE_UNAME,null);
        String email = sharedPreferences.getString(com.depot_air.helper.Bundle.SHARED_PRE_EMAIL,null);
        TextView textView_username = root.findViewById(R.id.tv_uname);
        TextView textView_email = root.findViewById(R.id.tv_email);
        textView_username.setText("Hallo "+username+"!");
        textView_email.setText("Email : "+email);
//        accountViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }
}