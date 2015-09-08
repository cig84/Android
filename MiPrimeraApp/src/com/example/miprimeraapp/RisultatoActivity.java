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
		
		Usuario usrL = new Usuario(getIntent().getExtras().getString("nombre"), getIntent().getExtras().getString("fecha"), getIntent().getExtras().getString("psw"), MainActivity.getElapsedMillis());
		usr = new Usuario(getIntent().getExtras().getString("nombre"), getIntent().getExtras().getString("fecha"), getIntent().getExtras().getString("psw"), MainActivity.getElapsedMillis());
//		usr.setNombre(getIntent().getExtras().getString("nombre"));
//		usr.setFecha(getIntent().getExtras().getString("fecha"));
//		usr.setPsw(getIntent().getExtras().getString("psw"));
//		usr.setTempo(MainActivity.getElapsedMillis()); 
		
		Intent i = new Intent(this, DBinsActivity.class);
		
//		i.putExtra("userNombre", usr.getNombre());
//		i.putExtra("userFecha", usr.getFecha());
//		i.putExtra("userPsw", usr.getPsw());
//		i.putExtra("userTempo", usr.getTempo());
		i.putExtra("user", usr);
		i.putExtra("userL", usrL);
		
		startActivity(i);
		
	}


}
