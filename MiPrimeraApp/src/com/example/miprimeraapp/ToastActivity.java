package com.example.miprimeraapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		
			case R.id.button1:
				Toast notiNorm = Toast.makeText(getApplicationContext(), "Estamos en clase", Toast.LENGTH_SHORT);
				notiNorm.show();
				break;
			case R.id.button2:
				Toast notiGrav = Toast.makeText(getApplicationContext(), "Toast con Gravity", Toast.LENGTH_SHORT);
				notiGrav.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.RIGHT, 0, 0);
				notiGrav.show();
				break;
			case R.id.button3:
				Toast notiPers = new Toast(getApplicationContext()); 
				LayoutInflater inf = getLayoutInflater();
				v = inf.inflate((R.layout.layout_notificacion), (ViewGroup)findViewById(R.id.layoutNoti));
				TextView tv = (TextView) v.findViewById(R.id.noti);
				tv.setText("Mi custom toast");
				notiPers.setDuration(Toast.LENGTH_SHORT);
				notiPers.setView(v);
				notiPers.show();
				break;
		}
		
	}


}
