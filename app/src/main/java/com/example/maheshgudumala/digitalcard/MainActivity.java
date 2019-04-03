package com.example.maheshgudumala.digitalcard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_WRITE = 100;
    private boolean permissionGranted;
    Button ScannedCard;
    Button profile;
    Button TakeNew;
    Button AllCards;
    Button MyQrCode;

    Button scanCard;
    private IntentIntegrator qrScan;

    static Integer integer;
   // private ScannedCards[] scannedCards;

    // private ScannedCards[] scannedCards;
    //ImageView image;
   // String text2Qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TakeNew = findViewById(R.id.button);
       // image = findViewById(R.id.image);
       MyQrCode = findViewById(R.id.button6);
        ScannedCard = findViewById(R.id.button7);
         scanCard = findViewById(R.id.button8);
        qrScan = new IntentIntegrator(this);
        scanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
        //image.findViewById(R.id.image);
        TakeNew.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        ScannedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        AllCards = findViewById(R.id.button2);
        AllCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        profile = findViewById(R.id.button3);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
       // text2Qr = text.getText().toString().trim();
        MyQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

       if(!permissionGranted){
            checkPermissions();
            return;
        }
    }

    private void openActivity5() {
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }

    private void openActivity4(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

    private void openActivity3() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openActivity(){

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }
    private boolean checkPermissions() {

        if (!isExternalStorageWritable()) {
            Toast.makeText(this, "This app only works on devices with usable external storage",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck1 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED && permissionCheck1 != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                    REQUEST_PERMISSION_WRITE);
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_WRITE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = true;
                    Toast.makeText(this, "External storage and Camera permission granted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You must grant permission!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            //if qr contains data
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                try {
//                    String Name;
//                    String Company;
//                    String Designation;
//                    String Phone_pri;
//                    String Phone_sec;
//                    String Email;
//                    String Resi_add;
//                    String Work_add;
//                    //converting the data to json
//                    JSONObject obj = new JSONObject(result.getContents());
//                    //String std = result.getContents().toString();
//                    //StringBuilder stringBuilder = new StringBuilder(result.getContents());
//                    //setting values to textviews
//                    Name = obj.getString("name");
//                    Company = obj.getString("company");
//                    Designation = obj.getString("designation");
//                    Phone_pri = obj.getString("phone_pri");
//                    Phone_sec = obj.getString("phone_sec");
//                    Email = obj.getString("email");
//                    Resi_add = obj.getString("resi_add");
//                    Work_add = obj.getString("work_add");
//                    name.setText(Name);
//                    company.setText(Company);
//                    designation.setText(Designation);
//                    phone_pri.setText(Phone_pri);
//                    phone_sec.setText(Phone_sec);
//                    email.setText(Email);
//                    resi_add.setText(Resi_add);
//                    work_add.setText(Work_add);
                    //integer++;
                    //StringBuilder stringBuilder = new StringBuilder("");
                    String string = result.getContents();
                    Scanner scr = new Scanner(string);
                    String file = new String(scr.nextLine());
                    scr.close();
                    Scanner sc = new Scanner(string);
                    //BufferedReader bufferedReader = new BufferedReader(result.getContents());
                    String fileName = ""+file+".txt";
                    File root = new File(Environment.getExternalStorageDirectory()+File.separator+"DigitalCard", "Cards");
                    //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    if (!root.exists())
                    {
                        root.mkdirs();
                    }
                    File namefile = new File(root, fileName);
                    FileWriter writer1 = new FileWriter(namefile, false);
                    writer1.append(result.getContents().toString());
                    writer1.flush();
                    writer1.close();
//                    if (Name != null && Company != null && Designation != null && Phone_pri != null && Phone_sec != null && Email != null & Resi_add != null && Work_add != null) {
//                        Intent intent = new Intent(this, Main5Activity.class);
//                        intent.putExtra("name",Name);
//                        intent.putExtra("company", Company);
//                        intent.putExtra("designation", Designation);
//                        intent.putExtra("phone_pri", Phone_pri);
//                        intent.putExtra("phone_sec", Phone_sec);
//                        intent.putExtra("email", Email);
//                        intent.putExtra("resi_add", Resi_add);
//                        intent.putExtra("work_add", Work_add);
                        //startActivity(intent);
//                        for (ScannedCards cards : scannedCards = new ScannedCards[100] ) {
//                            cards = new ScannedCards(Name, Company, Designation, Phone_pri, Phone_sec, Email, Resi_add, Work_add);
//                            ;
//                        }

                        //(Name,Company,Designation,Phone_pri,Phone_sec,Email,Resi_add,Work_add);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    //if control comes here
//                    //that means the encoded format not matches
//                    //in this case you can display whatever data is available on the qrcode
//                    //to a toast
//                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == REQUEST_PERMISSION_WRITE && resultCode == RESULT_OK) {
            // ImageView imageView = findViewById(R.id.image_photo);
           // byte[] bytes = data.getByteArrayExtra(BaseCameraActivity.KEY_IMAGE);
            //imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));

        }
    }


}
