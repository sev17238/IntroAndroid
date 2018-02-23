package com.example.sdiego.test_android;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;
import java.util.List;

/**
 * Created by SDiego on 21/02/2018.
 */

public class ItemListAdapter extends BaseAdapter {

    private Context acontext;
    private List<Item> aitemlist;

    public ItemListAdapter(Context acontext,List<Item> aitemlist){
        this.acontext = acontext;
        this.aitemlist = aitemlist;
    }

    @Override
    public int getCount() {
        return aitemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return aitemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(acontext,R.layout.item_list,null);


        TextView country = (TextView)v.findViewById(R.id.Country);
        TextView continent = (TextView)v.findViewById(R.id.Continent);

        country.setText(aitemlist.get(position).getCountry());
        continent.setText(aitemlist.get(position).getContinent());

        v.setTag(aitemlist.get(position).getId());
        return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
