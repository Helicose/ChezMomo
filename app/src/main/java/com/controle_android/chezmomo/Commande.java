package com.controle_android.chezmomo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Faly-Thomas on 13/03/2017.
 */

public class Commande extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("commandes", MODE_PRIVATE);

        setContentView(R.layout.commande);
        setTitle("Votre commande");
        Intent intent = getIntent();
        int prix = intent.getIntExtra("prix",0);
        String nom = intent.getStringExtra("nom");
        String texteAAfficher = "";
        Log.i("test", "test");
        TextView texte = (TextView)findViewById(R.id.textViewCommande);
        Set<String> listecommandes = sharedPreferences.getStringSet("commandes", new HashSet<String>());
        Set<String> listeprix = sharedPreferences.getStringSet("prix", new HashSet<String>());

        if(sharedPreferences.getStringSet("prix", null) != null){

            if(nom != null){
                listecommandes.add(nom);
                listeprix.add(Integer.toString(prix));
                //texteAAfficher += listecommandes.toString();

                sharedPreferences
                        .edit()
                        .putStringSet("commandes", listecommandes)
                        .putStringSet("prix", listeprix)
                        .apply();
            }

            int prixTotal = 0;

            for (int i=0; i<listecommandes.size();i++){
                texteAAfficher += listecommandes.toArray()[i] + " : " + listeprix.toArray()[i] +"€" +"\n";
                prixTotal += Integer.parseInt(listeprix.toArray()[i].toString());
            }

            texteAAfficher += "\n\n\n Total : " + prixTotal +"€";


            texte.setText(texteAAfficher);
        }
        else if (nom != null){
            sharedPreferences
                    .edit()
                    .putStringSet("commandes", listecommandes)
                    .putStringSet("prix", listeprix)
                    .apply();
        }


    }
}
