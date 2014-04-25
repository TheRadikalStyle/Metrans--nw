package com.metrans;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import au.com.bytecode.opencsv.CSVWriter;


public class Result extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}
	
	/** Called when the user clicks the close button */
	public void goToMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);

	}

	public void export(View view) throws IOException{
		String csv = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
		CSVWriter writer = new CSVWriter(new FileWriter(csv));

		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[] {"India", "New Delhi"});
		data.add(new String[] {"United States", "Washington D.C"});
		data.add(new String[] {"Germany", "Berlin"});

		writer.writeAll(data);

		writer.close();
	}
	
}
