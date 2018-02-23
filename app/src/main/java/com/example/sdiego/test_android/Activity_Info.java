package com.example.sdiego.test_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Activity_Info extends AppCompatActivity {

    TextView campoName, campoDepto, campoHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__info);

        campoName = (TextView) findViewById(R.id.name);
        campoDepto = (TextView) findViewById(R.id.depto);
        campoHeight = (TextView) findViewById(R.id.height);

        Bundle sentobj = getIntent().getExtras();
        Item it = sentobj.getParcelable("Item");

        if(it!=null){
            //it = (Item)sentobj.getSerializable("Item");
            campoName.setText(it.getName());
            campoDepto.setText(it.getDepto());
            campoHeight.setText(it.getHeight());
        }
    }

}
