package com.depot_air.ui.botol;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.depot_air.R;
import com.depot_air.UpdateBotol;
import com.depot_air.adapter.BotolAdapter;
import com.depot_air.model.BotolModel;

import java.util.ArrayList;
import java.util.List;

public class BotolFragment extends Fragment implements BotolAdapter.itemCLickListener{

    private String TAG = "mvvm";
    private RecyclerView rv;
    private BotolAdapter botolAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_botol, container, false);
        List<BotolModel> trainingModels = new ArrayList<>();
        rv = root.findViewById(R.id.rcvbotol);
        rv.setAdapter(botolAdapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        BotolViewModel botolViewModel =
                ViewModelProviders.of(this).get(BotolViewModel.class);
        botolViewModel.getTraining().observe(getViewLifecycleOwner(), botolModels -> {
            botolAdapter = new BotolAdapter(getActivity(), botolModels,this);
            rv.setAdapter(botolAdapter);
        });
        return root;
    }

    @Override
    public void onItemCLick(BotolModel dataModel) {
        Intent intent = new Intent(getActivity(), UpdateBotol.class);
        intent.putExtra(com.depot_air.helper.Bundle.BUNDLE_ID,dataModel.getId());
        intent.putExtra(com.depot_air.helper.Bundle.BUNDLE_MERK,dataModel.getMerk_botol());
        intent.putExtra(com.depot_air.helper.Bundle.BUNDLE_UKURAN,dataModel.getUkuran_botol());
        intent.putExtra(com.depot_air.helper.Bundle.BUNDLE_HARGA,dataModel.getHarga());
        intent.putExtra(com.depot_air.helper.Bundle.BUNDLE_GAMBAR,dataModel.getGambar());
        startActivity(intent);
    }
}