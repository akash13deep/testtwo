package com.example.testtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText ed3;
Spinner spin;
ListView list;
ImageView img;
    MyListView adapter;
    Main2Activity customView = null;
    List<ListItem>poi = new ArrayList<ListItem>();
int i;
    String[] capital = {"Ottawa", "Washington", "London"};
    int[] images={R.drawable.canada,R.drawable.usa,R.drawable.england};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        customView = this;
        setData();
        List<String> countries = new ArrayList<String>();
        countries.add("Canada");
        countries.add("USA");
        countries.add("England");
        ed3 = findViewById(R.id.capview);
        spin = findViewById(R.id.spinner);
        list = findViewById(R.id.listvieww);
        adapter=new MyListView(customView,poi);
        list.setAdapter(adapter);
        img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.canada);

//create an adapter and fill it from the list
        ArrayAdapter<String> country = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries);
        //make the drop down style
        country.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        spin.setAdapter(country);
        spin.setOnItemSelectedListener(this);

    }

    private void setData() {

            ListItem item = new ListItem("Niagara falls");
            poi.add(item);
            item = new ListItem("CN Tower");
            poi.add(item);
            item = new ListItem("The Butchart Gardens");
            poi.add(item);
            item = new ListItem("Notre-Dame Basilica");
            poi.add(item);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {

        i = position;
        String cp = new String(capital[i]);
        ed3.setText(cp);
        int imgg = images[i];
        img.setBackgroundResource(imgg);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void onItemClick(int i)
    {
        ListItem tempVlue = (ListItem)poi.get(i);
    }
}
