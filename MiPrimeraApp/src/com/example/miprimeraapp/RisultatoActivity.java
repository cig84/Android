package com.example.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
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
	
	public void registra(View v) {
		
		usr = new Usuario();
		usr.setNombre(getIntent().getExtras().getString("nombre"));
		usr.setFecha(getIntent().getExtras().getString("fecha"));
		usr.setPsw(getIntent().getExtras().getString("psw"));
		usr.setTempo(MainActivity.getElapsedMillis()); 
		
		Intent i = new Intent(this, RegistraActivity.class);
		
		i.putExtra("usrNombre", usr.getNombre());
		i.putExtra("usrFecha", usr.getFecha());
		i.putExtra("usrPsw", usr.getPsw());
		i.putExtra("usrTempo", usr.getTempo());
		
		startActivity(i);
		
	}


}
