package com.example.coach.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }

    // propriété de classe
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmile;
    private Controle controle;

    /**
     * Initialisation des propriétés
     */
    private void init(){
        txtPoids = findViewById(R.id.editTextNumber);
        txtTaille = findViewById(R.id.twtTaille);
        txtAge = findViewById(R.id.txtAge);
        rdHomme = findViewById(R.id.rdHomme);
        lblIMG = findViewById(R.id.lblIMG);
        imgSmile = findViewById(R.id.imgSmile);
        ecoutecalcul();
    }

    /**
     * Ecoute le bouton de calcul
     */
    private void ecoutecalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
//                Log.d("message","click ok sur le button calcul **************");
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;

                try{
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e){}

                if(rdHomme.isChecked()){
                    sexe = 0;
                }else{
                    sexe = 1;
                }
                if(poids == 0 || taille == 0 || age == 0){
                    Toast.makeText(MainActivity.this, "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    afficherResultat(poids, taille, age, sexe);
                }
            }
        });
    }

    /**
     * Affiche le résultat
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficherResultat(Integer poids, Integer taille, Integer age, Integer sexe){
        this.controle.creerProfil(poids,taille,age,sexe);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();
        if(message.equals("Vous êtes en normal")){
            imgSmile.setImageResource(R.drawable.normal2);
            lblIMG.setTextColor(Color.GREEN);
        }else{
            lblIMG.setTextColor(Color.RED);
            if(message.equals("Vous êtes trop faible")){
                imgSmile.setImageResource(R.drawable.angry);
            }else {
                imgSmile.setImageResource(R.drawable.cool);
            }
        }

        lblIMG.setText(String.format("%.1f",img)+": IMG "+message);
    }
}