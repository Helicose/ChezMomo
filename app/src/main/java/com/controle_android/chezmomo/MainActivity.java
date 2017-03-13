package com.controle_android.chezmomo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Chez Momo");

        final ListView liste;

        String[] data = new String[]{
                "Nos Formules","A la carte", "Tous nos vins"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );

        liste = (ListView)findViewById(R.id.list);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent formules = new Intent(MainActivity.this, Formules.class); // on declare la nouvelle activite
                    startActivity (formules); //on demarre l'activite
                }else{
                    if(position==1){
                        Intent carte = new Intent(MainActivity.this, Carte.class); // on declare la nouvelle activite
                        startActivity (carte); //on demarre l'activite
                    }
                    else if(position==2){
                        Intent vins = new Intent(MainActivity.this, Vins.class); // on declare la nouvelle activite
                        startActivity (vins); //on demarre l'activite
                    }
                }

            }
        });
    }
}

/*
private View.OnClickListener lienInventaire = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inventaire = new Intent (MainActivity.this, Inventaire.class); // on declare la nouvelle activite reliee au bouton
            startActivity (inventaire); //on demarre l'activite
        }

    };

 */
