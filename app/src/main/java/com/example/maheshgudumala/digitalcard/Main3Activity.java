package com.example.maheshgudumala.digitalcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    private ImageButton button;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final int REQUEST_CAMERA = 1;
    public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GridViewDemo/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = BaseCameraActivity.createCameraIntent(Main3Activity.this);
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            ImageView imageView = findViewById(R.id.image_photo);
            String imgcurTime = dateFormat.format(new Date());
            byte[] bytes = data.getByteArrayExtra(BaseCameraActivity.KEY_IMAGE);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
            if (bytes != null) {
                File imageDirectory = new File(GridViewDemo_ImagePath);
                imageDirectory.mkdirs();
                Bitmap thePic = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                String _path = GridViewDemo_ImagePath + imgcurTime + ".jpg";
                try {
                    FileOutputStream out = new FileOutputStream(_path);
                    thePic.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.close();
                } catch (FileNotFoundException e) {
                    e.getMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
//
////                imageView.setImageResource(R.drawable.i);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//
//                if (bitmap != null) {
//
//                    File file = new File(Environment.getExternalStorageDirectory() + "/dbc/media");
//                    if (!file.isDirectory()) {
//                        file.mkdir();
//                    }
//
//                    file = new File(Environment.getExternalStorageDirectory() + "/dbc/media" + imgcurTime + ".jpg");
//
//
//                    try {
//                        FileOutputStream fileOutputStream = new FileOutputStream(file);
//                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
//
//                        fileOutputStream.flush();
//                        fileOutputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
        }
    }

}
