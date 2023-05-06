package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.port.IGeradorRelatorio;
import domain.Aluno;
import domain.repositories.AlunoRepository;

public class ListagemRelatoriosAlunos {
	
	private IGeradorRelatorio gerador;
	private AlunoRepository alunoRepository;

	public ListagemRelatoriosAlunos(AlunoRepository alunoRepository, IGeradorRelatorio gerador) {
		this.alunoRepository = alunoRepository;
		this.gerador = gerador;
	}
		

	public void gerar() {
		List<Aluno> alunos = alunoRepository.encontrarTodos();
		String[] headers = {
				"RA",
				"Nome",
				"E-mail"
		};
		
		List<String> dados = new ArrayList<>();
		for (Aluno a : alunos) {
			List<String> infoAluno = Arrays.asList(
						Integer.toString(a.getRa()), 
						a.getNome(), 
						a.getEmail()
					);
			
			dados.add(String.join(";", infoAluno));
		}
		
		gerador.armazenar(headers, dados, TipoRelatorio.ALUNOS);
	}
}
