package com.example.szallasfoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText destinationEditText;
    private Button checkInButton;
    private Button checkOutButton;
    private Spinner adultSpinner;
    private Spinner roomSpinner;
    private CheckBox businessCheckBox;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Itt kell inicializálni
        destinationEditText = findViewById(R.id.destinationEditText);
        checkInButton = findViewById(R.id.checkInButton);
        checkOutButton = findViewById(R.id.checkOutButton);
        adultSpinner = findViewById(R.id.adultSpinner);
        roomSpinner = findViewById(R.id.roomSpinner);
        businessCheckBox = findViewById(R.id.businessCheckBox);
        searchButton = findViewById(R.id.searchButton);

        //Amikor rákattintanak erre a vezérlőre, akkor történjen ez:
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Egyszerű üzenet megjelenítése
                Toast.makeText(getApplicationContext(),"Keresés esemény", Toast.LENGTH_SHORT).show();
            }
        });
    }
}