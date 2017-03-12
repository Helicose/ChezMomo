package com.controle_android.chezmomo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formules);
        setTitle("Nos formules");

        ListView liste;

        String[] data = new String[]{
                "Menu Midi", "Menu Gourmand", "Menu Bistrot", "Menu des Petiots"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );

        //liste = (ListView)findViewById(R.id.listView);
        //liste.setAdapter(adapter);
    }

    public void redirectionFormule(View vue){
        switch (vue.getId()) {
            case R.id.cartegourmand:
                //doSomething1();
                break;
            case R.id.cartebistrot:
                //doSomething2();
                break;
            case R.id.cartemidi:
                setContentView(R.layout.menumidi);
                setTitle("Choix du Menu Midi");
                break;
            case R.id.cartepetiots:
                //doSomething1();
                break;
        }

    }
}
