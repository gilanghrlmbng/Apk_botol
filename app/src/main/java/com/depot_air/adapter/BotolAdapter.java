package com.depot_air.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.depot_air.R;
import com.depot_air.helper.Bundle;
import com.depot_air.model.BotolModel;
import com.depot_air.model.ResponseErrorModel;
import com.depot_air.rest.ApiConfig;
import com.depot_air.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BotolAdapter extends RecyclerView.Adapter<BotolAdapter.BotolViewHolder> {
    private final Context context;
    private final List<BotolModel> botolModelList;
    private itemCLickListener itemCLickListener;

    public BotolAdapter(Context context, List<BotolModel> botolModelList, BotolAdapter.itemCLickListener itemCLickListener) {
        this.context = context;
        this.botolModelList = botolModelList;
        this.itemCLickListener = itemCLickListener;
    }

    @NonNull
    @Override
    public BotolAdapter.BotolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_botol,parent,false);
        return new BotolViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BotolAdapter.BotolViewHolder holder, int position) {

        holder.tvmerk.setText(botolModelList.get(position).getMerk_botol());
        holder.tvukuran.setText(botolModelList.get(position).getUkuran_botol());
        holder.tvharga.setText(String.valueOf(botolModelList.get(position).getHarga()));
        Glide.with(context).load(botolModelList.get(position).getGambar()).error(R.drawable.ic_launcher_foreground).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> itemCLickListener.onItemCLick(botolModelList.get(position)));
        holder.btndelete.setOnClickListener(v -> {
            ApiService apiService = ApiConfig.getApiService();
            apiService.postDelete(botolModelList.get(position).getId())
                    .enqueue(new Callback<ResponseErrorModel>() {
                        @Override
                        public void onResponse(Call<ResponseErrorModel> call,
                                               Response<ResponseErrorModel> response) {
                            if (response.isSuccessful()){
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                        }
                    });
        });
    }

    @Override
    public int getItemCount() {
        return botolModelList.size();
    }

    public class BotolViewHolder extends RecyclerView.ViewHolder {
        private TextView tvmerk,tvukuran,tvharga;
        private ImageView imageView;
        private Button btndelete;
        public BotolViewHolder(@NonNull View itemView) {
            super(itemView);
            tvmerk = itemView.findViewById(R.id.merk_botol);
            tvukuran = itemView.findViewById(R.id.ukuran_botol);
            tvharga = itemView.findViewById(R.id.harga_botol);
            imageView = itemView.findViewById(R.id.gambarbotol);
            btndelete = itemView.findViewById(R.id.buttondelete);
        }
    }
    public interface itemCLickListener {

        void onItemCLick(BotolModel dataModel);
    }
}
