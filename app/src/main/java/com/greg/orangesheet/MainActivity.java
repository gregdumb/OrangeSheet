package com.greg.orangesheet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}*/

	public void calcData(View view){
		Intent intent = new Intent(this, DisplayDataActivity.class);

		// Get Cycles
		String[] cyclesString = getCyclesStringArray();
		int[] cyclesInt = stringToIntArray(cyclesString);

		// Get Riders/Empties
		String[] ridersString = getRidersStringArray();
		int[] ridersInt = stringToIntArray(ridersString);

		// Get Fast Lane
		String[] fastLaneString = getFastLaneStringArray();
		int[] fastLaneInt = stringToIntArray(fastLaneString);

		boolean usingEmpties = getUsingEmpties();
		String spinnerValue = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();

		int seatsPerUnit = getSeatsPerUnit();

		intent.putExtra("cyclesarray", cyclesInt);
		intent.putExtra("ridersarray", ridersInt);
		intent.putExtra("fastlanearray", fastLaneInt);
		intent.putExtra("usingEmpties", usingEmpties);
		intent.putExtra("seatsperunit", seatsPerUnit);
		//intent.putExtra("spinner", spinnerValue);
		startActivity(intent);
	}

	// Gets the cycles strings from the input boxes
	public String[] getCyclesStringArray(){
		String[] cycles = new String[15];

		cycles[0] = ((EditText)findViewById(R.id.cycles_01)).getText().toString();
		cycles[1] = ((EditText)findViewById(R.id.cycles_02)).getText().toString();
		cycles[2] = ((EditText)findViewById(R.id.cycles_03)).getText().toString();
		cycles[3] = ((EditText)findViewById(R.id.cycles_04)).getText().toString();
		cycles[4] = ((EditText)findViewById(R.id.cycles_05)).getText().toString();
		cycles[5] = ((EditText)findViewById(R.id.cycles_06)).getText().toString();
		cycles[6] = ((EditText)findViewById(R.id.cycles_07)).getText().toString();
		cycles[7] = ((EditText)findViewById(R.id.cycles_08)).getText().toString();
		cycles[8] = ((EditText)findViewById(R.id.cycles_09)).getText().toString();
		cycles[9] = ((EditText)findViewById(R.id.cycles_10)).getText().toString();
		cycles[10] = ((EditText)findViewById(R.id.cycles_11)).getText().toString();
		cycles[11] = ((EditText)findViewById(R.id.cycles_12)).getText().toString();
		cycles[12] = ((EditText)findViewById(R.id.cycles_13)).getText().toString();
		cycles[13] = ((EditText)findViewById(R.id.cycles_14)).getText().toString();
		cycles[14] = ((EditText)findViewById(R.id.cycles_15)).getText().toString();

		return cycles;
	}

	public String[] getRidersStringArray(){
		String[] riders = new String[15];

		riders[0] = ((EditText)findViewById(R.id.riders_1)).getText().toString();
		riders[1] = ((EditText)findViewById(R.id.riders_2)).getText().toString();
		riders[2] = ((EditText)findViewById(R.id.riders_3)).getText().toString();
		riders[3] = ((EditText)findViewById(R.id.riders_4)).getText().toString();
		riders[4] = ((EditText)findViewById(R.id.riders_5)).getText().toString();
		riders[5] = ((EditText)findViewById(R.id.riders_6)).getText().toString();
		riders[6] = ((EditText)findViewById(R.id.riders_7)).getText().toString();
		riders[7] = ((EditText)findViewById(R.id.riders_8)).getText().toString();
		riders[8] = ((EditText)findViewById(R.id.riders_9)).getText().toString();
		riders[9] = ((EditText)findViewById(R.id.riders_10)).getText().toString();
		riders[10] = ((EditText)findViewById(R.id.riders_11)).getText().toString();
		riders[11] = ((EditText)findViewById(R.id.riders_12)).getText().toString();
		riders[12] = ((EditText)findViewById(R.id.riders_13)).getText().toString();
		riders[13] = ((EditText)findViewById(R.id.riders_14)).getText().toString();
		riders[14] = ((EditText)findViewById(R.id.riders_15)).getText().toString();

		return riders;
	}

	public String[] getFastLaneStringArray(){
		String[] fastlane = new String[15];

		fastlane[0] = ((EditText)findViewById(R.id.fastlane_1)).getText().toString();
		fastlane[1] = ((EditText)findViewById(R.id.fastlane_2)).getText().toString();
		fastlane[2] = ((EditText)findViewById(R.id.fastlane_3)).getText().toString();
		fastlane[3] = ((EditText)findViewById(R.id.fastlane_4)).getText().toString();
		fastlane[4] = ((EditText)findViewById(R.id.fastlane_5)).getText().toString();
		fastlane[5] = ((EditText)findViewById(R.id.fastlane_6)).getText().toString();
		fastlane[6] = ((EditText)findViewById(R.id.fastlane_7)).getText().toString();
		fastlane[7] = ((EditText)findViewById(R.id.fastlane_8)).getText().toString();
		fastlane[8] = ((EditText)findViewById(R.id.fastlane_9)).getText().toString();
		fastlane[9] = ((EditText)findViewById(R.id.fastlane_10)).getText().toString();
		fastlane[10] = ((EditText)findViewById(R.id.fastlane_11)).getText().toString();
		fastlane[11] = ((EditText)findViewById(R.id.fastlane_12)).getText().toString();
		fastlane[12] = ((EditText)findViewById(R.id.fastlane_13)).getText().toString();
		fastlane[13] = ((EditText)findViewById(R.id.fastlane_14)).getText().toString();
		fastlane[14] = ((EditText)findViewById(R.id.fastlane_15)).getText().toString();

		return fastlane;
	}

	// get how many seats are in each train/car/cabin
	public int getSeatsPerUnit(){
		String seatsString = ((EditText)findViewById(R.id.seatsPerUnit)).getText().toString();

		if(!seatsString.isEmpty()){
			return Integer.parseInt(seatsString);
		}

		return 0;
	}

	// Converts an array of strings to an array of integers
	public int[] stringToIntArray(String[] stringArray){

		int[] intArray = new int[stringArray.length];

		for(int i = 0; i < stringArray.length; i++){

			intArray[i] = 0;

			if(!stringArray[i].isEmpty()){
				intArray[i] = Integer.parseInt(stringArray[i]);
			}
		}

		return intArray;
	}

	// returns true if empties are selected
	public boolean getUsingEmpties(){
		String sValue = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();

		return sValue.equals("Empties");
	}
}
