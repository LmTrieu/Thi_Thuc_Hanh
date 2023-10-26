package edu.uef.thithuchanh;

import static edu.uef.thithuchanh.MainActivity.layoutIcon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomerList extends AppCompatActivity {
    private ArrayList item;
    public ListView lv;

    Button back;

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
            return foodicon.size();
        }
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return foodicon.get(position);
        }
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            // TODO Auto-generated method stub
            MainActivity.View_An_Item an_item;
            LayoutInflater layoutinflater= ((Activity)context).getLayoutInflater();
            if(arg1==null)
            {
                an_item = new MainActivity.View_An_Item();
                arg1 = layoutinflater.inflate(R.layout.list_item_icon, null);
                an_item.textview = (TextView) arg1.findViewById(R.id.textView1);
                an_item.imageview = (ImageView)arg1.findViewById(R.id.imageView1);
                arg1.setTag(an_item);
            }
            else
                an_item =(MainActivity.View_An_Item)arg1.getTag();
            an_item.imageview.setImageResource(foodicon.get(arg0));
            an_item.textview.setText(itemname.get(arg0));
            return arg1;
        }
    }
    public static ArrayList<Integer> foodicon = new ArrayList<>();

    public static ArrayList<String> itemname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        Intent intent = getIntent();
//        foodicon.add(String.valueOf(R.drawable.bread));
//        itemname.add("Bread");
        foodicon.add(layoutIcon[intent.getIntExtra("position",0)]);
        itemname.add(intent.getStringExtra("itemname"));
        lv = (ListView) findViewById(R.id.listViewMain);
        lv.setAdapter(new CustomerList.myadapter(this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String itemList = itemname.get(position);
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}
