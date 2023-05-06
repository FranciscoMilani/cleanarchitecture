package domain.repositories;

import domain.Aluno;

public interface AlunoRepository extends BaseRepository<Aluno> {

	Aluno encontrarPorRa(int ra);
}
