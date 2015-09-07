package com.example.miprimeraapp;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProcesarEventos implements OnClickListener {

	@Override
	public void onClick(View v) {
		
		int id = v.getId();
		switch(id){
			case R.id.button1:
				MainActivity.getChronometer().setBase(SystemClock.elapsedRealtime());
				MainActivity.getChronometer().start();
				MainActivity.getPulsanteInizia().setVisibility(Button.INVISIBLE);
				MainActivity.getPulsanteFerma().setVisibility(Button.VISIBLE);
				MainActivity.getMuestra().setText(R.string.inizia);		
				break;
				
			case R.id.button2:
				MainActivity.getPulsanteInizia().setVisibility(Button.VISIBLE);
				MainActivity.getPulsanteFerma().setVisibility(Button.INVISIBLE);
				MainActivity.getChronometer().stop();
				MainActivity.getMuestra().setText(R.string.ferma);
				double elapsedMillis = (SystemClock.elapsedRealtime() - MainActivity.getChronometer().getBase())/1000.0;
				MainActivity.setElapsedMillis(elapsedMillis);
				break;
				
			
		}

	}
	

}
