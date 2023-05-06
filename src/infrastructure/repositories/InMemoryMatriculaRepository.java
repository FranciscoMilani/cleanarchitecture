package infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Aluno;
import domain.Disciplina;
import domain.Matricula;
import domain.repositories.MatriculaRepository;

public class InMemoryMatriculaRepository implements MatriculaRepository 
{
	private List<Matricula> matriculas = new ArrayList<>();

	@Override
	public Matricula criar(Matricula matricula) {
		matriculas.add(matricula);
		return matricula;
	}

	@Override
	public void salvar(Matricula matricula) {
		matriculas.add(matricula);		
	}

	@Override
	public List<Matricula> encontrarPorAluno(Aluno aluno) {
		return matriculas.stream()
			  .filter(mat -> mat.getAluno().getRa() == aluno.getRa())
			  .collect(Collectors.toList());
	}
	
	@Override
	public List<Matricula> encontrarPorAlunoRa(int ra) {
		return matriculas.stream()
			  .filter(mat -> mat.getAluno().getRa() == ra)
			  .collect(Collectors.toList());
	}

	@Override
	public Matricula encontrarPorAlunoDisciplina(Aluno aluno, Disciplina disciplina) {
		Matricula matricula = matriculas.stream()
			    .filter(m -> (m.getAluno().getRa() == aluno.getRa()) &&
			    			  m.getDisciplina().getSigla().equals(disciplina.getSigla()))
			    .findFirst()
			    .orElse(null);
		
		return matricula;
	}

	@Override
	public List<Matricula> encontrarTodos() {
		return matriculas;
	}

}
