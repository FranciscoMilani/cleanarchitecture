package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Aluno;
import domain.repositories.AlunoRepository;

public class InMemoryAlunoRepository implements AlunoRepository {

	private List<Aluno> alunos = new ArrayList<>();

	@Override
	public Aluno criar(Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}

	@Override
	public List<Aluno> encontrarTodos() {
		return alunos;
	}

	@Override
	public Aluno encontrarPorRa(int ra) {
		return alunos.stream()
				.filter(aluno -> aluno.getRa() == ra)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void salvar(Aluno aluno) {
		alunos.add(aluno);
	}

}
