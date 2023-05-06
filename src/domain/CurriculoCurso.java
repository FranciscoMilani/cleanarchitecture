package domain;

import java.util.List;

public class CurriculoCurso {
	
	private Curso curso;
	private int numSemestres;
	private int cargaHoraria;
	private List<Disciplina> disciplinas;
	
	public CurriculoCurso(Curso curso, int numSemestres, int cargaHoraria, List<Disciplina> disciplinas) {
		this.curso = curso;
		this.disciplinas = disciplinas;
		this.numSemestres = numSemestres;
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public int getNumSemestres() {
		return numSemestres;
	}
	
	public void setNumSemestres(int numSemestres) {
		this.numSemestres = numSemestres;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
