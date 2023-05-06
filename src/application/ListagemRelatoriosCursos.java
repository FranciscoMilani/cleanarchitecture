package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.port.IGeradorRelatorio;
import domain.Curso;
import domain.repositories.CursoRepository;

public class ListagemRelatoriosCursos {
	
	private IGeradorRelatorio gerador;
	private CursoRepository cursoRepository;

	public ListagemRelatoriosCursos(CursoRepository cursoRepository, IGeradorRelatorio gerador) {
		this.cursoRepository = cursoRepository;
		this.gerador = gerador;
	}
	
	public void gerar() {
		List<Curso> cursos = cursoRepository.encontrarTodos();
		
		if (cursos == null) {
			System.out.println("Não há cursos. Saída não será gerada.");
			return;
		}
		
		String[] headers = {
				"Código",
				"Tipo",
				"Nome",
				"Carga Horária",
				"Cód. Currículo"
		};
		
		List<String> dados = new ArrayList<>();
		for (Curso c : cursos) {
			List<String> infoCurso = Arrays.asList(
									c.getCodigo(),
									c.getTipo().toString(),
									c.getNome());
			
			dados.add(String.join(";", infoCurso));
		}
		
		gerador.armazenar(headers, dados, TipoRelatorio.CURSOS);
	}

}
