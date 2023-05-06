package application;

import application.exceptions.EntidadeJaExisteException;
import domain.Aluno;
import domain.Disciplina;
import domain.Matricula;
import domain.repositories.AlunoRepository;
import domain.repositories.DisciplinaRepository;
import domain.repositories.MatriculaRepository;

public class MatricularAlunoDisciplina {
	MatriculaRepository matriculaRepository;
	AlunoRepository alunoRespository;
	DisciplinaRepository disciplinaRespository;
	
	public MatricularAlunoDisciplina(MatriculaRepository matriculaRespository, 
			AlunoRepository alunoRespository, 
			DisciplinaRepository disciplinaRespository) {
		
		this.matriculaRepository = matriculaRespository;
		this.alunoRespository = alunoRespository;
		this.disciplinaRespository = disciplinaRespository;
	}
	
	
	// usar dto?
	public Matricula matricular(Aluno aluno, Disciplina disciplina, String semestre) {
		Matricula matriculaExistente = matriculaRepository.encontrarPorAlunoDisciplina(aluno, disciplina);
		
		if (matriculaExistente == null) {
			Matricula matricula = new Matricula(aluno, disciplina, semestre);
			return matriculaRepository.criar(matricula);	
		} else {
			throw new EntidadeJaExisteException(String.format("Matricula para aluno {%s}, na disciplina {%s}", aluno.getRa(), disciplina.getSigla()));
		}
	}
}
