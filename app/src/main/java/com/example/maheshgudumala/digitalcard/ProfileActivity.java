package com.example.maheshgudumala.digitalcard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_1 = 1;
    private Button edit;
    public static TextView name;
    public static TextView company;
    public static TextView designation;
    public static TextView phone_pri;
    public static TextView phone_sec;
    public static TextView email;
    public static TextView resi_add;
    public static TextView work_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edit = findViewById(R.id.button4);
        name = findViewById(R.id.textView);
        company = findViewById(R.id.textView2);
        designation = findViewById(R.id.textView3);
        phone_pri = findViewById(R.id.textView4);
        phone_sec = findViewById(R.id.textView5);
        email = findViewById(R.id.textView6);
        resi_add = findViewById(R.id.textView7);
        work_add = findViewById(R.id.textView8);
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
//                root.mkdirs();
                name.setText("Name");
                company.setText("Company");
                designation.setText("Designation");
                phone_pri.setText("Phone-primary");
                phone_sec.setText("Phone-secondary");
                email.setText("Email");
                resi_add.setText("Residential address");
                work_add.setText("Work Place Address");
            } else {
                String st = new String();
                File namefile = new File(root, fileName1);
                BufferedReader bufferedReader1 = new BufferedReader(new FileReader(namefile));
                st = bufferedReader1.readLine();
                name.setText(st);
                File companyfile = new File(root, fileName2);
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(companyfile));
                st = bufferedReader2.readLine();
                company.setText(st);
                File designationfile = new File(root, fileName3);
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(designationfile));
                st = bufferedReader3.readLine();
                designation.setText(st);
                File phone_prifile = new File(root, fileName4);
                BufferedReader bufferedReader4 = new BufferedReader(new FileReader(phone_prifile));
                st = bufferedReader4.readLine();
                phone_pri.setText(st);
                File phone_secfile = new File(root, fileName5);
                BufferedReader bufferedReader5 = new BufferedReader(new FileReader(phone_secfile));
                st = bufferedReader5.readLine();
                phone_sec.setText(st);
                File emailfile = new File(root, fileName6);
                BufferedReader bufferedReader6 = new BufferedReader(new FileReader(emailfile));
                st = bufferedReader6.readLine();
                email.setText(st);
                File resi_addfile = new File(root, fileName7);
                BufferedReader bufferedReader7 = new BufferedReader(new FileReader(resi_addfile));
                st = bufferedReader7.readLine();
                resi_add.setText(st);
                File work_addfile = new File(root, fileName8);
                BufferedReader bufferedReader8 = new BufferedReader(new FileReader(work_addfile));
                st = bufferedReader8.readLine();
                work_add.setText(st);


            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        intent.putExtra("name", name.getText());
        intent.putExtra("company", company.getText());
        intent.putExtra("designation", designation.getText());
        intent.putExtra("phone_pri", phone_pri.getText());
        intent.putExtra("phone_sec", phone_sec.getText());
        intent.putExtra("email", email.getText());
        intent.putExtra("resi_add", resi_add.getText());
        intent.putExtra("work_add", work_add.getText());
        startActivityForResult(intent, REQUEST_CODE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //    switch (requestCode)
        //   {
        // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
        //     case REQUEST_CODE_1:
//                TextView name1 = (TextView)findViewById(R.id.textView);
        //       if(resultCode == RESULT_OK)
        //     {
//                   // String messageReturn = dataIntent.getStringExtra("message_return");
//                    if(data != null) {
//                    String SentName = data.getStringExtra("name");
//                    name1.setText(SentName);
//                }
        String fileName1 = "Name" + ".txt";
        String fileName2 = "Company" + ".txt";
        String fileName3 = "Designation" + ".txt";
        String fileName4 = "Phone_pri" + ".txt";
        String fileName5 = "Phone_sec" + ".txt";
        String fileName6 = "Email" + ".txt";
        String fileName7 = "Resi_add" + ".txt";
        String fileName8 = "Work_add" + ".txt";
//                    //textView.setText(messageReturn);
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
            String st = new String();
            File namefile = new File(root, fileName1);
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(namefile));
            st = bufferedReader1.readLine();
            name.setText(st);
            File companyfile = new File(root, fileName2);
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(companyfile));
            st = bufferedReader2.readLine();
            company.setText(st);
            File designationfile = new File(root, fileName3);
            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(designationfile));
            st = bufferedReader3.readLine();
            designation.setText(st);
            File phone_prifile = new File(root, fileName4);
            BufferedReader bufferedReader4 = new BufferedReader(new FileReader(phone_prifile));
            st = bufferedReader4.readLine();
            phone_pri.setText(st);
            File phone_secfile = new File(root, fileName5);
            BufferedReader bufferedReader5 = new BufferedReader(new FileReader(phone_secfile));
            st = bufferedReader5.readLine();
            phone_sec.setText(st);
            File emailfile = new File(root, fileName6);
            BufferedReader bufferedReader6 = new BufferedReader(new FileReader(emailfile));
            st = bufferedReader6.readLine();
            email.setText(st);
            File resi_addfile = new File(root, fileName7);
            BufferedReader bufferedReader7 = new BufferedReader(new FileReader(resi_addfile));
            st = bufferedReader7.readLine();
            resi_add.setText(st);
            File work_addfile = new File(root, fileName8);
            BufferedReader bufferedReader8 = new BufferedReader(new FileReader(work_addfile));
            st = bufferedReader8.readLine();
            work_add.setText(st);


            //}
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
       // }
  //  }
//}
