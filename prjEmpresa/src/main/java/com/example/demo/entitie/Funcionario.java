package com.example.demo.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String funcNome;

	@NotNull
	private String funcNasc;

	@NotNull
	private double funcSalar;

	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Departamento departamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncNome() {
		return funcNome;
	}

	public void setNome(String FuncNome) {
		this.funcNome = FuncNome;
	}

	public String getFuncNasc() {
		return funcNasc;
	}

	public void setFuncNasc(String funcNasc) {
		this.funcNasc = funcNasc;
	}

	public double getFuncSalar() {
		return funcSalar;
	}

	public void setFuncSalar(double funcSalar) {
		this.funcSalar = funcSalar;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}