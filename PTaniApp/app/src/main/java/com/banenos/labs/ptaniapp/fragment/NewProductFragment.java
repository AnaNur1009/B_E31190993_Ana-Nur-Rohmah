package com.banenos.labs.ptaniapp.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.banenos.labs.ptaniapp.R;
import com.banenos.labs.ptaniapp.adapter.NewProductAdapter;
import com.banenos.labs.ptaniapp.helper.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewProductFragment extends Fragment {
    RecyclerView nRecyclerView;
    Data data;
    private NewProductAdapter pAdapter;

    public NewProductFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // tata letak untuk fragmen
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        data = new Data();
        nRecyclerView = view.findViewById(R.id.new_product_rv);
        pAdapter = new NewProductAdapter(data.getNewList(), getContext(), "new");
        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext());
        nRecyclerView.setLayoutManager(pLayoutManager);
        nRecyclerView.setItemAnimator(new DefaultItemAnimator());
        nRecyclerView.setAdapter(pAdapter);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Judul fragmen
        getActivity().setTitle("New Produk");
    }
}
