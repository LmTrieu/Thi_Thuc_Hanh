package edu.uef.thithuchanh;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String[] menu;

    public static class View_An_Item
    {
        public ImageView imageview;
        public TextView textview;


    }
    public class myadapter extends BaseAdapter
    {
        Context context;
        public myadapter(Context c)
        {
            context=c;
        }
        public int getCount() {
            // TODO Auto-generated method stub
            return layoutIcon.length;
        }
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return layoutIcon[position];
        }
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            // TODO Auto-generated method stub
            View_An_Item an_item;
            LayoutInflater layoutinflater= ((Activity)context).getLayoutInflater();
            if(arg1==null)
            {
                an_item = new View_An_Item();
                arg1 = layoutinflater.inflate(R.layout.list_item_icon, null);
                an_item.textview = (TextView) arg1.findViewById(R.id.textView1);
                an_item.imageview = (ImageView)arg1.findViewById(R.id.imageView1);
                arg1.setTag(an_item);
            }
            else
                an_item =(View_An_Item)arg1.getTag();
            an_item.imageview.setImageResource(layoutIcon[arg0]);
            an_item.textview.setText(menu[arg0]);
            return arg1;
        }
    }
    public ListView lv;

    static int[]layoutIcon={R.drawable.bread,R.drawable.cherrycheesecake,
            R.drawable.gingerbreadhouse,R.drawable.hamburger,R.drawable.sunnysideupeggs,
            R.drawable.sunnysideupeggs,R.drawable.hamburger,R.drawable.gingerbreadhouse,
            R.drawable.cherrycheesecake,R.drawable.bread};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lv = (ListView) findViewById(R.id.listViewMain);
        menu = getResources().getStringArray(R.array.layout_name_string);

        lv.setAdapter(new myadapter(this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,long l) {
                String itemList = menu[position];
                Toast.makeText(MainActivity.this, "Clicked "+ itemList+" at Position: "+(position+1),
                        Toast.LENGTH_SHORT).show();
                //Launch intent
                switchActivities(itemList, position);

            }
            private void switchActivities(String itemname, int pos) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), CustomerList.class);
                switchActivityIntent.putExtra("itemname", itemname);
                switchActivityIntent.putExtra("position", pos );
                overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                startActivity(switchActivityIntent);
            }
        });
    }

}