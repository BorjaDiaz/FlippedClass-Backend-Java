package es.atos.proyecto.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="DAS",nullable = false)
	private String das;

	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@Column(name="apellidos",nullable = false)
	private String apellidos;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="rol",nullable = false)
	private String rol;
	
	@Column(name="estado",nullable = false)
	private boolean estado;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Ranking> ranking;
	

	
	public String getDas() {
		return das;
	}

	public void setDas(String das) {
		this.das = das;
	}
	public Set<Ranking> getRanking() {
		return ranking;
	}

	public void setRanking(Set<Ranking> ranking) {
		this.ranking = ranking;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmal() {
		return email;
	}

	public void setEmal(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
