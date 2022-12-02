package com.clubes.app.entity;

import javax.persistence.*;

@Entity
@Table(name="jugadores")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private int numero;
	
	private String posicion;
	
	private String foto;

	public Jugador() {
		this.id = 0;
	}

	public Jugador(int id, String nombre, String apellido, int numero, String posicion, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.posicion = posicion;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
