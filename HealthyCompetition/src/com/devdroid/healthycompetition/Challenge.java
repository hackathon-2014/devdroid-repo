package com.devdroid.healthycompetition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Challenge extends ActionBarActivity {

	TextView challenge;
	ImageButton accepted;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.challenge);

		challenge = (TextView) findViewById(R.id.challenger);
		challenge.setText("Player 2");
		accepted = (ImageButton) findViewById(R.id.accept_button);

		accepted.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent toBattle = new Intent(Challenge.this, BattleFieldActivity.class);
				startActivity(toBattle);

			}
		});

	}

}