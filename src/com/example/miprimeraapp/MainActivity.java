package com.example.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static EditText texto;
	private static TextView muestra;
	private static Button pulsanteInizia;
	private static Button pulsanteFerma;
	
	private static Chronometer chronometer;
	private static long elapsedTime=0;
	private static String currentTime="";
	private static long startTime;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		texto = (EditText) findViewById(R.id.editText1);
		muestra = (TextView) findViewById(R.id.textView2);
		chronometer = (Chronometer) findViewById(R.id.chronometer1);
		pulsanteFerma = (Button) findViewById(R.id.button2);
		pulsanteInizia = (Button) findViewById(R.id.button1);
		
		pulsanteFerma.setVisibility(Button.INVISIBLE);
		pulsanteInizia.setOnClickListener(new ProcesarEventos());
		pulsanteFerma.setOnClickListener(new ProcesarEventos());
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
			case R.id.action_settings:
				
				break;
				
			case R.id.action_close:
				finish();
				break;
				
			case R.id.action_as:
				Intent i = new Intent("android.intent.action.VIEW", Uri.parse("http://as.com/"));
				startActivity(i);
				break;
				
			case R.id.action_marca:
				Intent i2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.marca.com/"));
				startActivity(i2);
				break;
				
			case R.id.action_reloj:
				Intent i3 = new Intent(this, OtraActivity.class);
				startActivity(i3);
				break;
				
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void registra(View v) {
		
		EditText nombre = (EditText) findViewById(R.id.nombre);
		EditText fecha = (EditText) findViewById(R.id.fecha);
		EditText psw = (EditText) findViewById(R.id.psw);
		
		Intent i = new Intent(this, OtraActivity.class);
			
		i.putExtra("nombre", nombre.getText().toString());
		i.putExtra("fecha", fecha.getText().toString());
		i.putExtra("psw", psw.getText().toString());
		startActivity(i);
	}
	

	public static Button getPulsanteInizia() {
		return pulsanteInizia;
	}

	public static EditText getTexto() {
		return texto;
	}

	public static TextView getMuestra() {
		return muestra;
	}

	public static Chronometer getChronometer() {
		return chronometer;
	}

	public static void setChronometer(Chronometer chronometer) {
		MainActivity.chronometer = chronometer;
	}

	public static long getElapsedTime() {
		return elapsedTime;
	}

	public static void setElapsedTime(long elapsedTime) {
		MainActivity.elapsedTime = elapsedTime;
	}

	public static String getCurrentTime() {
		return currentTime;
	}

	public static void setCurrentTime(String currentTime) {
		MainActivity.currentTime = currentTime;
	}

	public static long getStartTime() {
		return startTime;
	}

	public static void setStartTime(long startTime) {
		MainActivity.startTime = startTime;
	}


	public static Button getPulsanteFerma() {
		return pulsanteFerma;
	}


	public static void setPulsanteFerma(Button pulsanteFerma) {
		MainActivity.pulsanteFerma = pulsanteFerma;
	}
}
