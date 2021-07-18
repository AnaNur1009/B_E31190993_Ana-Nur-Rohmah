package com.kelompok1.labs.ptaniapp.util;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kelompok1.labs.ptaniapp.R;

public class CustomToast {

    // Metode kostum
    public void Show_Toast(Context context, View view, String error) {

        // meluaskan tampilan kustom
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // mengembangkan tata letak di atas tampilan
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) view.findViewById(R.id.toast_root));

        // setelan kesalahan teks
        TextView text = layout.findViewById(R.id.toast_error);
        text.setText(error);

        Toast toast = new Toast(context);// Dapatkan Konteks Toast
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);// Set

        toast.setDuration(Toast.LENGTH_SHORT);// atur durasi
        toast.setView(layout); // Atur Tampilan

        toast.show();// Finally show toast
    }

}
