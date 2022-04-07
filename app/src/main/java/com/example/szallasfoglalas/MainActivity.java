package com.example.szallasfoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        searchButton.setOnClickListener(v -> { //lambda kifejezés

                String dest = destinationEditText.getText().toString();
                boolean business = businessCheckBox.isChecked();

                String businessStr = business ? "igen" : "nem";
                String message = "Cél: " + dest + ", Üzleti út: " + businessStr;

                //Egyszerű üzenet megjelenítése
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        );

        initAdultSpinner();
    }

    private void initAdultSpinner() {
        // lista megjelenítéséhez kell egy adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_adults,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adultSpinner.setAdapter(adapter);
    }
}