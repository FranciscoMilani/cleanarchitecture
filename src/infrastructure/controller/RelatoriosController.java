package infrastructure.controller;

import application.ListagemRelatoriosAlunos;
import application.ListagemRelatoriosCursos;
import application.ListagemRelatoriosDisciplinas;
import application.ListagemRelatoriosMatriculas;
import domain.Aluno;
import domain.Curso;
import domain.repositories.AlunoRepository;
import domain.repositories.CursoRepository;

public class RelatoriosController {
	
	private ListagemRelatoriosAlunos casoAluno;
	private ListagemRelatoriosCursos casoCurso;
	private ListagemRelatoriosDisciplinas casoDisciplina;
	private ListagemRelatoriosMatriculas casoMatricula;
	private AlunoRepository alunoRepo;
	private CursoRepository cursoRepo;
	
	public RelatoriosController( ListagemRelatoriosAlunos casoAluno, 
								 ListagemRelatoriosCursos casoCurso,
								 ListagemRelatoriosDisciplinas casoDisciplina,
								 ListagemRelatoriosMatriculas casoMatricula,
								 AlunoRepository alunoRepo,
								 CursoRepository cursoRepo) {
		
		this.casoAluno = casoAluno;
		this.casoCurso = casoCurso;
		this.casoDisciplina = casoDisciplina;
		this.casoMatricula = casoMatricula;
		this.alunoRepo = alunoRepo;
		this.cursoRepo = cursoRepo;
	}
	
	
	public void mostraAlunos() {
		casoAluno.gerar();
	}
	
	public void mostraCursos() {
		casoCurso.gerar();
	}
	
	public void mostraDisciplinas() {
		casoDisciplina.gerar();
	}
	
	public void mostraMatriculas(int ra) {
		Aluno aluno = alunoRepo.encontrarPorRa(ra);
		casoMatricula.gerarMatriculasDeAluno(aluno);
	}
	
	public void mostraDisciplinasDoCurso(String cod) {
		casoDisciplina.gerarDisciplinasDeUmCurso(cod);
	}
}
