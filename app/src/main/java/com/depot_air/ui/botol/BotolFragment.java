package com.depot_air.ui.botol;

import android.content.Intent;
import android.graphics.Color;
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
import com.depot_air.adapter.SliderAdapter;
import com.depot_air.model.BotolModel;
import com.depot_air.model.SliderModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class BotolFragment extends Fragment implements BotolAdapter.itemCLickListener{

    private String TAG = "mvvm";
    private RecyclerView rv;
    SliderAdapter adapter;
    private BotolAdapter botolAdapter;
    List <SliderModel> arrayList;
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

        SliderView sliderView = root.findViewById(R.id.imageSlider);
        addNewItem();
        adapter = new SliderAdapter(getActivity(),arrayList);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

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

    public void addNewItem() {
        arrayList = new ArrayList<>();
        arrayList.add(new SliderModel("Sedia Galon","https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/12/30/2966205992.png"));
        arrayList.add(new SliderModel("Sedia Botol","https://mmc.tirto.id/image/otf/700x0/2020/11/02/ilustrasi-botol-air-kemasan-istock_ratio-16x9.jpg"));
        arrayList.add(new SliderModel("Akan tersedia bentuk gelas","https://cdn-2.tstatic.net/bali/foto/bank/images/aqua-gelas_20150826_150732.jpg"));
//        SliderModel sliderItem = new SliderModel();
//        sliderItem.setDescription("Galon");
//        sliderItem.setImagesUrl("https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/12/30/2966205992.png");
//        adapter.addItem(sliderItem);
//        sliderItem.setDescription("Botol");
//        sliderItem.setImagesUrl("https://mmc.tirto.id/image/otf/700x0/2020/11/02/ilustrasi-botol-air-kemasan-istock_ratio-16x9.jpg");
//        adapter.addItem(sliderItem);
    }
}