package com.example.miprimeraapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NotificaDespues  extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifica);
		String strecivved = getIntent().getStringExtra("contigo");
		Log.e("mensaje recibido", strecivved);
	}
}