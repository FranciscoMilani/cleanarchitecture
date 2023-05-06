package infrastructure.controller;

import application.CadastrarAluno;
import application.CriarCurso;
import domain.Aluno;

public class AlunoController {
	
	private CadastrarAluno casoDeUso;
	
	public AlunoController(CadastrarAluno casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	
	public void cadastraAluno(Aluno aluno) {
		if (casoDeUso.criarAluno(aluno) == null) {
			System.out.println("\nERRO: E-mail inválido.");
		}
	}
}
