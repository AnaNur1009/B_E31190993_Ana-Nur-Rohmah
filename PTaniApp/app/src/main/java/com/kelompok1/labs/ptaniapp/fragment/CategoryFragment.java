package com.kelompok1.labs.ptaniapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok1.labs.ptaniapp.R;
import com.kelompok1.labs.ptaniapp.adapter.CategoryAdapter;
import com.kelompok1.labs.ptaniapp.helper.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    Data data;
    private RecyclerView recyclerView;
    private CategoryAdapter mAdapter;

    public CategoryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  tata letak untuk fragmen
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = view.findViewById(R.id.category_rv);
        data = new Data();
        mAdapter = new CategoryAdapter(data.getCategoryList(), getContext(), "Menu Produk");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Judul fragmen
        getActivity().setTitle("Menu Produk");
    }

}
