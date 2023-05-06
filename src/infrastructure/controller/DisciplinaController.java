package infrastructure.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.CriarDisciplina;
import domain.Disciplina;
import domain.repositories.DisciplinaRepository;

public class DisciplinaController {
	
	private CriarDisciplina casoDeUso;
	private DisciplinaRepository repo;
	
	public DisciplinaController(CriarDisciplina casoDeUso, DisciplinaRepository repo) {
		this.casoDeUso = casoDeUso;
		this.repo = repo;
	}
	
	public void criaDisciplina(Disciplina disciplina) {
		casoDeUso.criarDisciplina(disciplina);
	}
	
	public void criaDisciplina(Disciplina disciplina, String preReqs) {
		// mapeia requisitos inseridos para a disciplina
		List<String> requisitosList = Arrays.asList(preReqs.split(","));
		
		List<Disciplina> disc = new ArrayList<>();
		for(String req : requisitosList) {
			Disciplina d = repo.encontrarPorSigla(req);
			if (d != null) {
				disc.add(d);
			}
		}
		
		disciplina.setPreRequisitos(disc);
		casoDeUso.criarDisciplina(disciplina);
	}
}
