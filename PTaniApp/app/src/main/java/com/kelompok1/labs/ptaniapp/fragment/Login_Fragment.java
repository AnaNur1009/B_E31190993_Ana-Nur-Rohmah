package com.kelompok1.labs.ptaniapp.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;
import com.kelompok1.labs.ptaniapp.R;
import com.kelompok1.labs.ptaniapp.activity.MainActivity;
import com.kelompok1.labs.ptaniapp.model.User;
import com.kelompok1.labs.ptaniapp.util.CustomToast;
import com.kelompok1.labs.ptaniapp.util.Utils;
import com.kelompok1.labs.ptaniapp.util.localstorage.LocalStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Fragment extends Fragment implements OnClickListener {
    private static View view;

    private static EditText emailid, password;
    private static Button loginButton;
    private static TextView forgotPassword, signUp;
    private static CheckBox show_hide_password;
    private static LinearLayout loginLayout;
    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;

    ProgressDialog progressDialog;
    LocalStorage localStorage;
    User user;

    public Login_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_layout, container, false);
        initViews();
        setListeners();
        return view;
    }

    // Memulai Views
    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        emailid = view.findViewById(R.id.login_emailid);
        password = view.findViewById(R.id.login_password);
        loginButton = view.findViewById(R.id.loginBtn);
        forgotPassword = view.findViewById(R.id.forgot_password);
        signUp = view.findViewById(R.id.createAccount);
        show_hide_password = view.findViewById(R.id.show_hide_password);
        loginLayout = view.findViewById(R.id.login_layout);
        progressDialog = new ProgressDialog(getContext());
        localStorage = new LocalStorage(getContext());
        String userString;
        Gson gson = new Gson();
        userString = localStorage.getUserLogin();
        user = gson.fromJson(userString, User.class);
        Log.d("User", userString);
        // Muat Animasi Goyang
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);

        // Mengatur teks di atas tampilan
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),xrp);

            forgotPassword.setTextColor(csl);
            show_hide_password.setTextColor(csl);
            signUp.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    private void setListeners() {
        loginButton.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        signUp.setOnClickListener(this);

        // kotak centang untuk menampilkan dan menyembunyikan kata sandi
        show_hide_password.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton button,
                                                 boolean isChecked) {

                        // Jika sudah dicentang maka tampilkan kata sandi yang lain sembunyikan
                        // kata sandi
                        if (isChecked) {

                            show_hide_password.setText(R.string.hide_pwd);// perubahan
                            // kotak centang
                            // text

                            password.setInputType(InputType.TYPE_CLASS_TEXT);
                            password.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());// tunjukkan kata sandi
                        } else {
                            show_hide_password.setText(R.string.show_pwd);// perubahan
                            // kotak centang
                            // text

                            password.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            password.setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());// sembunyikan kata sandi

                        }

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                checkValidation();
                break;

            case R.id.forgot_password:

                // Ganti bagian kata sandi yang lupa dengan animasi
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer,
                                new ForgotPassword_Fragment(),
                                Utils.ForgotPassword_Fragment).commit();
                break;
            case R.id.createAccount:

                // Ganti frgament pendaftaran dengan animasi
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new SignUp_Fragment(),
                                Utils.SignUp_Fragment).commit();
                break;
        }

    }

    // Periksa Validasi sebelum masuk
    private void checkValidation() {
        // Get email id and password
        final String getEmailId = emailid.getText().toString();
        final String getPassword = password.getText().toString();

        // Periksa pola untuk id email
        Pattern p = Pattern.compile(Utils.regEx);

        Matcher m = p.matcher(getEmailId);

        // Periksa apakah kedua bidang kosong atau tidak
        if (getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0) {
            loginLayout.startAnimation(shakeAnimation);
            new CustomToast().Show_Toast(getActivity(), view,
                    "Email Dan Kata Sandi Tidak Valid");
            vibrate(200);
        }
        // Periksa apakah id email valid atau tidak
        else if (!m.find()) {
            new CustomToast().Show_Toast(getActivity(), view,
                    "Email Anda Tidak Valid");
            vibrate(200);
        } else {

            progressDialog.setMessage("Mohon tunggu....");
            progressDialog.show();

            Handler mHand = new Handler();
            mHand.postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (user != null) {
                        if (!user.getEmail().equalsIgnoreCase(getEmailId) || !user.getPassword().equalsIgnoreCase(getPassword)) {
                            new CustomToast().Show_Toast(getActivity(), view,
                                    "Mohon Periksa Email atau Kata Sandi");
                        } else {
                            startActivity(new Intent(getActivity(), MainActivity.class));
                            getActivity().finish();
                            getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                        }
                    } else {
                        new CustomToast().Show_Toast(getActivity(), view,
                                "Silahkan Daftar dengan Email");
                    }

                    progressDialog.dismiss();

                }
            }, 5000);

        }
    }

    public void vibrate(int duration) {
        Vibrator vibs = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        vibs.vibrate(duration);
    }
}
