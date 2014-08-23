package com.devdroid.healthycompetition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Profile extends ActionBarActivity {

	ImageButton maleBtn, femaleBtn, lowAgeBtn, midAgeBtn, highAgeBtn;
	Button finalizeBtn;
	boolean regValidated, sexOk, ageOk, buttonsOk = false;
	int sex, ageGroup, spinnerChoice, fitnessLevel = 99;
	Spinner flSpinner;
	ArrayAdapter<CharSequence> adapter;
	String[] repsChanged;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);

		maleBtn = (ImageButton) findViewById(R.id.male_button);
		femaleBtn = (ImageButton) findViewById(R.id.female_button);
		lowAgeBtn = (ImageButton) findViewById(R.id.low_age_button);
		midAgeBtn = (ImageButton) findViewById(R.id.mid_age_button);
		highAgeBtn = (ImageButton) findViewById(R.id.high_age_button);
		finalizeBtn = (Button) findViewById(R.id.finalize_profile);

		// FITNESS LEVEL SPINNER //
		flSpinner = (Spinner) findViewById(R.id.fitnessSpinner);
		adapter = ArrayAdapter.createFromResource(this,
				R.array.fitness_level_spinner_array,
				R.layout.my_spinner_textview);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.my_spinner_textview);
		flSpinner.setAdapter(new NothingSelectedSpinnerAdapter(adapter,
				R.layout.my_spinner_textview,
				// R.layout.contact_spinner_nothing_selected_dropdown, //
				// Optional
				this));

		// SEX BUTTONS //
		maleBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(), "male chosen",
				// Toast.LENGTH_SHORT).show();
				sex = 1;
				sexOk = true;
			}
		});
		femaleBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(), "female chosen",
				// Toast.LENGTH_SHORT).show();
				sex = 0;
				sexOk = true;
			}
		});

		// AGE BUTTONS //
		lowAgeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(), "low chosen",
				// Toast.LENGTH_SHORT).show();
				ageGroup = 0;
				ageOk = true;
			}
		});
		midAgeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(), "mid chosen",
				// Toast.LENGTH_SHORT).show();
				ageGroup = 1;
				ageOk = true;
			}
		});
		highAgeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(), "high chosen",
				// Toast.LENGTH_SHORT).show();
				ageGroup = 2;
				ageOk = true;
			}
		});

		finalizeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (sexOk == false)
					Toast.makeText(getApplicationContext(), "choose sex",
							Toast.LENGTH_SHORT).show();
				if (ageOk == false)
					Toast.makeText(getApplicationContext(), "choose age",
							Toast.LENGTH_SHORT).show();

				if (sexOk == true && ageOk == true) {

					// *******FITNESS LEVEL*******//
					// get selection from fitness level spinner unless it is the
					// first element of the array (that is the -select one-
					// display)
					spinnerChoice = flSpinner.getSelectedItemPosition();


					if (spinnerChoice == 0) {
						Toast.makeText(getApplicationContext(),
								"Select Fitness Level", Toast.LENGTH_SHORT)
								.show();
						regValidated = false;
					} else {
						fitnessLevel = spinnerChoice;
						regValidated = true;
					}
					// *******END FITNESS LEVEL VALIDATION*******//

					if (regValidated == true) {

						// create RepAdjustment object to...guess what? adjust
						// reps
						RepAdj ra = new RepAdj();
						repsChanged = ra.regConditions(sex, ageGroup,
								fitnessLevel);

					}


				}
				Intent toBattle = new Intent(Profile.this, BattleFieldActivity.class);
				startActivity(toBattle);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
