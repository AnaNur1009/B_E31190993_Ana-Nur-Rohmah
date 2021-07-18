package com.banenos.labs.ptaniapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.banenos.labs.ptaniapp.R;
import com.banenos.labs.ptaniapp.adapter.ProductAdapter;
import com.banenos.labs.ptaniapp.helper.Converter;
import com.banenos.labs.ptaniapp.helper.Data;

public class ProductActivity extends BaseActivity {
    private static int cart_count = 0;
    Data data;
    ProductAdapter mAdapter;
    String Tag = "List";
    private RecyclerView recyclerView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#222831")));
        changeActionBarTitle(getSupportActionBar());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        cart_count = cartCount();
        recyclerView = findViewById(R.id.product_rv);
        data = new Data();
        setUpRecyclerView();

    }

    private void changeActionBarTitle(ActionBar actionBar) {
        // Buat LayoutParams untuk TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Lebar TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Tinggi TextView
        TextView tv = new TextView(getApplicationContext());
        // Terapkan parameter tata letak ke widget TextView
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);

        // Atur teks untuk ditampilkan di TextView
        tv.setText("Produk"); // Teks judul ActionBar
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Merienda-Bold.ttf");
        tv.setTypeface(tf);
        tv.setTextSize(20);

        // Baris ini mengubah warna teks judul ActionBar
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        // Setel opsi tampilan ActionBar
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Setel TextView yang baru dibuat sebagai tampilan kustom ActionBar
        actionBar.setCustomView(tv);
    }

    private void setUpRecyclerView() {
        data = new Data();
        mAdapter = new ProductAdapter(data.getProductList(), ProductActivity.this, Tag);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    private void setUpGridRecyclerView() {
        data = new Data();
        mAdapter = new ProductAdapter(data.getProductList(), ProductActivity.this, Tag);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public void onToggleClicked(View view) {
        if (Tag.equalsIgnoreCase("List")) {
            Tag = "Grid";
            setUpGridRecyclerView();
        } else {
            Tag = "List";
            setUpRecyclerView();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            case R.id.cart_action:
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menambahkan item bilah ada tindakan
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(ProductActivity.this, cart_count, R.drawable.ic_shopping_basket));
        return true;
    }


    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();

    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();

    }

}
