package domain.repositories;

import java.util.List;

import domain.Aluno;
import domain.Disciplina;
import domain.Matricula;

public interface MatriculaRepository extends BaseRepository<Matricula> {
	
//	Matricula criar(Matricula matricula);
//
//	void salvar(Matricula matricula);
	
	List<Matricula> encontrarPorAluno(Aluno aluno);
	
	List<Matricula> encontrarPorAlunoRa(int ra);
	
	Matricula encontrarPorAlunoDisciplina(Aluno aluno, Disciplina disciplina);

}
