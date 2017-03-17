package com.controle_android.chezmomo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        if(listecommandes.size() >= 0){

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

            if(listecommandes.size() == 0){
                texte.setText("Votre commande est vide.");
            }
        }

        else if (nom != null){
            sharedPreferences
                    .edit()
                    .putStringSet("commandes", listecommandes)
                    .putStringSet("prix", listeprix)
                    .apply();
        }

        else{
            texte.setText("Votre commande est vide.");
        }


    }

    public void actionValider(View vue){
        Toast.makeText(getApplicationContext(), "Merci pour votre commande, elle arrive au plus vite !", Toast.LENGTH_SHORT).show();
        Intent acceuil = new Intent(Commande.this, MainActivity.class); // on declare la nouvelle activite
        startActivity (acceuil); //on demarre l'activite

    }

    public void actionAnnuler(View vue){
        sharedPreferences
                .edit()
                .putStringSet("commandes", null)
                .putStringSet("prix", null)
                .apply();

        Toast.makeText(getApplicationContext(), "Commande annulée.", Toast.LENGTH_SHORT).show();

        Intent acceuil = new Intent(Commande.this, MainActivity.class); // on declare la nouvelle activite
        startActivity (acceuil); //on demarre l'activite
    }

    public void actionContinuer(View vue){
        onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Intent menu = new Intent(Commande.this, MainActivity.class); // on declare la nouvelle activite
                startActivity (menu); //on demarre l'activite
                return true;
            case R.id.formules:
                Intent formules = new Intent(Commande.this, Formules.class); // on declare la nouvelle activite
                startActivity (formules); //on demarre l'activite
                return true;
            case R.id.vins:
                Intent vins = new Intent(Commande.this, Vins.class); // on declare la nouvelle activite
                startActivity (vins); //on demarre l'activite
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
