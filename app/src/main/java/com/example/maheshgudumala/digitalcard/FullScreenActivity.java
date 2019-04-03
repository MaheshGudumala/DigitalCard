package com.example.maheshgudumala.digitalcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        Bundle extras = getIntent().getExtras();
        Bitmap bitmap = (Bitmap) extras.get("image");
        //Bitmap bitmap = getIntent().getParcelableExtra("image");


        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageBitmap(bitmap);
    }
}
