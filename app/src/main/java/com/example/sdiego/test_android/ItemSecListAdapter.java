package com.example.sdiego.test_android;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SDiego on 23/02/2018.
 */

public class ItemSecListAdapter extends BaseAdapter{
    private Context seccontext;
    private List<ItemSec> secitemlist;

    public ItemSecListAdapter(Context seccontext, List<ItemSec> secitemlist){
        this.seccontext = seccontext;
        this.secitemlist = secitemlist;
    }

    @Override
    public int getCount() {
        return secitemlist.size();
    }

    @Override
    public Object getItem(int position) {
        return secitemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(seccontext,R.layout.itemsec_list,null);

        TextView name = (TextView)v.findViewById(R.id.Name);
        TextView depto = (TextView)v.findViewById(R.id.Depto);
        TextView height = (TextView)v.findViewById(R.id.Height);

        name.setText(secitemlist.get(position).getName());
        depto.setText(secitemlist.get(position).getDepto());
        height.setText(secitemlist.get(position).getHeight());

        v.setTag(secitemlist.get(position).getId());
        return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
