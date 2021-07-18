package com.kelompok1.labs.ptaniapp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok1.labs.ptaniapp.R;
import com.kelompok1.labs.ptaniapp.activity.BaseActivity;
import com.kelompok1.labs.ptaniapp.adapter.OrderAdapter;
import com.kelompok1.labs.ptaniapp.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderFragment extends Fragment {
    LinearLayout linearLayout;
    private List<Order> orderList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderAdapter mAdapter;

    public MyOrderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // tata letak untuk fragmen
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        recyclerView = view.findViewById(R.id.order_rv);
        orderList = ((BaseActivity) getActivity()).getOrderList();
        mAdapter = new OrderAdapter(orderList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        linearLayout = view.findViewById(R.id.no_order_ll);
        if (orderList.isEmpty()) {
            linearLayout.setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Judul fragmen
        getActivity().setTitle("My Order");
    }
}
