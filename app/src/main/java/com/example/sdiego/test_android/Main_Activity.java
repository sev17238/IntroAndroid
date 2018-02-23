package com.example.sdiego.test_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDiego on 21/02/2018.
 */

public class Main_Activity extends AppCompatActivity{
    private ListView lvItem;
    private ItemListAdapter adapter;
    private List<Item> itemList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);


        lvItem = (ListView) findViewById(R.id.listview_item);
        itemList = new ArrayList<>();

        /*
        itemList.add(new Item(200, "Volcan de Pacaya","Escuintla","2552 MSNM"));
        itemList.add(new Item(100, "Volcan de Agua", "Escuintla","3760 MSNM"));
        itemList.add(new Item(100, "Volcan Santa Maria","Quetzaltenango", "3772 MSNM"));
        itemList.add(new Item(300, "Volcan de Acatenango", "Chimaltenango", "4010 MSNM"));
        itemList.add(new Item(300, "Volcan de Atitlan", "Solola","3535 MSNM"));
        itemList.add(new Item(300, "Volcan de Ipala", "Chiquimula","1650 MSNM"));
        itemList.add(new Item(300, "Volcan de Tajumulco", "San Marcos","4200 MSNM"));*/

        List<ItemSec> listG = new ArrayList<ItemSec>();
        listG.add(new ItemSec(10, "Volcan de Pacaya","Escuintla","2552 MSNM"));
        listG.add(new ItemSec(11, "Volcan de Agua", "Escuintla","3760 MSNM"));
        listG.add(new ItemSec(12, "Volcan Santa Maria","Quetzaltenango", "3772 MSNM"));
        listG.add(new ItemSec(13, "Volcan de Acatenango", "Chimaltenango", "4010 MSNM"));

        List<ItemSec> listI = new ArrayList<ItemSec>();
        listI.add(new ItemSec(10, "Monte Etna","Sicilia","3322 MSNM"));
        listI.add(new ItemSec(11, "Monte Vesubio", "Napoles","1281 MSNM"));
        listI.add(new ItemSec(12, "Monte Vulture","Potenza", "1326 MSNM"));

        List<ItemSec> listC = new ArrayList<ItemSec>();
        listC.add(new ItemSec(10, "Volcan Llaima","La Araucania","3125 MSNM"));
        listC.add(new ItemSec(11, "Volcan Villarrica", "Valdivia","2847 MSNM"));
        listC.add(new ItemSec(12, "Volcan Calbuco","Puerto Varas", "2003 MSNM"));


        itemList.add(new Item(1,"Guatemala","CentroAmerica",listG));
        itemList.add(new Item(2,"Italia","Europa",listI));
        itemList.add(new Item(2,"Chile","America del Sur",listC));


        adapter = new ItemListAdapter(getApplicationContext(), itemList);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Clicked item id =" + view.getTag(), Toast.LENGTH_SHORT).show();

                Item it = (Item)adapter.getItem(position);

                Intent intent = new Intent(Main_Activity.this,SecItem_List.class);
                /*Bundle bundle = new Bundle();
                bundle.putSerializable("Item",it);
                intent.putExtras(bundle);*/

                intent.putExtra("Item",it);
                startActivity(intent);
            }
        });
    }
}
