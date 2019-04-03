package com.example.maheshgudumala.digitalcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    private GridView grid;
    private Uri picUri;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private List<String> listOfImagesPath;
    public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DigitalCard/Cards";
    //File root = new File(Environment.getExternalStorageDirectory()+File.separator+"DigitalCard", "Cards");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        grid = findViewById(R.id.grid_view);
        listOfImagesPath = null;
        listOfImagesPath = RetriveCapturedImagePath();
        if(listOfImagesPath!=null){
            grid.setAdapter(new TextListAdapter(this,listOfImagesPath));
        }
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
//                //ImageView imageView = new ImageView((Context) parent.getItemAtPosition(position));
//                Intent intent = new Intent(Main2Activity.this, FullScreenActivity.class);
//                //intent.putExtra("image", (CharSequence) imageView); // ERROR IS ON ITEM.GETIMAGE
//                Bitmap bitmap;
//                bitmap = item.getImage();
//
//                intent.putExtra("image", bitmap);
//                //Start details activity
//                startActivity(intent);



                //Intent i = new Intent(getApplicationContext(), FullScreenActivity.class);
//                String imageUrl = (String) parent.getItemAtPosition(position);
//                //i.putExtra("id", position);
//
//                i.putExtra("IMAGE_URL", imageUrl);
//                startActivity(i);
//            }
//        });
    }
    private List<String> RetriveCapturedImagePath() {
        List<String> tFileList = new ArrayList<String>();
        File f = new File(GridViewDemo_ImagePath);
        if (f.exists()) {
            File[] files=f.listFiles();
            Arrays.sort(files);

            for(int i=0; i<files.length; i++){
                File file = files[i];
                if(file.isDirectory())
                    continue;
                tFileList.add(file.getPath());
            }
        }
        return tFileList;
    }
}

