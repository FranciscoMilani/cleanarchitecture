package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Aluno;
import domain.CurriculoCurso;
import domain.Curso;
import domain.enums.TipoCurso;
import domain.repositories.CursoRepository;

public class InMemoryCursoRepository implements CursoRepository{

	private List<Curso> cursos = new ArrayList<>();
	
	@Override
	public Curso criar(Curso curso) {
		cursos.add(curso);
		return curso;
	}

	@Override
	public List<Curso> encontrarTodos() {
		return cursos;
	}

	@Override
	public List<Curso> encontrarPorTipo(TipoCurso tipo) {
		return cursos.stream()
				.filter(curso -> curso.getTipo().equals(tipo))
				.collect(Collectors.toList());
	}


	@Override
	public Curso encontrarPorCodigo(String codigo) {
		String codigoNovo = codigo.trim().toLowerCase();

		return cursos.stream()
				.filter(curso -> curso.getCodigo().trim().toLowerCase().equals(codigoNovo))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void salvar(Curso curso) {
		cursos.add(curso);
	}

}
