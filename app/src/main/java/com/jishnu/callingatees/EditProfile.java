package com.jishnu.callingatees;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

public class EditProfile extends AppCompatActivity {
    ImageView back,cancel;
    LinearLayout profilephotolayout,profileNameLayout;
    TextInputEditText editText;
    TextView textView;

    AppCompatButton appCompatButton;

    String updatename="";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        back=findViewById(R.id.back);
        profilephotolayout=findViewById(R.id.profilePhotoLayout);
        profileNameLayout=findViewById(R.id.profileNameLayout);


        cancel=findViewById(R.id.cancelphoto);
        editText=findViewById(R.id.et_name);
        appCompatButton=findViewById(R.id.button_id_Upload);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this,ProfileActivity.class);
                startActivity(intent);
                 finish();
            }
        });
        profilephotolayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this,ProfileSelectActivity.class);
                startActivity(intent);
                finish();
            }
        });
        profileNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(EditProfile.this);
                View view=getLayoutInflater().inflate(R.layout.dialog_box,null);
                builder.setView(view);
                builder.show();





                appCompatButton=(AppCompatButton)view.findViewById(R.id.button_id_Upload);
                cancel=(ImageView)view.findViewById(R.id.cancelphoto);
                editText=(TextInputEditText)view.findViewById(R.id.et_name);
                final AlertDialog dialog = builder.create();
                appCompatButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editText.length()==0)
                        {
//
                        }
                        else
                        {
                           updatename= editText.getText().toString();

                           System.out.println("data  "+updatename);

                            dialog.cancel();
                        }
                        dialog.cancel();
                    }

                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(EditProfile.this,EditProfile.class);
                        startActivity(intent);
                        finish();
                    }
                });










            }
        });
    }
}