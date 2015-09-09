package com.example.ejemplogcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button regServ;
	Button regGCM;
	GoogleCloudMessaging gcm = new GoogleCloudMessaging();
	String regId;
	Context context;
	
	public class AsyncTaskPost extends AsyncTask<Void, Void, String>{
		
		String urlServ = "http://172.16.1.87:8090/ServletParaAndroid/Servlet";
		String resp;

		@Override
		protected String doInBackground(Void... params) {
			
			try {
				URL url = new URL(urlServ);
				try {
					
					String mensaje = "Mensaje al servidor"; //eso irá en el body de la POST
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-type", "text/plain;charset=UTF-8");
					OutputStream out = conn.getOutputStream();
					out.write(mensaje.getBytes());
					out.close();
					conn.getResponseCode();
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					resp = in.readLine(); 
					in.close();
					conn.disconnect();
					
				} catch (IOException e) {
					Log.e("AsyncTaskPost", e.getMessage());
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				Log.e("AsyncTaskPost", e.getMessage());
				e.printStackTrace();
			}
			
			return resp;
		}
		
		@Override
		protected void onPostExecute(String result) {
			
			Log.d("Clase POST", result); 

		}

	}
	
	private String registrarGCM(){
		
		gcm = GoogleCloudMessaging.getInstance(this);
		regId = getRegistrationId(context);
		if(TextUtils.isEmpty(regId)){
			registerInBackground();
			Log.d("RegisterActivity", "Registrando id...");
			
		}
		return regId;
	}
	
	private String getRegistrationId(Context context){
		
		String registrationId = null;
		final SharedPreferences prefs = getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
		registrationId = prefs.getString("REG_ID", "");
		if(registrationId.isEmpty()){
			Log.i("MainActivity", "No está registrado");	
		}
		return registrationId;
	}
	
	private void registerInBackground(){
		
		new AsyncTask<Void, Void, String>(){

			@Override
			protected String doInBackground(Void... params) {
				String msg = "";
				
				try{
					if (gcm == null) {
						gcm = GoogleCloudMessaging.getInstance(context);
					}
					regId = gcm.register("976784217664");
				
				msg = "Device registered, registration ID=" + regId;
				
				storeRegistrationId();
				
				}catch(IOException ex) {
					msg = "Error: " + ex.getMessage();
					Log.d("RegisterActivity", "Error: " + msg);
				}
				
				Log.d("RegisterActivity", "AsyncTask completed: " + msg);
				return msg;
			}
			@Override
			protected void onPostExecute(String msg){
				Toast.makeText(getApplicationContext(), "RegistradoServer." + msg, Toast.LENGTH_LONG).show();
			}
		}.execute(null, null, null);
		
	}
	
	private void storeRegistrationId(){
		
		SharedPreferences prefs = getSharedPreferences(MainActivity.class.getSimpleName(), 
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("REG_ID", regId);
		
		editor.commit();
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
