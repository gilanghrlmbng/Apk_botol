package com.depot_air.ui.insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.depot_air.R;

public class InsertFragment extends Fragment {

    private InsertViewModel insertViewModel;
    private EditText et_merk;
    private EditText et_ukuran;
    private EditText et_harga;
    private EditText et_gambar;
    private Button btnsave;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insertViewModel =
                new ViewModelProvider(this).get(InsertViewModel.class);
        View root = inflater.inflate(R.layout.fragment_insert, container, false);
        et_merk = root.findViewById(R.id.field_merk);
        et_ukuran = root.findViewById(R.id.field_ukuran);
        et_harga = root.findViewById(R.id.field_harga);
        et_gambar = root.findViewById(R.id.field_gambar);
        btnsave = root.findViewById(R.id.btn_simpan);

        btnsave.setOnClickListener(v -> {
            insertViewModel.postOrders(et_merk.getText().toString(),et_ukuran.getText().toString(),et_harga.getText().toString(),et_gambar.getText().toString())
            .observe(getActivity(),botolResponse ->{
                Toast.makeText(getActivity(), "Sukses Menyimpan", Toast.LENGTH_SHORT).show();
            });
            et_merk.setText(null);
            et_ukuran.setText(null);
            et_harga.setText(null);
            et_gambar.setText(null);
        });
        return root;
    }
}