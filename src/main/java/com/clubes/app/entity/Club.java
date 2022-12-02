package com.clubes.app.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="clubes")
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String foto;
	
	@OneToOne
	private Entrenador entrenador;
	
	@OneToMany
	@JoinColumn(name="id_club")
	private List<Jugador> jugadores;
	
	@ManyToOne
	private Asociacion asociacion;
	
	@ManyToMany
	private List <Competicion> competiciones;

	public Club() {
		this.id = 0;
	}

	public Club(int id, String nombre, String foto, Entrenador entrenador, List<Jugador> jugadores, Asociacion asociacion, List<Competicion> competiciones) {
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.entrenador = entrenador;
		this.jugadores = jugadores;
		this.asociacion = asociacion;
		this.competiciones = competiciones;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public List<Competicion> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competicion> competiciones) {
		this.competiciones = competiciones;
	}
	

}
