package com.example.szallasfoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText destinationEditText;
    private Button checkInButton;
    private Button checkOutButton;
    private Spinner adultSpinner;
    private Spinner roomSpinner;
    private CheckBox businessCheckBox;
    private Button searchButton;

    private boolean isCheckInDateSelected = true;

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

        initSpinner(R.array.number_of_adults,adultSpinner);
        initSpinner(R.array.number_of_rooms, roomSpinner);

        checkInButton.setOnClickListener(v -> {
            isCheckInDateSelected = true;
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.show(getSupportFragmentManager(),"checkInDate");
        });

        checkOutButton.setOnClickListener(v -> {
            isCheckInDateSelected = false;
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.show(getSupportFragmentManager(),"checkOutDate");
        });
    }

    private void initSpinner(int resId, Spinner spinner) {
        // lista megjelenítéséhez kell egy adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                resId,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = year + "-" + (month+1) + "-" + day;

        if(isCheckInDateSelected){
            checkInButton.setText(date);
        } else {
            checkOutButton.setText((date));
        }

    }
}