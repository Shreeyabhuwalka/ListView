package com.developer.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String mText[] = {"Facebook","Whatsapp","Twitter"};
    String dec[]={"facebook des1","whatsapp des","twitter des"};
    int image[]={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this,mText,dec,image);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    Toast.makeText(MainActivity.this,"Facebook clicked!",Toast.LENGTH_SHORT).show();
                if(i==1)
                    Toast.makeText(MainActivity.this,"Whatsapp clicked",Toast.LENGTH_SHORT).show();
                if(i==2)
                    Toast.makeText(MainActivity.this,"Twitter clicked!",Toast.LENGTH_SHORT).show();

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context mContext;
        String rTitle[];
        String rDes[];
        int rImag[];


        MyAdapter(Context c,String title[],String des[], int img[])
        {
            super(c,R.layout.row,R.id.name,title);
            this.mContext = c;
            this.rTitle = title;
            this.rDes = des;
            this.rImag = img;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.name);
            TextView myDes = row.findViewById(R.id.description);


            images.setImageResource(rImag[position]);
            myTitle.setText(rTitle[position]);
            myDes.setText(rDes[position]);

            return row;

        }
    }
}