package domain.repositories;

import java.util.List;

import domain.CurriculoCurso;
import domain.Curso;
import domain.enums.TipoCurso;

public interface CursoRepository extends BaseRepository<Curso> {
	
//	void salvar(Curso curso);
//	
//	Curso criar(Curso curso);
//	
//	List<Curso> encontrarTodos();
	
	Curso encontrarPorCodigo(String codigo);
	
	List<Curso> encontrarPorTipo(TipoCurso tipo);
}
