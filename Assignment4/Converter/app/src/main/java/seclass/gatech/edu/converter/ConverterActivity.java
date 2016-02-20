package seclass.gatech.edu.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConverterActivity extends AppCompatActivity {

    //declare properties
    private Spinner ddFromValue;
    private Spinner ddToValue;
    private EditText distValue;
    private EditText distResult;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        //set values from android widgets in layout
        ddFromValue = (Spinner)findViewById(R.id.ddFromText);
        ddToValue = (Spinner)findViewById(R.id.ddToText);
        distValue = (EditText)findViewById(R.id.distValue);
        distResult = (EditText)findViewById(R.id.distResult);
        txtResult = (TextView)findViewById(R.id.txtResult);

        //make result input not editable
        distResult.setKeyListener(null);

        //set items for dropdown fields
        String[] dropDownItems = new String[] {"Miles", "Feet", "Inches", "Kilometers", "Meters", "Centimeters"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dropDownItems);
        ddFromValue.setAdapter(adapter);
        ddToValue.setAdapter(adapter);

        //set default values for spinners
        ddFromValue.setSelection(0);
        ddToValue.setSelection(3);

        ddFromValue.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        distValue.setText("");
                        distResult.setText("");
                        distResult.setVisibility(View.GONE);
                        txtResult.setVisibility((View.GONE));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        //nothing happens
                    }
                });
        ddToValue.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        distValue.setText("");
                        distResult.setText("");
                        distResult.setVisibility(View.GONE);
                        txtResult.setVisibility((View.GONE));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        //nothing happens
                    }
                });
    }

    //handle click event for convert button
    public void handleClick (View view) {

        switch (view.getId()) {
            case R.id.btnConvert:
                String value = distValue.getText().toString();
                if (value.length() > 0) {
                    //Get the values from the dropdowns
                    String unitFrom = ddFromValue.getSelectedItem().toString();
                    String unitTo = ddToValue.getSelectedItem().toString();

                    if (unitFrom.contentEquals(unitTo)) {
                        distResult.setText(value);
                        distResult.setVisibility(View.VISIBLE);
                    }
                    else {
                        switch (unitFrom) {
                            case "Miles":
                                if (unitTo == "Feet") {
                                    distResult.setText(convertMilesToFeet(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Inches") {
                                    distResult.setText(convertMilesToInches(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Kilometers") {
                                    distResult.setText(convertMilesToKilometers(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Meters") {
                                    distResult.setText(convertMilesToMeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else {
                                    distResult.setText(convertMilesToCentimeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                            case "Feet":
                                if (unitTo == "Miles") {
                                    distResult.setText(convertFeetToMiles(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Inches") {
                                    distResult.setText(convertFeetToInches(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Kilometers") {
                                    distResult.setText(convertFeetToKm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Meters") {
                                    distResult.setText(convertFeetToMeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else {
                                    distResult.setText(convertFeetToCm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                            case "Inches":
                                if (unitTo == "Miles") {
                                    distResult.setText(convertInchesToMiles(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Feet") {
                                    distResult.setText(convertInchesToFeet(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Kilometers") {
                                    distResult.setText(convertInchesToKm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Meters") {
                                    distResult.setText(convertInchesToMeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else {
                                    distResult.setText(convertInchesToCm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                            case "Kilometers":
                                if (unitTo == "Miles") {
                                    distResult.setText(convertKmToMiles(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Inches") {
                                    distResult.setText(convertKmToInches(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Feet") {
                                    distResult.setText(convertKmToFeet(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Meters") {
                                    distResult.setText(convertKmToMeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else {
                                    distResult.setText(convertKmToCm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                            case "Meters":
                                if (unitTo == "Miles") {
                                    distResult.setText(convertMetersToMiles(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Inches") {
                                    distResult.setText(convertMetersToInches(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Kilometers") {
                                    distResult.setText(convertMetersToKm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Feet") {
                                    distResult.setText(convertMetersToFeet(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else {
                                    distResult.setText(convertMetersToCm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                            case "Centimeters":
                                if (unitTo == "Miles") {
                                    distResult.setText(convertCentimetersToMiles(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Inches") {
                                    distResult.setText(convertCentimetersToInches(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Kilometers") {
                                    distResult.setText(convertCentimetersToKm(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else if (unitTo == "Meters") {
                                    distResult.setText(convertCentimetersToMeters(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                else { //feet
                                    distResult.setText(convertCentimetersToFeet(value));
                                    distResult.setVisibility(View.VISIBLE);
                                    txtResult.setVisibility((View.VISIBLE));
                                }
                                break;
                        }
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Empty value!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;
            case R.id.btnClear:
                distValue.setText("");
                distResult.setText("");
                distResult.setVisibility(View.GONE);
                txtResult.setVisibility((View.GONE));
                ddFromValue.setSelection(0);
                ddToValue.setSelection(3);
                break;
        }
    }

    //Convert miles to kilometers
    public String convertMilesToKilometers(String strMiles) {
        double miles = Double.parseDouble(strMiles);
        double km = miles * 1.60934;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //Convert miles to feet
    public String convertMilesToFeet(String strMiles) {
        double miles = Double.parseDouble(strMiles);
        double feet = miles * 5280;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(feet));
    }

    //Convert miles to inches
    public String convertMilesToInches(String strMiles) {
        double miles = Double.parseDouble(strMiles);
        double inches = miles * 63360;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inches));
    }

    //Convert miles to meters
    public String convertMilesToMeters(String strMiles) {
        double miles = Double.parseDouble(strMiles);
        double meters = miles * 1609.34;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meters));
    }

    //Convert miles to centimeters
    public String convertMilesToCentimeters(String strMiles) {
        double miles = Double.parseDouble(strMiles);
        double centimeters = miles * 160934;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(centimeters));
    }

    //Convert feet to miles
    public String convertFeetToMiles(String strFeet) {
        double feet = Double.parseDouble(strFeet);
        double miles = feet / 5280;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(miles));
    }

    //Convert feet to inches
    public String convertFeetToInches(String strFeet) {
        double feet = Double.parseDouble(strFeet);
        double inches = feet * 12;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inches));
    }

    //Convert feet to kilometers
    public String convertFeetToKm(String strFeet) {
        double feet = Double.parseDouble(strFeet);
        double km = feet / 3280.84;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //Convert feet to meters
    public String convertFeetToMeters(String strFeet) {
        double feet = Double.parseDouble(strFeet);
        double meters = feet * 0.3048;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meters));
    }

    //Convert feet to centimeters
    public String convertFeetToCm(String strFeet) {
        double feet = Double.parseDouble(strFeet);
        double cm = feet * 30.48;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    //Convert inches to miles
    public String convertInchesToMiles(String strInches) {
        double inches = Double.parseDouble(strInches);
        double miles = inches * 1.57828;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(miles));
    }

    //Convert inches to feet
    public String convertInchesToFeet(String strInches) {
        double inches = Double.parseDouble(strInches);
        double feet = inches / 12;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(feet));
    }

    //Convert inches to kilometers
    public String convertInchesToKm(String strInches) {
        double inches = Double.parseDouble(strInches);
        double km = inches / 39370;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //Convert inches to meters
    public String convertInchesToMeters(String strInches) {
        double inches = Double.parseDouble(strInches);
        double meters = inches / 39.370;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meters));
    }

    //Convert inches to centimeters
    public String convertInchesToCm(String strInches) {
        double inches = Double.parseDouble(strInches);
        double cm = inches * 2.54;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    //Convert km to miles
    public String convertKmToMiles(String strKm) {
        double km = Double.parseDouble(strKm);
        double miles = km * 0.62137;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(miles));
    }

    //Convert km to feet
    public String convertKmToFeet(String strKm) {
        double km = Double.parseDouble(strKm);
        double feet = km * 3280.84;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(feet));
    }

    //Convert km to inches
    public String convertKmToInches(String strKm) {
        double km = Double.parseDouble(strKm);
        double inches = km * 39370.1;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inches));
    }

    //Convert km to meters
    public String convertKmToMeters(String strKm) {
        double km = Double.parseDouble(strKm);
        double meters = km * 1000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meters));
    }

    //Convert km to centimeters
    public String convertKmToCm(String strKm) {
        double km = Double.parseDouble(strKm);
        double centimeters = km * 100000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(centimeters));
    }

    //Convert meters to miles
    public String convertMetersToMiles(String strMeters) {
        double meters = Double.parseDouble(strMeters);
        double miles = meters / 1609.344;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(miles));
    }

    //Convert meters to feet
    public String convertMetersToFeet(String strMeters) {
        double meters = Double.parseDouble(strMeters);
        double feet = meters * 3.28084;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(feet));
    }

    //Convert meters to inches
    public String convertMetersToInches(String strMeters) {
        double meters = Double.parseDouble(strMeters);
        double inches = meters * 39.3701;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inches));
    }

    //Convert meters to kilometers
    public String convertMetersToKm(String strMeters) {
        double meters = Double.parseDouble(strMeters);
        double km = meters / 1000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //Convert meters to centimeters
    public String convertMetersToCm(String strMeters) {
        double meters = Double.parseDouble(strMeters);
        double centimeters = meters * 100;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(centimeters));
    }
    //Convert centimeters to miles
    public String convertCentimetersToMiles(String strCm) {
        double centimeters = Double.parseDouble(strCm);
        double miles = centimeters * 0.000006213712;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(miles));
    }

    //Convert centimeters to feet
    public String convertCentimetersToFeet(String strCm) {
        double centimeters = Double.parseDouble(strCm);
        double feet = centimeters * 0.032808;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(feet));
    }

    //Convert centimeters to inches
    public String convertCentimetersToInches(String strCm) {
        double centimeters = Double.parseDouble(strCm);
        double inches = centimeters * 0.393701;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inches));
    }

    //Convert centimeters to kilometers
    public String convertCentimetersToKm(String strCm) {
        double centimeters = Double.parseDouble(strCm);
        double km = centimeters / 100000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //Convert centimeters to meters
    public String convertCentimetersToMeters(String strCm) {
        double centimeters = Double.parseDouble(strCm);
        double meters = centimeters * 0.01;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meters));
    }
}
