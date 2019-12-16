package com.example.testtwo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends BaseAdapter implements View.OnClickListener {
    private Activity activity;
    private List<ListItem> data = new ArrayList<ListItem>();
    private static LayoutInflater inflater=null;
    public Resources res;
    ListItem item=null;
    int i=0;

    public MyListView(Activity a, List d){
        activity=a;
        data=d;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(data.size()<=0)
            return 1;
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void onClick(View view) {
        Log.v("CustomAdapter","Row button is clicked");
    }

    public static class ViewHolder{
        public TextView text;

}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi=view;
        ViewHolder  holder;
        if(view==null) {
            vi = inflater.inflate(R.layout.mylist, null);
            holder = new ViewHolder();
            holder.text = vi.findViewById(R.id.itemText);
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
        if(data.size()<=0){
            holder.text.setText("No Data");
        }
        else
        {
            item=null;
            item = (ListItem) data.get(i);

            holder.text.setText(item.getItemName());
            vi.setOnClickListener(new OnItemClickListener(i));
        }

        return vi;
    }
    private class OnItemClickListener implements View.OnClickListener{
        private int i;
        OnItemClickListener(int i){
            this.i=i;
        }
        public void onClick(View v){
            Main2Activity m = (Main2Activity) activity;
            m.onItemClick(i);
        }
    }
}
