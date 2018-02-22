package com.example.sdiego.test_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity_Info extends AppCompatActivity {

    TextView campoName, campoDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__info);

        campoName = (TextView) findViewById(R.id.name);
        campoDescription = (TextView) findViewById(R.id.description);

        Bundle sentobj = getIntent().getExtras();
        Item it = null;

        if(sentobj!=null){
            it = (Item)sentobj.getSerializable("Item");
            campoName.setText(it.getName());
            campoDescription.setText(it.getDescription());
        }
    }

}
