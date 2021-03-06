  package com.example.chlopes.tp2_oo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.chlopes.tp2_oo.R;
import com.example.chlopes.tp2_oo.adapter.Adapter;
import com.example.chlopes.tp2_oo.model.MorseAlpha;

import java.util.ArrayList;
import java.util.List;

  public class MainActivity extends AppCompatActivity implements TraducteurMorse {

    private RecyclerView recyclerView;
    private List<MorseAlpha> listMorseAlpha = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //config adapter
        Adapter adapter = new Adapter(listMorseAlpha);

        //config RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }

    public void addTi(View view){

          EditText ti = findViewById(R.id.morse);
          ti.append(".");

      }

      public void addTaah(View view){

          EditText taah = findViewById(R.id.morse);
          taah.append("-");

      }

      public void addEspace(View view){

          EditText espace = findViewById(R.id.morse);
          espace.append(" ");

      }

      public void addSlash(View view){

          EditText slash = findViewById(R.id.morse);
          slash.append("/");

      }

      public void effacerCharactere(View view){

          EditText effacerMorse = findViewById(R.id.morse);
          effacerMorse.setText("");
          EditText effaceralpha = findViewById(R.id.alpha);
          effaceralpha.setText("");

      }

      public void jouer(View view){

          EditText champMorse = findViewById(R.id.morse);
          EditText champAlpha = findViewById(R.id.alpha);
          String getMorse = champMorse.getText().toString();
          String getAlpha = champAlpha.getText().toString();

          if(getMorse.equals("")) {

              champMorse.setText(toMorse(getAlpha));
              getMorse = champMorse.getText().toString();
          }else{
              champAlpha.setText(toAlpha(getMorse));
              getAlpha = champAlpha.getText().toString();
          }
          //ajouterList(getAlpha, getMorse);

      }

      public void ajouterList(String alpha, String morse){

          if(!(morse.equals("") && alpha.equals(""))) {
              MorseAlpha addList = new MorseAlpha(toAlpha(morse), toMorse(alpha));
              listMorseAlpha.add(addList);

          }

      }



      @Override
      public String toAlpha(String morse) {

          String mot = "";
          String phrase = "";
          String caractere = "";
          String change = "/ ";

          Morse convert = new Morse();

          int i = 0;
          while (i < morse.length()) {
              while (morse.charAt(i) != change.charAt(0)) {
                  while (morse.charAt(i) != change.charAt(1) && morse.charAt(i) != change.charAt(0)) {
                      if (caractere == "") {
                          caractere = "" +  morse.charAt(i);
                      }else {
                          caractere = caractere +  morse.charAt(i);
                      }
                      if (i == morse.length() - 1) {
                          break;
                      }
                      i++;

                  }
                  if (morse.charAt(i) == change.charAt(1)) {
                      i++;
                  }

                  mot += convert.convertCaractere(caractere, "morse");

                  caractere = "";
                  if (i == morse.length() - 1) {
                      break;
                  }
              }

              phrase += mot;

              if(i != morse.length() -1) {
                  phrase = phrase + " ";
              }
              mot = "";
              i++;
          }
          return phrase;
      }

      @Override
      public String toMorse(String alpha) {
          String alphaValide = "";
          String phrase = "";
          String change = "/ ";

          alphaValide = nettoyerAlpha(alpha);
          Morse convert = new Morse();

          int i = 0;
          while (i < alphaValide.length()) {
              phrase += convert.convertCaractere("" + alphaValide.charAt(i), "alpha");
              if (i != alphaValide.length() - 1) {
                  if (alphaValide.charAt(i) != change.charAt(1) && alphaValide.charAt(i+1) != change.charAt(1)) {
                      phrase+= " ";
                  }
              }
              i++;
          }
          return phrase;
      }

      @Override
      public String nettoyerAlpha(String alpha) {

          String alphaFinal = "";
          String minuscule = "";
          String accent = "";
          Morse veriifie = new Morse();

          for (int i = 0; i< alpha.length();i++) {
              if(veriifie.alphaMajuscule(alpha.charAt(i))){
                  alphaFinal += alpha.charAt(i);
              }else {
                  minuscule = veriifie.alphaMinuscule("" + alpha.charAt(i));
                  if(minuscule != "vide"){
                      alphaFinal += minuscule;
                  } else {
                      accent = veriifie.alphaAccent("" + alpha.charAt(i));
                      if(accent != "vide"){
                          alphaFinal += accent;
                      }
                  }
              }
          }
          return alphaFinal;
      }

      @Override
      public String getNomProgrammeurs() {

            return null;
      }
  }
