package com.example.sdiego.test_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecItem_List extends AppCompatActivity {

    private ListView lvItem;
    private ItemSecListAdapter adapter;
    private List<ItemSec> itemsecList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2_main);

        lvItem = (ListView) findViewById(R.id.listView_secitem);
        itemsecList = new ArrayList<>();


        Bundle sentobj = getIntent().getExtras();
        Item it = sentobj.getParcelable("Item");
        itemsecList = it.getVolcanes();

        adapter = new ItemSecListAdapter(getApplicationContext(), itemsecList);
        lvItem.setAdapter(adapter);

        TextView campoCountry = (TextView)findViewById(R.id.Country);
        campoCountry.setText(it.getCountry());


        if(it!=null) {
            lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(getApplicationContext(), "Clicked item id =" + view.getTag(), Toast.LENGTH_SHORT).show();

                    ItemSec itsec = (ItemSec) adapter.getItem(position);

                    Intent intent = new Intent(SecItem_List.this, Activity_Info.class);

                    intent.putExtra("ItemSec", itsec);
                    startActivity(intent);
                }
            });
        }

    }
}
