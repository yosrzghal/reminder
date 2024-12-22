package com.example.myapplicationwater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private double objectifEau = 2000; // Objectif d'eau en ml (par défaut : 2000 ml)
    private double quantiteConsommee = 0; // Quantité d'eau déjà consommée


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // Références aux éléments de l'interface utilisateur
        EditText saisieQuantite = findViewById(R.id.saisieQuantite);
        Button boutonAjouter = findViewById(R.id.boutonAjouter);
        TextView texteRestant = findViewById(R.id.texteRestant);

        // Mise à jour initiale de la quantité restante
        texteRestant.setText("Quantité restante : " + objectifEau + " ml");

        // Gestion du clic sur le bouton Ajouter
        boutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération de la quantité entrée par l'utilisateur
                String quantiteTexte = saisieQuantite.getText().toString();

                if (!quantiteTexte.isEmpty()) {
                    try {
                        // Conversion en nombre
                        double quantite = Double.parseDouble(quantiteTexte);

                        // Mise à jour de la quantité consommée et restante
                        quantiteConsommee += quantite;
                        double quantiteRestante = objectifEau - quantiteConsommee;

                        // Empêcher un résultat négatif
                        if (quantiteRestante < 0) {
                            quantiteRestante = 0;
                        }

                        // Mettre à jour l'affichage
                        texteRestant.setText("Quantité restante : " + quantiteRestante + " ml");

                        // Réinitialiser le champ de saisie
                        saisieQuantite.setText("");

                        // Informer l'utilisateur si l'objectif est atteint
                        if (quantiteRestante == 0) {
                            Toast.makeText(MainActivity3.this,
                                    "Félicitations ! Vous avez atteint votre objectif d'eau.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity3.this,
                                "Veuillez entrer une quantité valide.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity3.this,
                            "Veuillez entrer une quantité.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

