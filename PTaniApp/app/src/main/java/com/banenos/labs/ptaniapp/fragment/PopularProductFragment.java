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
import com.banenos.labs.ptaniapp.adapter.PopularProductAdapter;
import com.banenos.labs.ptaniapp.helper.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularProductFragment extends Fragment {
    RecyclerView pRecyclerView;
    Data data;
    private PopularProductAdapter pAdapter;

    public PopularProductFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // tata letak untuk fragmen
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        data = new Data();
        pRecyclerView = view.findViewById(R.id.popular_product_rv);
        pAdapter = new PopularProductAdapter(data.getPopularList(), getContext(), "pop");
        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext());
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pRecyclerView.setAdapter(pAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //judul fragmen
        getActivity().setTitle("Popular Produk");
    }
}
