package application;

import application.exceptions.EntidadeJaExisteException;
import application.port.IValidadorEmail;
import domain.Aluno;
import domain.repositories.AlunoRepository;

public class CadastrarAluno {
	
	private AlunoRepository alunoRepository;
	private IValidadorEmail validadorEmail;
	
	public CadastrarAluno(AlunoRepository alunoRepository, IValidadorEmail validador) {
		this.alunoRepository = alunoRepository;
		this.validadorEmail = validador;
	}
	
	public Aluno criarAluno(Aluno aluno) {
		Aluno alunoRepo = alunoRepository.encontrarPorRa(aluno.getRa());
		if (alunoRepo == null) {
			if (validadorEmail.validar(aluno.getEmail())) {
				return alunoRepository.criar(aluno);
			}
			
			return null;
		}
		
		throw new EntidadeJaExisteException("Aluno com ra: " + Integer.toString(aluno.getRa()));
	}
}