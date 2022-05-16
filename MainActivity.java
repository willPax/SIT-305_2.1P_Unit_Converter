package com.example.unitconverter1p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageButton tempButton, distanceButton, weightButton;
    Spinner mainSpinner;
    EditText userData;
    TextView resultText1, resultText2, resultText3;
    TextView resultData1, resultData2, resultData3;
    String spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempButton = findViewById(R.id.tempButton);
        distanceButton = findViewById(R.id.distanceButton);
        weightButton = findViewById(R.id.weightButton);
        mainSpinner = findViewById(R.id.mainSpinner);
        userData = findViewById(R.id.editTextNumberDecimal);
        resultText1 = findViewById(R.id.resultText1);
        resultText2 = findViewById(R.id.resultText2);
        resultText3 = findViewById(R.id.resultText3);
        resultData1 = findViewById(R.id.resultData1);
        resultData2 = findViewById(R.id.resultData2);
        resultData3 = findViewById(R.id.resultdata3);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unitSpinnerValues, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mainSpinner.setAdapter(adapter);
        // Set the listener for when the item is clicked
        mainSpinner.setOnItemSelectedListener(this);
        // Get the user selected spinner value
        spinnerValue = mainSpinner.getSelectedItem().toString();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Get the selected item with parent.getItemAtPosition(pos)
        String selectedSpinnerValue = parent.getItemAtPosition(pos).toString();
        //Set the spinner value
        spinnerValue = selectedSpinnerValue;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Nothing selected
    }

    public void distanceClick(View view) {
        // Get and check if the distance spinner was selected
        int selectedItemPosition = mainSpinner.getSelectedItemPosition();
        if (selectedItemPosition != 0){
            incorrectSpinnerToast();
            return;
        }
        double userInput = Double.parseDouble(userData.getText().toString());
        double userFeet = userInput * 3.28084;
        double userInch = userInput * 1039.36 ;
        double userCm = userInput * 1000;

        String userFeetStr = String.format("%.2f", userFeet);
        String userInchStr = String.format("%.2f", userInch);
        String userCmStr = String.format("%.2f", userCm);

        resultData1.setText(userFeetStr);
        resultData2.setText(userInchStr);
        resultData3.setText(userCmStr);

        resultText3.setText("Centimeter");
        resultText2.setText("Foot");
        resultText1.setText("Inch");

    }

    public void weightClick(View view) {
        //Toast.makeText(this, "Weight Button Clicked", Toast.LENGTH_SHORT).show();
        int selectedItemPosition = mainSpinner.getSelectedItemPosition();
        if (selectedItemPosition != 1){
            incorrectSpinnerToast();
            return;
        }
        double userInput = Double.parseDouble(userData.getText().toString());
        double userPounds  = userInput * 2.20462262185;
        double userOunce = userInput * 35.274;
        double userGram = userInput * 100;

        String userPoundsStr = String.format("%.2f", userPounds);
        String userOunceStr = String.format("%.2f", userOunce);
        String userGramStr = String.format("%.2f", userGram);

        resultData1.setText(userPoundsStr);
        resultData2.setText(userOunceStr);
        resultData3.setText(userGramStr);

        resultText1.setText("Pounds");
        resultText2.setText("Ounces");
        resultText3.setText("Grams");
    }

    public void tempClick(View view) {
        //Toast.makeText(this, "Temp Button Clicked", Toast.LENGTH_SHORT).show();
        int selectedItemPosition = mainSpinner.getSelectedItemPosition();

        if (selectedItemPosition != 2){
            incorrectSpinnerToast();
            return;
        }
        double userInput = Double.parseDouble(userData.getText().toString());
        double userFahrenheit = userInput * 1.8 + 32;
        double userKelvin = userInput +  273.15 ;

        String userFahrenheitStr = String.format("%.2f", userFahrenheit);
        String userKelvinStr = String.format("%.2f", userKelvin);

        resultData1.setText(userFahrenheitStr);
        resultData2.setText(userKelvinStr);
        resultData3.setText("");

        resultText1.setText("Fahrenheit");
        resultText2.setText("Kelvin");
        resultText3.setText("");
    }

    private void incorrectSpinnerToast() {
        //Set texts blank and send error toast message
        Toast.makeText(this, "Pick the correct unit of conversion..", Toast.LENGTH_SHORT).show();
        resultData1.setText("");
        resultData2.setText("");
        resultData3.setText("");
        resultText1.setText("");
        resultText2.setText("");
        resultText3.setText("");
    }
}