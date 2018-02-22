package com.example.sdiego.test_android;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    public Item getItemById(int id){
        Item it = new Item();
        for (int i = 0; i <aitemlist.size() ; i++) {
            it = aitemlist.get(i);
            if (id == it.getId()) {
                return it;
            }
        }
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(acontext,R.layout.item_list,null);
        TextView name = (TextView)v.findViewById(R.id.Name);
        TextView des = (TextView)v.findViewById(R.id.Decription);

        name.setText(aitemlist.get(position).getName());
        des.setText(aitemlist.get(position).getDescription());

        v.setTag(aitemlist.get(position).getId());
        return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
