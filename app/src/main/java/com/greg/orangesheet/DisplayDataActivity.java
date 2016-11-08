package com.greg.orangesheet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayDataActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle("Results");

		setContentView(R.layout.activity_display_data);

		Intent intent = getIntent();

		int[] cycles = intent.getIntArrayExtra("cyclesarray");
		int[] riders = intent.getIntArrayExtra("ridersarray");
		int[] fastLane = intent.getIntArrayExtra("fastlanearray");
		boolean usingEmpties = intent.getExtras().getBoolean("usingEmpties");
		int seatsPerUnit = intent.getExtras().getInt("seatsperunit");

		int cyclesTotal = 0;
		int ridersTotal = 0;
		int fastLaneTotal = 0;

		// Calculate total cycles.
		for(int i = 0; i < cycles.length; i++){
			cyclesTotal += cycles[i];
		}

		// Calculate riders.  If riders array is actually empty, we will convert it.
		for(int i = 0; i < riders.length; i++){

			if(usingEmpties) {
				riders[i] = cycles[i] * seatsPerUnit - riders[i];
				ridersTotal += riders[i];
			}
			else {
				ridersTotal += riders[i];
			}
		}

		// Calculate total fast lane
		for(int i = 0; i < fastLane.length; i++){
			fastLaneTotal += fastLane[i];
		}

		setOutputRiders(riders);

		((TextView)findViewById(R.id.total_cycles)).setText(Integer.toString(cyclesTotal));
		((TextView)findViewById(R.id.total_riders)).setText(Integer.toString(ridersTotal));
		((TextView)findViewById(R.id.total_fastlane)).setText(Integer.toString(fastLaneTotal));

		/*TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(Integer.toString(ridersTotal));

		// Set the text view as the activity layout
		setContentView(textView);*/
	}

	public void setOutputRiders(int[] riders){
		((TextView)findViewById(R.id.riders_out_1)).setText(Integer.toString(riders[0]));
		((TextView)findViewById(R.id.riders_out_2)).setText(Integer.toString(riders[1]));
		((TextView)findViewById(R.id.riders_out_3)).setText(Integer.toString(riders[2]));
		((TextView)findViewById(R.id.riders_out_4)).setText(Integer.toString(riders[3]));
		((TextView)findViewById(R.id.riders_out_5)).setText(Integer.toString(riders[4]));
		((TextView)findViewById(R.id.riders_out_6)).setText(Integer.toString(riders[5]));
		((TextView)findViewById(R.id.riders_out_7)).setText(Integer.toString(riders[6]));
		((TextView)findViewById(R.id.riders_out_8)).setText(Integer.toString(riders[7]));
		((TextView)findViewById(R.id.riders_out_9)).setText(Integer.toString(riders[8]));
		((TextView)findViewById(R.id.riders_out_10)).setText(Integer.toString(riders[9]));
		((TextView)findViewById(R.id.riders_out_11)).setText(Integer.toString(riders[10]));
		((TextView)findViewById(R.id.riders_out_12)).setText(Integer.toString(riders[11]));
		((TextView)findViewById(R.id.riders_out_13)).setText(Integer.toString(riders[12]));
		((TextView)findViewById(R.id.riders_out_14)).setText(Integer.toString(riders[13]));
		((TextView)findViewById(R.id.riders_out_15)).setText(Integer.toString(riders[14]));
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_display_data, menu);
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
}
