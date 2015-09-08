package com.example.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static TextView muestra;
	private static Button pulsanteInizia;
	private static Button pulsanteFerma;
	private static Usuario usr = null;
	private static Chronometer chronometer;
	private static double elapsedMillis;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AsyncTaskGet myGet = new AsyncTaskGet();
		myGet.execute(null, null, null);
		
		AsyncTaskPost myPost = new AsyncTaskPost();
		myPost.execute(null, null, null);
		
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
				Intent i3 = new Intent(this, RegistraActivity.class);
				startActivity(i3);
				break;
				
			case R.id.action_toast:
				Intent i4 = new Intent(this, ToastActivity.class);
				startActivity(i4);
				break;
			case R.id.action_database:
				Intent i5 = new Intent(this, DBinsActivity.class);
				startActivity(i5);
				break;
				
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void risultato(View v) {
		
		EditText nombre = (EditText) findViewById(R.id.nombre);
		EditText fecha = (EditText) findViewById(R.id.fecha);
		EditText psw = (EditText) findViewById(R.id.psw);
		

		Intent i = new Intent(this, RisultatoActivity.class);
		
		i.putExtra("nombre", nombre.getText().toString());
		i.putExtra("fecha", fecha.getText().toString());
		i.putExtra("psw", psw.getText().toString());
		i.putExtra("tempo", elapsedMillis);
		
		startActivity(i);
	}
	
	
	public static Button getPulsanteInizia() {
		return pulsanteInizia;
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

	public static Button getPulsanteFerma() {
		return pulsanteFerma;
	}

	public static void setPulsanteFerma(Button pulsanteFerma) {
		MainActivity.pulsanteFerma = pulsanteFerma;
	}
	
	public static double getElapsedMillis() {
		return elapsedMillis;
	}

	public static void setElapsedMillis(double elapsedMillis) {
		MainActivity.elapsedMillis = elapsedMillis;
	}

	public static Usuario getUsr() {
		return usr;
	}

	public static void setUsr(Usuario usr) {
		usr = usr;
	}
}
