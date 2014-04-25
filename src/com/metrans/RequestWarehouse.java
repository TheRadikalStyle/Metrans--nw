package com.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;






import au.com.bytecode.opencsv.CSVReader;

public class RequestWarehouse extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_request_warehouse);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.request_warehouse, menu);
		return true;
	}
	
	/** Called when the user clicks the continue button */
	public void goToProducts(View view) {
		Intent intent = new Intent(this, RequestProducts.class);
		startActivity(intent);
	}
	/** Called when the user click the file-choose button **/
	public void selectFile(View view){
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//Create FileOpenDialog and register a callback
		/////////////////////////////////////////////////////////////////////////////////////////////////
		SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RequestWarehouse.this, "FileOpen",
		new SimpleFileDialog.SimpleFileDialogListener(){


		@Override
		public void onChosenDir(String chosenDir) {
		// The code in this function will be executed when the dialog OK button is pushed 
		String m_chosen = chosenDir;
		Toast.makeText(RequestWarehouse.this, "Chosen FileOpenDialog File: " + m_chosen, Toast.LENGTH_LONG).show();
		
		String next[] = {};
		List<String[]> list = new ArrayList<String[]>();
		try {
		CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(m_chosen)));                        //(getAssets().openNonAssetFd(chosenDir))) ;       //.openNonAssetFd(m_chosen)));//   .open("m_chosen")));//Specify asset file name
		//in open();
		for(;;) {
		next = reader.readNext();
		if(next != null) {
		list.add(next);
		} else {
		break;
		}
		}
		
		
		
		if(list != null)
			getMimeType(m_chosen);
	
		//Aqui debe de ir si = a csv ejecutar o no
			new VibratingToast(getApplicationContext(), "Archivo funcional, puede continuar",Toast.LENGTH_LONG);
		}
		catch (IOException e) {
		e.printStackTrace();
		new VibratingToast(getApplicationContext(), "Error de lectura de archivo, intente nuevamente",Toast.LENGTH_LONG);
		}
		
		}
		

		public  String getMimeType(String m_chosen) {
		    String extension = MimeTypeMap.getFileExtensionFromUrl(m_chosen);
		    final String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
		    Toast.makeText(getApplicationContext(),"Tipo " +extension, Toast.LENGTH_LONG).show();
		    return (mimeType !=  null) ? mimeType : "unknown";
		}
		
		});
		

		
		//You can change the default filename using the public variable "Default_File_Name"
		FileOpenDialog.Default_File_Name = "";
		FileOpenDialog.chooseFile_or_Dir();
		
		

	}
	
	/** Called when the user clicks the close button */
	public void goToMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);

	}

}
