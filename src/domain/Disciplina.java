package domain;

import java.util.List;

public final class Disciplina {

	private String nome;
	private String sigla;
	private int creditos;
	private int cargaHoraria;
	private List<Disciplina> preRequisitos;
	
	public Disciplina(String nome, String sigla, int creditos, int cargaHoraria, List<Disciplina> preRequisitos) {
		this.nome = nome;
		this.sigla = sigla;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.preRequisitos = preRequisitos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int horas) {
		this.cargaHoraria = horas;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

}
