package domain.repositories;

import java.util.List;

import domain.Disciplina;
import domain.Matricula;

public interface DisciplinaRepository extends BaseRepository<Disciplina> {
	
//	void salvar(Disciplina disciplina);
//	
//	Disciplina criar(Disciplina disciplina);
//	
//	List<Disciplina> encontrarTodos();	
	
	Disciplina encontrarPorSigla(String sigla);
	
}
