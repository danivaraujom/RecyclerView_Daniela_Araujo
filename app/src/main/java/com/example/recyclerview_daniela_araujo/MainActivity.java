package com.example.recyclerview_daniela_araujo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Instanciar el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Crear conjunto de datos
        ArrayList<Contacto> listaContactos = new ArrayList<>(Arrays.asList(new Contacto[]{
                new Contacto("Carlos", "Gonzalez", "gonzalezmalavasi@gmail.com", "555-1234", R.drawable.contacto_1),
                new Contacto("María", "Matos", "marigabymatos@gmail.com", "555-5678", R.drawable.contacto_2),
                new Contacto("Pablo", "Novoa", "pablonovoa@gmail.com", "555-9101", R.drawable.contacto_3),
                new Contacto("Lucía", "Lopez", "lucialopezr@hotmail.com", "555-1123", R.drawable.contacto_4),
                new Contacto("Monica", "Pousada", "monicapousada@gmail.com", "555-1415", R.drawable.contacto_5),
                new Contacto("Santiago", "Cortes", "santicortesd@gmail.com", "555-1617", R.drawable.contacto_6),
                new Contacto("Daniela", "Araujo", "danivaraujom@gmail.com", "555-1819", R.drawable.contacto_7),
                new Contacto("Martin", "Rodriguez", "martinrodri95@gmail.com", "555-2021", R.drawable.contacto_8),
                new Contacto("Juan", "Fernández", "juan_fernandez@hotmail.com", "555-2223", R.drawable.contacto_9),
                new Contacto("Elena", "Sánchez", "elenasrodriguez@hotmail.com", "555-2425", R.drawable.contacto_10)
        }));
        //Crear el adaptador
        ContactoAdapter contactoAdapter = new ContactoAdapter(this, listaContactos);
        recyclerView.setAdapter(contactoAdapter);
    }
}