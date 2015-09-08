package com.example.miprimeraapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

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
