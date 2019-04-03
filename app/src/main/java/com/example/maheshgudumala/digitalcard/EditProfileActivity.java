package com.example.maheshgudumala.digitalcard;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditProfileActivity extends AppCompatActivity {
    private Button save;
    private EditText name;
    private EditText company;
    private EditText designation;
    private EditText phone_pri;
    private EditText phone_sec;
    private EditText email;
    private EditText resi_add;
    private EditText work_add;
    //ProfileActivity profileActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Bundle extras = getIntent().getExtras();
        name = findViewById(R.id.editText);
        company = findViewById(R.id.editText2);
        designation = findViewById(R.id.editText3);
        phone_pri = findViewById(R.id.editText4);
        phone_sec = findViewById(R.id.editText5);
        email = findViewById(R.id.editText6);
        resi_add = findViewById(R.id.editText7);
        work_add = findViewById(R.id.editText8);
        save = findViewById(R.id.button5);
        String SentName = extras.getString("name");
        String SentCompany = extras.getString("company");
        String SentDesignation = extras.getString("designation");
        String SentPhone_pri = extras.getString("phone_pri");
        String SentPhone_sec = extras.getString("phone_sec");
        String SentEmail = extras.getString("email");
        String SentResi_add = extras.getString("resi_add");
        String SentWork_add = extras.getString("work_add");
        name.setText(SentName);
        company.setText(SentCompany);
        designation.setText(SentDesignation);
        phone_pri.setText(SentPhone_pri);
        phone_sec.setText(SentPhone_sec);
        email.setText(SentEmail);
        resi_add.setText(SentResi_add);
        work_add.setText(SentWork_add);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ProfileActivity.name.setText("Mahesh");
                //Intent intent = new Intent();
                Intent intent = new Intent();

                String fileName1 = "Name"+".txt";
                String fileName2 = "Company"+".txt";
                String fileName3 = "Designation"+".txt";
                String fileName4 = "Phone_pri"+".txt";
                String fileName5 = "Phone_sec"+".txt";
                String fileName6 = "Email"+".txt";
                String fileName7 = "Resi_add"+".txt";
                String fileName8 = "Work_add"+".txt";
                try
                {
                    File root = new File(Environment.getExternalStorageDirectory()+File.separator+"DigitalCard", "Values");
                    //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    if (!root.exists())
                    {
                        root.mkdirs();
                    }


                    File namefile = new File(root, fileName1);
                    FileWriter writer1 = new FileWriter(namefile, false);
                    writer1.append(name.getText());
                    writer1.flush();
                    writer1.close();

                    File companyfile = new File(root, fileName2);
                    FileWriter writer2 = new FileWriter(companyfile, false);
                    writer2.append(company.getText());
                    writer2.flush();
                    writer2.close();

                    File designationfile = new File(root, fileName3);
                    FileWriter writer3 = new FileWriter(designationfile, false);
                    writer3.append(designation.getText());
                    writer3.flush();
                    writer3.close();

                    File phone_prifile = new File(root, fileName4);
                    FileWriter writer4 = new FileWriter(phone_prifile, false);
                    writer4.append(phone_pri.getText());
                    writer4.flush();
                    writer4.close();

                    File phone_secfile = new File(root, fileName5);
                    FileWriter writer5 = new FileWriter(phone_secfile, false);
                    writer5.append(phone_sec.getText());
                    writer5.flush();
                    writer5.close();


                    File emailfile = new File(root, fileName6);
                    FileWriter writer6 = new FileWriter(emailfile, false);
                    writer6.append(email.getText());
                    writer6.flush();
                    writer6.close();


                    File resi_addfile = new File(root, fileName7);
                    FileWriter writer7 = new FileWriter(resi_addfile, false);
                    writer7.append(resi_add.getText());
                    writer7.flush();
                    writer7.close();


                    File work_addfile = new File(root, fileName8);
                    FileWriter writer8 = new FileWriter(work_addfile, false);
                    writer8.append(work_add.getText());
                    writer8.flush();
                    writer8.close();



                    setResult(RESULT_OK);
                    finish();
                    //seeChange();
//                    FileReader reader = new FileReader(gpxfile);
//                    textView.setText(reader.read());
//                    //Toast.makeText(this, "Data has been written to Report File", Toast.LENGTH_SHORT).show();
                }
                catch(IOException e)
                {
                    e.printStackTrace();

                }




                finish();
            }
        });

    }


}
