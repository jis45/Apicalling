package com.jishnu.callingatees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProfileSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_COVER_REQUEST_ID = 45;
    private static final int GALLERY_COVER_REQUEST_ID = 85;

    private Bitmap thumbnail;

    Uri imageUri;

    ImageView back, selectphoto, viewphoto;

    AppCompatButton update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_select);
        back = findViewById(R.id.back);
        selectphoto = findViewById(R.id.selectphoto);
        viewphoto = findViewById(R.id.profile_imageEdit);
        update=findViewById(R.id.button_id_Upload);


        selectphoto.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileSelectActivity.this, EditProfile.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectphoto:
                PopupMenu menu = new PopupMenu(this, selectphoto);

                menu.getMenu().add(0, 0, 0, "Pick Image");
                menu.getMenu().add(1, 1, 1, "Take Image");
                menu.show();

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case 0:
                                chooseImageFromGallary();
                                break;
                            case 1:
                                takeImageFromCamera();
                                break;

                        }

                        return false;
                    }
                });
                break;

            case R.id.button_id_Upload:
                 imageUpdate();


        }
    }

    private void imageUpdate() {


    }

    private void takeImageFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_COVER_REQUEST_ID);
    }

    private void chooseImageFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_COVER_REQUEST_ID);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY_COVER_REQUEST_ID) {
            imageUri= data.getData();
             viewphoto.setImageURI(imageUri);

             System.out.println("checker  "+imageUri);


        } else if (requestCode == CAMERA_COVER_REQUEST_ID) {

            viewphoto.setImageURI(imageUri);
        }


    }

    private void uploadImage(Bitmap b2) {

    }


}