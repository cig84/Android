package com.example.miprimeraapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.TextView;

public class RisultatoActivity extends Activity{
	
	private static TextView nombre;
	private static TextView fecha;
	private static TextView psw;
	private static TextView tempo;
	private static Usuario usr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registra);
		
		nombre = (TextView)findViewById(R.id.nome);
		fecha = (TextView)findViewById(R.id.data);
		psw = (TextView)findViewById(R.id.pass);
		tempo = (TextView)findViewById(R.id.tempo);
		
		nombre.setText(getIntent().getExtras().getString("nombre"));
		fecha.setText(getIntent().getExtras().getString("fecha"));
		psw.setText(getIntent().getExtras().getString("psw"));
		tempo.setText(String.valueOf(MainActivity.getElapsedMillis()));
		
		
	}


}
