package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import application.port.IGeradorRelatorio;
import domain.Curso;
import domain.Disciplina;
import domain.repositories.CursoRepository;
import domain.repositories.DisciplinaRepository;

public class ListagemRelatoriosDisciplinas {
	
	private IGeradorRelatorio gerador;
	private DisciplinaRepository disciplinaRepository;
	private CursoRepository cursoRepository;

	public ListagemRelatoriosDisciplinas(DisciplinaRepository disciplinaRepository, IGeradorRelatorio gerador, CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
		this.disciplinaRepository = disciplinaRepository;
		this.gerador = gerador;
	}
	
	public void gerar() {
		List<Disciplina> disciplinas = disciplinaRepository.encontrarTodos();
		String[] headers = {
				"Sigla",
				"Nome",
				"Créditos",
				"Carga Horária",
				"Disciplinas"
		};
		
		List<String> dados = new ArrayList<>();
		
		for (Disciplina d : disciplinas) {	
			List<String> infoDisciplinas = new ArrayList<>(Arrays.asList(		
											d.getSigla(), 
											d.getNome(), 
											Integer.toString(d.getCreditos()),
											Integer.toString(d.getCargaHoraria())
											//d.getPreRequisitos().stream().map(Disciplina::getNome).toArray(String[]::new)
											));
			
			if (d.getPreRequisitos() != null) {
				String preReq = String.join(" - ", d.getPreRequisitos()
						.stream()
						.map(Disciplina::getNome)
						.collect(Collectors.toList())
						);	

				infoDisciplinas.add(preReq);
			}
			
			dados.add(String.join(";", infoDisciplinas));
		}
		
		gerador.armazenar(headers, dados, TipoRelatorio.DISCIPLINAS);
	}
	
	public void gerarDisciplinasDeUmCurso(String cod) {

		Curso curso = cursoRepository.encontrarPorCodigo(cod);
		List<Disciplina> disciplinas = curso.getCurriculo();

		String[] headers = {
				"Curso",
				"Sigla",
				"Nome",
				"Créditos",
				"Carga Horária",
		};
		
		List<String> dados = new ArrayList<>();
		for (Disciplina d : disciplinas) {	
			List<String> infoDisciplinas = new ArrayList<>(Arrays.asList(	
											curso.getCodigo(),
											d.getSigla(), 
											d.getNome(), 
											Integer.toString(d.getCreditos()),
											Integer.toString(d.getCargaHoraria())
											));
			
//			if (d.getPreRequisitos() != null) {
//				String preReq = String.join(" - ", d.getPreRequisitos()
//						.stream()
//						.map(Disciplina::getNome)
//						.collect(Collectors.toList())
//						);	
//
//				infoDisciplinas.add(preReq);
//			}
			
			dados.add(String.join(";", infoDisciplinas));
		}
		
		gerador.armazenar(headers, dados, TipoRelatorio.DISCIPLINAS);
	}
}
