package com.clubes.app.entity;

import javax.persistence.*;

@Entity
@Table(name="competiciones")
public class Competicion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private int montoPremio;
	
	private String fechaInicio;
	
	private String fechaFin;
	
	private String foto;

	public Competicion() {
		this.id = 0;
	}

	public Competicion(int id, String nombre, int montoPremio, String fechaInicio, String fechaFin, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.montoPremio = montoPremio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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

	public int getMontoPremio() {
		return montoPremio;
	}

	public void setMontoPremio(int montoPremio) {
		this.montoPremio = montoPremio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
