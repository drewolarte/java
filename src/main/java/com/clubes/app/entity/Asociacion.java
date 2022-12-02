package com.clubes.app.entity;

import javax.persistence.*;

@Entity
@Table(name="asociaciones")
public class Asociacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String pais;
	
	private String presidente;
	
	private String siglas;
	
	private String foto;

	public Asociacion() {
		this.id = 0;
	}

	public Asociacion(int id, String nombre, String pais, String presidente, String siglas, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.presidente = presidente;
		this.siglas = siglas;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
