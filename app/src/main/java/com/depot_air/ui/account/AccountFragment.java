package com.depot_air.ui.account;

import android.os.Bundle;
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        accountViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}