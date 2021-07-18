package com.kelompok1.labs.ptaniapp.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.kelompok1.labs.ptaniapp.R;
import com.kelompok1.labs.ptaniapp.activity.LoginRegisterActivity;
import com.kelompok1.labs.ptaniapp.activity.MainActivity;
import com.kelompok1.labs.ptaniapp.model.User;
import com.kelompok1.labs.ptaniapp.util.CustomToast;
import com.kelompok1.labs.ptaniapp.util.Utils;
import com.kelompok1.labs.ptaniapp.util.localstorage.LocalStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp_Fragment extends Fragment implements OnClickListener {
    private static View view;
    private static EditText fullName, emailId, mobileNumber, password;
    private static TextView login;
    private static Button signUpButton;
    private static CheckBox terms_conditions;
    ProgressDialog progressDialog;
    User user;
    LocalStorage localStorage;
    Gson gson;

    public SignUp_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.signup_layout, container, false);
        initViews();
        setListeners();
        return view;
    }

    // Inisialisasi semua tampilan
    private void initViews() {
        fullName = view.findViewById(R.id.fullName);
        emailId = view.findViewById(R.id.userEmailId);
        mobileNumber = view.findViewById(R.id.mobileNumber);

        password = view.findViewById(R.id.password);

        signUpButton = view.findViewById(R.id.signUpBtn);
        login = view.findViewById(R.id.already_user);
        terms_conditions = view.findViewById(R.id.terms_conditions);
        progressDialog = new ProgressDialog(getContext());

        // Mengatur text di atas tamilan
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),xrp);

            login.setTextColor(csl);
            terms_conditions.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    private void setListeners() {
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:

                // periksa metode Validasi
                checkValidation();
                break;

            case R.id.already_user:

                // Ganti fragmen login
                new LoginRegisterActivity().replaceLoginFragment();
                break;
        }

    }

    // Periksa Metode Validasi
    private void checkValidation() {
        // Dapatkan semua teks
        String getFullName = fullName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getMobileNumber = mobileNumber.getText().toString();
        String getPassword = password.getText().toString();
        // Kecocokan pola untuk id email
        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailId);


        if (getFullName.length() == 0) {
            fullName.setError("Masukkan Nama Anda");
            fullName.requestFocus();
        } else if (getEmailId.length() == 0) {
            emailId.setError("Masukkan Email Anda");
            emailId.requestFocus();
        } else if (!m.find()) {
            emailId.setError("Masukkan Email Yang Benar");
            emailId.requestFocus();
        } else if (getMobileNumber.length() == 13) {
            mobileNumber.setError("Masukkan Nomor Ponsel Anda");
            mobileNumber.requestFocus();
        } else if (getPassword.length() == 0) {
            password.setError("Masukkan Masukan Sandi");
            password.requestFocus();
        } else if (getPassword.length() < 6) {
            password.setError("Masukkan 6 Digit Kata Sandi");
            password.requestFocus();
        } else if (!terms_conditions.isChecked()) {
            new CustomToast().Show_Toast(getActivity(), view,
                    "Terima Syarat & Ketentuan");
        } else {
            user = new User("1", getFullName, getEmailId, getMobileNumber, getPassword);
            gson = new Gson();
            String userString = gson.toJson(user);
            localStorage = new LocalStorage(getContext());
            localStorage.createUserLoginSession(userString);
            progressDialog.setMessage("Mohon tunggu....");
            progressDialog.show();
            Handler mHand = new Handler();
            mHand.postDelayed(new Runnable() {

                @Override
                public void run() {
                    progressDialog.dismiss();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }, 5000);
        }

    }
}
