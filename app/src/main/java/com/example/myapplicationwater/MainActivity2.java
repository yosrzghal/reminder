package com.example.myapplicationwater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; // Import nécessaire pour gérer les intents
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Références aux éléments de l'interface utilisateur
        EditText saisiePoids = findViewById(R.id.saisiePoids);
        Button boutonCalculer = findViewById(R.id.boutonCalculer);
        TextView texteResultat = findViewById(R.id.texteResultat);
        Button boutonAjout = findViewById(R.id.boutonajouteau);

        // Gestion du clic sur le bouton "Calculer"
        boutonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération de l'entrée utilisateur
                String poidsTexte = saisiePoids.getText().toString().trim();

                if (!poidsTexte.isEmpty()) {
                    try {
                        // Convertir le poids en un nombre
                        double poids = Double.parseDouble(poidsTexte);

                        // Calcul de la quantité d'eau quotidienne
                        double quantiteEau = poids * 30;

                        // Afficher le résultat dans le TextView
                        texteResultat.setText(String.format("Quantité d'eau : %.1f ml", quantiteEau));

                    } catch (NumberFormatException e) {
                        // Gestion des entrées non valides
                        Toast.makeText(MainActivity2.this,
                                "Veuillez entrer un poids valide.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Alerter l'utilisateur si le champ est vide
                    Toast.makeText(MainActivity2.this,
                            "Veuillez entrer votre poids.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Gestion du clic sur le bouton "Ajouter de l'eau"
        boutonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passer à MainActivity3
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}
