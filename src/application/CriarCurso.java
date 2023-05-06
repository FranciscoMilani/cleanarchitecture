package application;

import application.exceptions.EntidadeJaExisteException;
import domain.Curso;
import domain.repositories.CursoRepository;

public class CriarCurso {
	
	private CursoRepository cursoRepository;
	
	public CriarCurso(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public Curso criarCurso(Curso curso) {
		Curso cursoExistente = cursoRepository.encontrarPorCodigo(curso.getCodigo());
		if (cursoExistente == null) {
			return cursoRepository.criar(curso);
		}
		
		throw new EntidadeJaExisteException("Curso de código: " + curso.getCodigo());
	}
}
