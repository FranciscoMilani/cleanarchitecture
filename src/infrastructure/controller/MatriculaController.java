package infrastructure.controller;

import application.MatricularAlunoDisciplina;
import domain.Aluno;
import domain.Disciplina;
import domain.repositories.AlunoRepository;
import domain.repositories.DisciplinaRepository;

public class MatriculaController {
	
	MatricularAlunoDisciplina casoDeUso;
	AlunoRepository alunoRepo;
	DisciplinaRepository disciplinaRepo;
	
	public MatriculaController(MatricularAlunoDisciplina casoDeUso, 
			AlunoRepository alunoRepo,
			DisciplinaRepository disciplinaRepo) {
		
		this.casoDeUso = casoDeUso;	
		this.alunoRepo = alunoRepo;	
		this.disciplinaRepo = disciplinaRepo;

	}
	
	public void matriculaAluno(int ra, String sigla, String semestre) {
		Aluno aluno = alunoRepo.encontrarPorRa(ra);
		Disciplina disciplina = disciplinaRepo.encontrarPorSigla(sigla);	
		
		if (aluno != null && disciplina != null) {
			casoDeUso.matricular(aluno, disciplina, semestre);
		} else {
			System.out.println("Disciplina ou Aluno nulo");
		}
	}
}
