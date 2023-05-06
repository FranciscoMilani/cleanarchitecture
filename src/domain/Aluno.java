package domain;

import java.util.ArrayList;
import java.util.List;

public final class Aluno {
	private int ra;
	private String nome;
	private String email;
	private String password;
	private List<Curso> cursosMatriculados = new ArrayList<>();
	private List<AtividadeComplementar> atividadesRealizadas = new ArrayList<>();
	private int horasComplementares = 0;

	public Aluno(int ra, String nome, String email, String password) {
		this.ra = ra;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	public int getRa() {
		return ra;
	}
	
	public void setRa(int matricula) {
		this.ra = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Curso> getCursosMatriculados() {
		return cursosMatriculados;
	}
	
	public void setCursosMatriculados(List<Curso> cursosMatriculados) {
		this.cursosMatriculados = cursosMatriculados;
	}

	public List<AtividadeComplementar> getAtividadesRealizadas() {
		return atividadesRealizadas;
	}

	public void setAtividadesRealizadas(List<AtividadeComplementar> atividadesRealizadas) {
		this.atividadesRealizadas = atividadesRealizadas;
	}
	
	public void addAtividadeComplementar(AtividadeComplementar atv) {
		this.atividadesRealizadas.add(atv);
	}
	
	public int getHorasComplementares() {
		return horasComplementares;
	}

	public void setHorasComplementares(int horasComplementares) {
		this.horasComplementares = horasComplementares;
	}
	
}
