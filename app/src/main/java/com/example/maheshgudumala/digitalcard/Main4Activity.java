package com.example.maheshgudumala.digitalcard;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main4Activity extends AppCompatActivity {
    ImageView image;
    String text2Qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        image = findViewById(R.id.image);
        String fileName1 = "Name" + ".txt";
        String fileName2 = "Company" + ".txt";
        String fileName3 = "Designation" + ".txt";
        String fileName4 = "Phone_pri" + ".txt";
        String fileName5 = "Phone_sec" + ".txt";
        String fileName6 = "Email" + ".txt";
        String fileName7 = "Resi_add" + ".txt";
        String fileName8 = "Work_add" + ".txt";
        try {
            File root = new File(Environment.getExternalStorageDirectory() + File.separator + "DigitalCard", "Values");
            //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
//                            name.setText("Name");
//                            company.setText("Company");
//                            designation.setText("Designation");
//                            phone_pri.setText("Phone-primary");
//                            phone_sec.setText("Phone-secondary");
//                            email.setText("Email");
//                            resi_add.setText("Residential address");
//                            work_add.setText("Work Place Address");
            }
            //else {
            StringBuilder str = new StringBuilder("");
            //str.append("{\"name\":");
            String st;
            File namefile = new File(root, fileName1);
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(namefile));
            st = bufferedReader1.readLine();
            str.append(st);
            str.append("\n");
            //name.setText(st);
            //str.append("\""+st+"\",\"company\":");
            File companyfile = new File(root, fileName2);
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(companyfile));
            st = bufferedReader2.readLine();
            str.append(st);
            str.append("\n");
            //company.setText(st);
           // str.append("\""+st+"\",\"designation\":");
            File designationfile = new File(root, fileName3);
            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(designationfile));
            st = bufferedReader3.readLine();
            str.append(st);
            str.append("\n");
            //designation.setText(st);
           // str.append("\""+st+"\",\"phone_pri\":");
            File phone_prifile = new File(root, fileName4);
            BufferedReader bufferedReader4 = new BufferedReader(new FileReader(phone_prifile));
            st = bufferedReader4.readLine();
            str.append(st);
            str.append("\n");
            //phone_pri.setText(st);
           // str.append("\""+st+"\",\"phone_sec\":");
            File phone_secfile = new File(root, fileName5);
            BufferedReader bufferedReader5 = new BufferedReader(new FileReader(phone_secfile));
            st = bufferedReader5.readLine();
            str.append(st);
            str.append("\n");
            //phone_sec.setText(st);
           // str.append("\""+st+"\",\"email\":");
            File emailfile = new File(root, fileName6);
            BufferedReader bufferedReader6 = new BufferedReader(new FileReader(emailfile));
            st = bufferedReader6.readLine();
            str.append(st);
            str.append("\n");
//            email.setText(st);
            //str.append("\""+st+"\",\"resi_add\":");
            File resi_addfile = new File(root, fileName7);
            BufferedReader bufferedReader7 = new BufferedReader(new FileReader(resi_addfile));
            st = bufferedReader7.readLine();
            str.append(st);
            str.append("\n");
            //resi_add.setText(st);
           // str.append("\""+st+"\",\"work_add\":");
            File work_addfile = new File(root, fileName8);
            BufferedReader bufferedReader8 = new BufferedReader(new FileReader(work_addfile));
            st = bufferedReader8.readLine();
            str.append(st);

//            work_add.setText(st);
           // str.append("\""+st+"\"}");
            text2Qr = str.toString();
            //}
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        }  catch (IOException e) {
        e.printStackTrace();

       }  catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
