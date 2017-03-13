package com.controle_android.chezmomo;

import android.content.Intent;
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
                Intent MenuMidi = new Intent(MainActivity.this, CarteMidi.class); // on declare la nouvelle activite
                startActivity (MenuMidi); //on demarre l'activite
                break;
            case R.id.cartepetiots:
                Intent MenuPetiots = new Intent(MainActivity.this, CartePetiots.class); // on declare la nouvelle activite
                startActivity (MenuPetiots); //on demarre l'activite
                break;
        }

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
