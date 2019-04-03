package com.example.maheshgudumala.digitalcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class TextListAdapter extends BaseAdapter {
    Context context;
    public List<String> imgPic;
    public TextListAdapter(Context c, List<String> thePic) {
        context = c;
        imgPic = thePic;
    }

    @Override
    public int getCount() {
        if(imgPic != null)
            return imgPic.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.linearlayout_cards, null);
        }

        // 3
        //final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textView9);
        final TextView companyTextView = (TextView)convertView.findViewById(R.id.textView10);
        final TextView designationTextView = (TextView)convertView.findViewById(R.id.textView11);
        final TextView phone_priTextView = (TextView)convertView.findViewById(R.id.textView12);
        final TextView phone_secTextView = (TextView)convertView.findViewById(R.id.textView13);
        final TextView emailTextView = (TextView)convertView.findViewById(R.id.textView14);
        final TextView resi_addTextView = (TextView)convertView.findViewById(R.id.textView15);
        final TextView work_addTextView = (TextView)convertView.findViewById(R.id.textView16);
        try {
        String st;
        nameTextView.setText(imgPic.get(position));
        //BufferedReader bufferedReader1 = null;

//            BufferedReader bufferedReader = new BufferedReader(new FileReader(imgPic.get(position)));
//            st = bufferedReader.readLine();
            //bufferedReader
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(imgPic.get(position)));
                String line = reader.readLine();
                String[] strings = new String[8];
                Integer i = 0;
                while (line != null) {
                    //System.out.println(line);
                    // read next line
                    strings[i] = line;
                    i++;
                    line = reader.readLine();
                }
                reader.close();
            nameTextView.setText("Name: "+strings[0]);
            companyTextView.setText("Company: "+strings[1]);
            designationTextView.setText("Designation: "+strings[2]);
            phone_priTextView.setText("Phone(pri): "+strings[3]);
            phone_secTextView.setText("Phone(sec): "+strings[4]);
            emailTextView.setText("Email: "+strings[5]);
            resi_addTextView.setText("Resi-add: "+strings[6]);
            work_addTextView.setText("Work-add: "+strings[7]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner sc = new Scanner(imgPic.get(position));

            //name.setText(st);

        //} catch (FileNotFoundException e) {
          //  e.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
      //  }

//        companyTextView.setText(scannedCards[position].getCompany());
//        designationTextView.setText(scannedCards[position].getDesignation());
//        phone_priTextView.setText(scannedCards[position].getPhone_pri());
//        phone_secTextView.setText(scannedCards[position].getPhone_sec());
//        emailTextView.setText(scannedCards[position].getEmail());
//        resi_addTextView.setText(scannedCards[position].getResi_add());
//        work_addTextView.setText(scannedCards[position].getWork_add());
        return convertView;
        //return null;
    }
}
