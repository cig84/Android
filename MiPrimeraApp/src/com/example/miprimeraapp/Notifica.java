package com.example.miprimeraapp;

import java.util.concurrent.ExecutionException;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class Notifica extends AppCompatActivity {
	
	private String dada () throws InterruptedException, ExecutionException
	{
		
		AsyncTaskPost atp = new AsyncTaskPost();
		return atp.execute(null, null, null).get();
	}
	
	private void notifica (String trucazo)
	{
		Log.d("NOT", "Vamos a preparar...: ");
		NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
		Intent i = new Intent(this, NotificaDespues.class);
		i.putExtra("contigo", "Esto es para ti");
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, i, 0);

//		Notification n = new Notification(); esta variable no tendría que existir...
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("Noticias frescas")
				.setStyle(new NotificationCompat.BigTextStyle().bigText(trucazo))
				.setContentText(trucazo);

		mBuilder.setContentIntent(contentIntent);
		mBuilder.setAutoCancel(true);//Cuando el usuario pulse la notificación, desaparecerá
		mNotificationManager.notify(345, mBuilder.build());//ID notificación
		Log.d("NOT", "Notiificacion enviada.");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifica);

		try {
			notifica (dada());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
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
		
		return super.onOptionsItemSelected(item);
	}
}