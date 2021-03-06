package com.kelompok1.labs.ptaniapp.fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kelompok1.labs.ptaniapp.R;
import com.kelompok1.labs.ptaniapp.activity.LoginRegisterActivity;
import com.kelompok1.labs.ptaniapp.util.CustomToast;
import com.kelompok1.labs.ptaniapp.util.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPassword_Fragment extends Fragment implements OnClickListener {

    private static View view;
    private static EditText emailId;
    private static TextView submit, back;

    public ForgotPassword_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgotpassword_layout, container,
                false);
        initViews();
        setListeners();
        return view;
    }

    // Inisialisasi tampilan
    private void initViews() {
        emailId = view.findViewById(R.id.registered_emailid);
        submit = view.findViewById(R.id.forgot_button);
        back = view.findViewById(R.id.backToLoginBtn);

        // Mengatur teks di atas tampilan
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {

            ColorStateList csl = ColorStateList.createFromXml(getResources(),xrp);
            back.setTextColor(csl);
            submit.setTextColor(csl);

        } catch (Exception e) {
        }

    }

    // Atur tombol di atas
    private void setListeners() {
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:

                // Ganti Fragmen Login
                new LoginRegisterActivity().replaceLoginFragment();
                break;

            case R.id.forgot_button:

                // tombol Kirim Panggilan
                submitButtonTask();
                break;

        }

    }

    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();

        // validasi id email
        Pattern p = Pattern.compile(Utils.regEx);

        // Cocokkan polanya
        Matcher m = p.matcher(getEmailId);

        // periksa apakah id email bukan null jika tidak, tampilkan error toast
        if (getEmailId.equals("") || getEmailId.length() == 0)

            new CustomToast().Show_Toast(getActivity(), view,
                    "Please enter your Email Id.");

            // apakah id email valid atau tidak
        else if (!m.find())
            new CustomToast().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");

            // kirimkan id email dan ambil passwod
        else
            Toast.makeText(getActivity(), "Get Forgot Password.",
                    Toast.LENGTH_SHORT).show();
    }
}