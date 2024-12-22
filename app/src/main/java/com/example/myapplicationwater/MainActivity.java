package com.example.myapplicationwater;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Référencer le bouton "Commencer"
        Button boutonCommencer = findViewById(R.id.boutonCommencer);
        // Assurez-vous de charger le bon fichier XML pour MainActivity1

        // Gestion du clic sur le bouton
        boutonCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passer à MainActivity1 (au lieu de MainActivity2)
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}

