package infrastructure.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.CriarCurso;
import domain.Curso;
import domain.Disciplina;
import domain.repositories.DisciplinaRepository;

public final class CursoController {
	private CriarCurso casoDeUso;
	private DisciplinaRepository repo;
	
	public CursoController(CriarCurso casoDeUso, DisciplinaRepository repo) {
		this.casoDeUso = casoDeUso;
		this.repo = repo;
	}
	
	public void criaCurso(Curso curso) {
		casoDeUso.criarCurso(curso);
	}
	
	public void criaCurso(Curso curso, String curriculo) {
		List<String> requisitosList = Arrays.asList(curriculo.split(","));
		
		List<Disciplina> disc = new ArrayList<>();
		for(String req : requisitosList) {
			Disciplina d = repo.encontrarPorSigla(req);
			if (d != null) {
				disc.add(d);
			}
		}
		
		curso.setCurriculo(disc);
		casoDeUso.criarCurso(curso);
	}
}
