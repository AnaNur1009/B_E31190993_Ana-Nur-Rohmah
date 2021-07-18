package com.banenos.labs.ptaniapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentTransaction;

import com.banenos.labs.ptaniapp.R;
import com.banenos.labs.ptaniapp.fragment.AddressFragment;

public class CheckoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#222831")));
        changeActionBarTitle(getSupportActionBar());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);
        ft.replace(R.id.content_frame, new AddressFragment());
        ft.commit();


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
        tv.setText("Checkout"); // Teks judul ActionBar
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(CheckoutActivity.this, CartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}