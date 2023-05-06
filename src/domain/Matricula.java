package domain;

import java.util.List;

public final class Matricula {
	
	private Aluno aluno;
	private Disciplina disciplina;
	private String semestre;
	
	public Matricula(Aluno aluno, Disciplina disciplina, String semestre) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.semestre = semestre;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
}
