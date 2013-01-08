package com.codexion.regladetres;

import com.codexion.regladetres.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ReglaDeTres extends Activity {

	// Define global vars
	String debugTag = "ReglaDeTres";
	int decimals = 3;

	double value1 = 0;
	double value2 = 0;
	double value3 = 0;
	
	TextView txtValue1;
	TextView txtValue2;
	TextView txtValue3;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtValue1 = (TextView) findViewById(R.id.txtValue1);
		txtValue2 = (TextView) findViewById(R.id.txtValue2);
		txtValue3 = (TextView) findViewById(R.id.txtValue3);
		

		try {
			// initial values, restored from instanceState
			value1 = (double) savedInstanceState.getDouble("value1");
			value2 = (double) savedInstanceState.getDouble("value2");
			value3 = (double) savedInstanceState.getDouble("value3");
		} catch (Exception e) {
			value1 = 0;
			Log.e(debugTag, "Error retrieving initial values");
			e.printStackTrace();
		}
/*
		// Get the current values
		try {
			value1 = Integer.parseInt((String) txtValue1.getText());
			value2 = Integer.parseInt((String) txtValue2.getText());
			value3 = Integer.parseInt((String) txtValue3.getText());
		} catch (NumberFormatException e) {
			Log.e(debugTag, "NumberFormat exception");
			e.printStackTrace();
		}
*/
	}

	public void processCalculate(View v) {
		TextView incognita =(TextView) findViewById(R.id.incognita);
		incognita.setTextColor(Color.BLACK);
		Log.e(debugTag, "Inside processCalculate()");
		// Get the entered values
		// Check that the input is a number, as expected.
		String value = txtValue1.getText().toString();
		if (value.equals("")) {
			// Set to zero if value is empty
			value = "0";
		} else {
			// Convert to 'double' for calculations
			value1 = Double.parseDouble(value);
		}
		Log.e(debugTag, "value1 = " + value1);
		
		
		value = txtValue2.getText().toString();
		if (value.equals("")) {
			// Set to zero if value is empty
			value = "0";
		} else {
			// Convert to 'double' for calculations
			value2 = Double.parseDouble(value);
		}
		Log.e(debugTag, "value2 = " + value2);
		
		value = txtValue3.getText().toString();
		if (value.equals("")) {
			// Set to zero if value is empty
			value = "0";
		} else {
			// Convert to 'double' for calculations
			value3 = Double.parseDouble(value);
		}
		Log.e(debugTag, "value3 = " + value3);
		
		try {
			// Avoid dividing by zero
			if ((int)value1 != 0) {
				double result = (value2 * value3) / value1;
				// Round to 'decimals' decimals
				result = Math.round(result * Math.pow(10,decimals)) / Math.pow(10,decimals);
				Log.e(debugTag, "result = " + Double.toString(result));
				incognita.setText(Double.toString(result));
			} else {
				incognita.setTextColor(Color.RED);
				incognita.setText("Div by 0 Error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception occurred: " + e.getCause());
			e.printStackTrace();
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Restore UI state from the savedInstanceState.
		// This bundle has also been passed to onCreate.
		value1 = savedInstanceState.getInt("value1");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		// Save UI state changes to the savedInstanceState.
		// This bundle will be passed to onCreate if the process is
		// killed and restarted.
		savedInstanceState.putDouble("value1", value1);
		savedInstanceState.putDouble("value2", value2);
		savedInstanceState.putDouble("value3", value3);
	}
}
