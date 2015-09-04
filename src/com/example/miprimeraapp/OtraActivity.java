package com.example.miprimeraapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OtraActivity extends Activity {
	
	private static TextView nombre;
	private static TextView fecha;
	private static TextView psw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_otra);
		
		nombre = (TextView)findViewById(R.id.textView1);
		fecha = (TextView)findViewById(R.id.textView2);
		psw = (TextView)findViewById(R.id.textView3);
		nombre.setText(getIntent().getExtras().getString("nombre"));
		fecha.setText(getIntent().getExtras().getString("fecha"));
		psw.setText(getIntent().getExtras().getString("psw"));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.otro, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}

	public static TextView getNombre() {
		return nombre;
	}

	public static void setNombre(TextView nombre) {
		OtraActivity.nombre = nombre;
	}

	public static TextView getFecha() {
		return fecha;
	}

	public static void setFecha(TextView fecha) {
		OtraActivity.fecha = fecha;
	}

	public static TextView getPsw() {
		return psw;
	}

	public static void setPsw(TextView psw) {
		OtraActivity.psw = psw;
	}
	
	

}
