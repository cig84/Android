package com.example.miprimeraapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable{
	
	private String nombre;
	private String fecha;
	private String psw;
	private double tempo;
	
	public Usuario(){
		
	}
	
	public Usuario(String nombre, String fecha, String psw, double tempo) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.psw = psw;
		this.tempo = tempo;
	}

	public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
		
		public Usuario createFromParcel(Parcel in) {
			
			return new Usuario(in);
		}

		public Usuario[] newArray(int size) {
			return new Usuario[size];
		}
	};
	
	private Usuario(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        nombre = in.readString();
        fecha = in.readString();
        psw = in.readString();
        tempo = in.readDouble();
    }
	

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nombre);
        dest.writeString(fecha);
        dest.writeString(psw);
        dest.writeDouble(tempo);
		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public double getTempo() {
		return tempo;
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

}
