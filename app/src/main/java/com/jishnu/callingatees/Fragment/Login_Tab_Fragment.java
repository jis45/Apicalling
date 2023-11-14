package com.jishnu.callingatees.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class Login_Tab_Fragment extends Fragment {
     private  SearchableSpinner countryCodePicker;
     private   TextInputEditText ETphone;
     private   CardView Login;

     private ProgressDialog progressDialog;







    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          ViewGroup root=(ViewGroup) inflater.inflate(com.jishnu.callingatees.R.layout.login_tab_fragment,container,false);

        countryCodePicker=root.findViewById(com.jishnu.callingatees.R.id.spinner);
        ETphone=root.findViewById(com.jishnu.callingatees.R.id.edtPhone);
        Login=root.findViewById(com.jishnu.callingatees.R.id.Login);
        progressDialog= new ProgressDialog(getActivity());






        return root;
//    }

//    private void getcountrylist() {
//        JSONObject jsonObject=new JSONObject();
//        try {
//            jsonObject.put("language","English");
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//        AndroidNetworking.post(prefConfigure.readcountryapi())
//                .addJSONObjectBody(jsonObject)
//                .addHeaders("apitoken",prefConfigure.readtoken())
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            String statusval = response.getString("status");
//                            JSONArray jsonArray = response.getJSONArray("data");
//
//                            List<countrycodedetail> countryList = new ArrayList<>();
//
//                            int len = jsonArray.length();
//
//                            int count=0;
//
//                            String countryId,countryCode,countryName,ISOCode;
//
//                            while(count<jsonArray.length())
//                            {
//                                JSONObject JO = jsonArray.getJSONObject(count);
//
//                                countryId = JO.getString("countryId");
//                                countryCode = JO.getString("countryCode");
//                                countryName = JO.getString("countryName");
//                                ISOCode = JO.getString("ISOCode");
//
//                                countrycodedetail countryArray = new countrycodedetail(countryId,countryCode,countryName,ISOCode);
//
//                                countryList.add(countryArray);
//                                count++;
//                            }
//
//
//
//                            ArrayAdapter<countrycodedetail> adaptstate = new ArrayAdapter<countrycodedetail> (getContext(), com.jishnu.callingatees.R.layout.country_code_picker_val,countryList);
//                            countryCodePicker.setAdapter(adaptstate);
//
//                            String currentCountryCode = "91";
//
//                            for(int  i =0;i<countryCodePicker.getCount();i++)
//                            {
//                                countrycodedetail sd = (countrycodedetail)countryCodePicker.getItemAtPosition(i);
//
//                                if(sd.getCountryCode().equals(currentCountryCode))
//                                {
//                                    //Toast.makeText(getApplicationContext(), sd.getCountryCode(), Toast.LENGTH_SHORT).show();
//                                    countryCodePicker.setSelection(i);
//                                }
//                            }
//
//
//                        } catch (JSONException e) {
//                         e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });
//


    }
}
