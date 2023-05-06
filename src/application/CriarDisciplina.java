package application;

import application.exceptions.EntidadeJaExisteException;
import domain.Disciplina;
import domain.repositories.DisciplinaRepository;

public class CriarDisciplina {
	
	private DisciplinaRepository disciplinaRepository;

	public CriarDisciplina(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}
	
	public Disciplina criarDisciplina(Disciplina disciplina) {
		Disciplina disciplinaExistente = disciplinaRepository.encontrarPorSigla(disciplina.getSigla());
		if (disciplinaExistente == null) {
			return disciplinaRepository.criar(disciplina);
		}
		
		throw new EntidadeJaExisteException("Disciplina: " + disciplina.getSigla());
	}
}
