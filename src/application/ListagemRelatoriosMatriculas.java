package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.port.IGeradorRelatorio;
import domain.Aluno;
import domain.Matricula;
import domain.repositories.MatriculaRepository;

public class ListagemRelatoriosMatriculas {
	
	private IGeradorRelatorio gerador;
	private MatriculaRepository matriculaRepository;

	public ListagemRelatoriosMatriculas(MatriculaRepository matriculaRepository, IGeradorRelatorio gerador) {
		this.matriculaRepository = matriculaRepository;
		this.gerador = gerador;
	}
	
	public void gerarMatriculasDeAluno(Aluno aluno) {
		List<Matricula> matriculasDoAluno = matriculaRepository.encontrarPorAluno(aluno);
		
		if (matriculasDoAluno == null) {
			return;
		}
		
		String[] headers = {
				"Aluno",
				"Disciplina",
				"Semestre",
		};
		
		List<String> dados = new ArrayList<>();
		for (Matricula m : matriculasDoAluno) {
			List<String> infoMatriculas = Arrays.asList(
											m.getAluno().getNome(),
											m.getDisciplina().getNome(),
											m.getSemestre());
			
			dados.add(String.join(";", infoMatriculas));
		}
		
		gerador.armazenar(headers, dados, TipoRelatorio.ALUNOS_MATRICULADOS);
	}
	
//	public void gerarMatriculas() {
//
//	}

}
