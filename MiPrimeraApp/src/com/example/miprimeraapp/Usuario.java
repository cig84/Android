package com.example.miprimeraapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable{
	
	private String nombre;
	private String fecha;
	private String psw;
	private long tempo;
	

	public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
		
		public Usuario createFromParcel(Parcel in) {
			
			return new Usuario(in);
		}

		public Usuario[] newArray(int size) {
			return new Usuario[size];
		}
	};
	
	public Usuario(){
		
	}
	
	private Usuario(Parcel in) {
        readFromParcel(in);
    }
	
	public void writeToParcel(Parcel out) {
        out.writeString(nombre);
        out.writeString(fecha);
        out.writeString(psw);
        out.writeLong(tempo);
    }

    public void readFromParcel(Parcel in) {
        nombre = in.readString();
        fecha = in.readString();
        psw = in.readString();
        tempo = in.readLong();
    }
	

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
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
	public long getTempo() {
		return tempo;
	}
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

}
