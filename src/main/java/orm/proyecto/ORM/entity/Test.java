package orm.proyecto.ORM.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Test {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="pregunta",nullable = false)
	private String pregunta;
	
	@Column(name="respVerdadera",nullable = false)
	private String respVerdadera;
	
	@Column(name="respFalsa1",nullable = false)
	private String respFalsa1;
	
	@Column(name="respFalsa2",nullable = false)
	private String respFalsa2;
	
	@Column(name="respFalsa3",nullable = false)
	private String respFalsa3;
	
	@ManyToOne
	@JoinColumn
	private Temas temas;


	public Temas getTemas() {
		return temas;
	}

	public void setTemas(Temas temas) {
		this.temas = temas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespVerdadera() {
		return respVerdadera;
	}

	public void setRespVerdadera(String respVerdadera) {
		this.respVerdadera = respVerdadera;
	}

	public String getRespFalsa1() {
		return respFalsa1;
	}

	public void setRespFalsa1(String respFalsa1) {
		this.respFalsa1 = respFalsa1;
	}

	public String getRespFalsa2() {
		return respFalsa2;
	}

	public void setRespFalsa2(String respFalsa2) {
		this.respFalsa2 = respFalsa2;
	}

	public String getRespFalsa3() {
		return respFalsa3;
	}

	public void setRespFalsa3(String respFalsa3) {
		this.respFalsa3 = respFalsa3;
	}


	
	

	
	
	
}
