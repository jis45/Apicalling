package com.jishnu.callingatees.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;
import com.jishnu.callingatees.Model.ApiClient;
import com.jishnu.callingatees.Model.ApiInterface;
import com.jishnu.callingatees.Model.JsonModel;
import com.jishnu.callingatees.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Signup_Tab_Fragment extends Fragment {
    SearchableSpinner countryCodePicker;
    TextInputEditText ETfullname, ETemail, ETphone, EtPassword;
    CardView signUp;

    private ProgressDialog progressDialog;

    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.sign_tab_fragment, container, false);
        ETfullname = root.findViewById(R.id.edtFullname);
        ETemail = root.findViewById(R.id.edtEmail);
        ETphone = root.findViewById(R.id.edtPhone);
        EtPassword = root.findViewById(R.id.edtPassword);
        countryCodePicker = root.findViewById(R.id.spinner);
        signUp = root.findViewById(R.id.signup);
        progressDialog= new ProgressDialog(getActivity());
//
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();


            }
        });

        return root;

    }

    private void register() {
        String fullname = ETfullname.getText().toString();
        String email = ETemail.getText().toString();
        String phonenumber = ETphone.getText().toString();
        String password = EtPassword.getText().toString();
        

        if (fullname.isEmpty()) {
            ETfullname.requestFocus();
            ETfullname.setError("Please enter your name");
            return;
        }
        if (email.isEmpty()) {
            ETemail.requestFocus();
            ETemail.setError("Please enter your Email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ETemail.requestFocus();
            ETemail.setError("Please enter correct Email");
            return;
        }

        if (password.isEmpty()) {
            EtPassword.requestFocus();
            EtPassword.setError("Please enter your Password");
            return;
        }


        if (password.length() < 5) {
            EtPassword.requestFocus();
            EtPassword.setError("Please enter minimum 5 character");
        }
        if (phonenumber.isEmpty()) {
            ETphone.requestFocus();
            ETphone.setError("Please enter the number");
        }
        progressDialog.setMessage("Data in Process....");
        progressDialog.setCancelable(false);
        progressDialog.show();


        ApiInterface apiInterface =ApiClient.getRetrofit().create(ApiInterface.class);
        final JsonModel jsonModel= new JsonModel(ETfullname.getText().toString(),
                                                  ETemail.getText().toString(),
                                                  EtPassword.getText().toString());
        Log.d("datacheck  ",String.valueOf(jsonModel));
        Call<JsonModel>call=apiInterface.postdata(jsonModel);
        call.enqueue(new Callback<JsonModel>() {
            @Override
            public void onResponse(Call<JsonModel> call, Response<JsonModel> response) {
                progressDialog.dismiss();
                if (response.isSuccessful())
                {
                    Toast.makeText(getActivity(), "uploading successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "uploading rejected", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JsonModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }









}









