package com.banenos.labs.ptaniapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.banenos.labs.ptaniapp.R;
import com.banenos.labs.ptaniapp.model.User;
import com.banenos.labs.ptaniapp.model.UserAddress;
import com.banenos.labs.ptaniapp.util.Utils;
import com.banenos.labs.ptaniapp.util.localstorage.LocalStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * A simple {@link Fragment} subclass.
 */
public class AddressFragment extends Fragment {

    Context context;
    TextView txt_pyment;
    Spinner citySpinner, stateSpinner;
    ArrayList<String> stringArrayState;
    ArrayList<String> stringArrayCity;
    String _city, _name, _email, _mobile, _address, userString;
    EditText name, email, mobile, address;
    UserAddress userAddress;
    LocalStorage localStorage;
    Gson gson;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_address, container, false);
        citySpinner = v.findViewById(R.id.citySpinner);
        stateSpinner = v.findViewById(R.id.stateSpinner);
        name = v.findViewById(R.id.sa_name);
        email = v.findViewById(R.id.sa_email);
        mobile = v.findViewById(R.id.sa_mobile);
        address = v.findViewById(R.id.sa_address);

        localStorage = new LocalStorage(getContext());
        gson = new Gson();
        userString = localStorage.getUserLogin();
        User user = gson.fromJson(userString, User.class);
        userAddress = gson.fromJson(localStorage.getUserAddress(), UserAddress.class);
        Log.d("User String : ", userString);
        if (user != null) {
            name.setText(user.getName());
            email.setText(user.getEmail());
            mobile.setText(user.getMobile());
        }


        if (userAddress != null) {
            name.setText(userAddress.getName());
            email.setText(userAddress.getEmail());
            mobile.setText(userAddress.getMobile());
            address.setText(userAddress.getAddress());

        }

        init();
        context = container.getContext();
        txt_pyment = v.findViewById(R.id.txt_pyment);

        txt_pyment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _name = name.getText().toString();
                _email = email.getText().toString();
                _mobile = mobile.getText().toString();
                _address = address.getText().toString();
                Pattern p = Pattern.compile(Utils.regEx);

                Matcher m = p.matcher(_email);

                if (_name.length() == 0) {
                    name.setError("Nama Lengkap");
                    name.requestFocus();
                } else if (_email.length() == 0) {
                    email.setError("Alamat Email");
                    email.requestFocus();
                } else if (!m.find()) {
                    email.setError("Masukkan email yang benar");
                    email.requestFocus();

                } else if (_mobile.length() == 13) {
                    mobile.setError("Masukkan Nomor Ponsel");
                    mobile.requestFocus();
                } else if (_mobile.length() < 0) {
                    mobile.setError("Masukkan Nomor Ponsel yang Benar");
                    mobile.requestFocus();
                } else if (_address.length() == 0) {
                    address.setError("Masukkan Alamat Anda");
                    address.requestFocus();
                    userAddress = new UserAddress(_name, _email, _mobile);
                    String user_address = gson.toJson(userAddress);
                    localStorage.setUserAddress(user_address);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);
                    ft.replace(R.id.content_frame, new PaymentFragment());
                    ft.commit();
                }


            }
        });
        return v;
    }

    private void init() {
        stringArrayState = new ArrayList<>();
        stringArrayCity = new ArrayList<>();
        final ArrayAdapter<String> adapterCity = new ArrayAdapter<String>(getActivity(), R.layout.spinnertextview, stringArrayCity);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapterCity);
        if (userAddress != null) {
            int selectionPosition1 = adapterCity.getPosition(userAddress.getCity());
            citySpinner.setSelection(selectionPosition1);
        }

        try {
            JSONObject obj = new JSONObject(loadJSONFromAssetState());
            JSONArray m_jArry = obj.getJSONArray("list of cities");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);

                String state = jo_inside.getString("Kota");
                String id = jo_inside.getString("id");

                stringArrayState.add(state);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.spinnertextview, stringArrayState);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter);
        if (userAddress != null) {
            int selectionPosition = adapter.getPosition(userAddress.getState());
            stateSpinner.setSelection(selectionPosition);
        }

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerCityValue = String.valueOf(citySpinner.getSelectedItem());
                Log.e("SpinnerCityValue", spinnerCityValue);

                _city = spinnerCityValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public String loadJSONFromAssetState() {
        String json;
        try {
            InputStream is = getContext().getAssets().open("state.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Judul fragmen
        getActivity().setTitle("Alamat");
    }
}
