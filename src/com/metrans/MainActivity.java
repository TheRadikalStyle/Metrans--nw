package com.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user clicks the start button */
	public void goToWareHouse(View view) {
		Intent intent = new Intent(this, RequestWarehouse.class);
		startActivity(intent);

	}
	/** Called when the user clicks the about button */
	public void goToAbout(View view) {
		Intent intent = new Intent(this, About.class);
		startActivity(intent);

	}
	/** Called when the user clicks the help button */
	public void goToHelp(View view) {
		Intent intent = new Intent(this, Help.class);
		startActivity(intent);

	}
	
}
