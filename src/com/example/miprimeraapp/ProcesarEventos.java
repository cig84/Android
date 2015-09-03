package com.example.miprimeraapp;

import android.view.View;
import android.view.View.OnClickListener;

public class ProcesarEventos implements OnClickListener {

	@Override
	public void onClick(View v) {
		
		MainActivity.getMuestra().setText(MainActivity.getTexto().getText());

	}

}
