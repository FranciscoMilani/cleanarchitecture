package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Disciplina;
import domain.repositories.DisciplinaRepository;

public class InMemoryDisciplinaRepository implements DisciplinaRepository {

	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@Override
	public Disciplina criar(Disciplina disciplina) {
		disciplinas.add(disciplina);
		return disciplina;
	}

	@Override
	public List<Disciplina> encontrarTodos() {
		return disciplinas;
	}

	@Override
	public Disciplina encontrarPorSigla(String sigla) {
		String siglaNova = sigla.trim().toLowerCase();
		
		Disciplina d = disciplinas.stream()
		.filter(disciplina -> disciplina.getSigla().trim().toLowerCase().equals(siglaNova))
		.findFirst()
		.orElse(null);

		return d;
	}

	@Override
	public void salvar(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

}
