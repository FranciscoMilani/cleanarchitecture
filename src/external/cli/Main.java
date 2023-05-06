package external.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import application.CadastrarAluno;
import application.CriarCurso;
import application.CriarDisciplina;
import application.ListagemRelatoriosAlunos;
import application.ListagemRelatoriosCursos;
import application.ListagemRelatoriosDisciplinas;
import application.ListagemRelatoriosMatriculas;
import application.MatricularAlunoDisciplina;
import domain.Aluno;
import domain.CurriculoCurso;
import domain.Curso;
import domain.Disciplina;
import domain.enums.TipoCurso;
import domain.repositories.DisciplinaRepository;
import infrastructure.adapter.ArmazenarArquivoCsv;
import infrastructure.adapter.ArmazenarArquivoTxt;
import infrastructure.adapter.ValidarEmail;
import infrastructure.controller.AlunoController;
import infrastructure.controller.CursoController;
import infrastructure.controller.DisciplinaController;
import infrastructure.controller.MatriculaController;
import infrastructure.controller.RelatoriosController;
import infrastructure.repositories.InMemoryAlunoRepository;
import infrastructure.repositories.InMemoryCursoRepository;
import infrastructure.repositories.InMemoryDisciplinaRepository;
import infrastructure.repositories.InMemoryMatriculaRepository;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	// repositories
	InMemoryAlunoRepository alunoRepository = new InMemoryAlunoRepository();
	InMemoryMatriculaRepository matriculaRepository = new InMemoryMatriculaRepository();
	InMemoryDisciplinaRepository disciplinaRepository = new InMemoryDisciplinaRepository();
	InMemoryCursoRepository cursoRepository = new InMemoryCursoRepository();
	
	// adapters
	ValidarEmail validador = new ValidarEmail();
	//ArmazenarArquivoCsv gerador = new ArmazenarArquivoCsv();
	ArmazenarArquivoTxt gerador = new ArmazenarArquivoTxt();
	
	// use cases
	CadastrarAluno ca = new CadastrarAluno(alunoRepository, validador);
	CriarDisciplina cd = new CriarDisciplina(disciplinaRepository);
	CriarCurso cc = new CriarCurso(cursoRepository);
	MatricularAlunoDisciplina mad = new MatricularAlunoDisciplina(matriculaRepository, alunoRepository, disciplinaRepository);
	
	ListagemRelatoriosAlunos lra = new ListagemRelatoriosAlunos(alunoRepository, gerador);
	ListagemRelatoriosCursos lrc = new ListagemRelatoriosCursos(cursoRepository, gerador);
	ListagemRelatoriosDisciplinas lrd = new ListagemRelatoriosDisciplinas(disciplinaRepository, gerador, cursoRepository);
	ListagemRelatoriosMatriculas lrm = new ListagemRelatoriosMatriculas(matriculaRepository, gerador);
	
	// controllers
	AlunoController alunoController = new AlunoController(ca);
	CursoController cursoController = new CursoController(cc, disciplinaRepository);
	DisciplinaController disciplinaController = new DisciplinaController(cd, disciplinaRepository);
	MatriculaController matriculaController = new MatriculaController(mad, alunoRepository, disciplinaRepository);
	RelatoriosController relatoriosController = new RelatoriosController(lra, lrc, lrd, lrm, alunoRepository, cursoRepository);
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.cadastroPrevio();
		main.mostraMenu();
	}
	
	private void cadastroPrevio() {	
		// alunos
		Aluno aluno = new Aluno(1, "Francisco", "ffmilani@ucs.br", "ffmilani123");
		Aluno aluno2 = new Aluno(2, "Luiz Augusto", "lafmilani@ucs.br", "lafmilani123");
		Aluno aluno3 = new Aluno(3, "Pedro Henrique Costa", "phcosta@ucs.br", "phcosta123");
		Aluno aluno4 = new Aluno(4, "Bruno Afonso", "ba5@ucs.br", "ba5123");
		
		alunoController.cadastraAluno(aluno);
		alunoController.cadastraAluno(aluno2);
		alunoController.cadastraAluno(aluno3);
		alunoController.cadastraAluno(aluno4);
		
		
		//disciplinas
		Disciplina disciplina = new Disciplina("Projeto e Arquitetura", "FBI4016D", 4, 80, null);
		Disciplina disciplina2 = new Disciplina("Programação Web 2", "FBI1234", 4, 80, null);
		Disciplina disciplina3 = new Disciplina("Disciplina X", "ABC1473T", 2, 40, List.of(disciplina, disciplina2));
		Disciplina disciplina4 = new Disciplina("Disciplina Z", "ZEY17E5R", 1, 20, null);
		
		disciplinaController.criaDisciplina(disciplina);
		disciplinaController.criaDisciplina(disciplina2);
		disciplinaController.criaDisciplina(disciplina3);
		disciplinaController.criaDisciplina(disciplina4);	
		
		
		List<Disciplina> curriculoAds = new ArrayList<>(Arrays.asList(disciplina, disciplina2, disciplina3));
		List<Disciplina> curriculoPos = new ArrayList<>(Arrays.asList(disciplina4));
		
		// cursos e curriculos
		Curso cursoAds = new Curso("GRA013146", "Análise e Desenvolvimento de Sistemas", 2100, curriculoAds, TipoCurso.GRADUACAO);
		Curso cursoPos = new Curso("POS123456", "Curso Pós Graduação", 500, curriculoPos, TipoCurso.POS_GRADUACAO);
		
		
		
		
//		CurriculoCurso curriculoAds = new CurriculoCurso(cursoAds, 5, 2100, 
//														new ArrayList<>(Arrays.asList(disciplina, 
//																					  disciplina2, 
//																					  disciplina3)));
//		
//		CurriculoCurso curriculoPos = new CurriculoCurso(cursoPos, 5, 500,
//														new ArrayList<>(Arrays.asList(disciplina4)));
		
		
		cursoAds.setCurriculo(curriculoAds);
		cursoPos.setCurriculo(curriculoPos);

		cursoController.criaCurso(cursoAds);
		cursoController.criaCurso(cursoPos);
	}
	
	private void mostraMenu() {
		String opcao = null;

		do {
			System.out.println(
					"\n\n\nGestão Universitária:"
					+ "\n======================================================================="
					+ "\n[1] - Cadastro de aluno"
					+ "\n[2] - Criar um curso"
					+ "\n[3] - Criar uma disciplina"
					+ "\n[4] - Matricular aluno em disciplina"
					+ "\n[5] - Relatório de alunos cadastrados"
					+ "\n[6] - Relatório de cursos cadastrados"
					+ "\n[7] - Relatório de disciplinas cadastradas"
					+ "\n[8] - Relatório de matriculas de um aluno"
					+ "\n[9] - Relatório de disciplinas de um curso"
					+ "\n\n[x] - SAIR"
					+ "\n=======================================================================");
			
			opcao = scan.nextLine();
			
			try {
				switch(opcao) {
					case "1":
						cadastraAluno();
						break;
					case "2":
						cadastraCurso();
						break;
					case "3":
						cadastraDisciplina();
						break;
					case "4":
						matriculaAluno();
						break;
					case "5":
						relatoriosController.mostraAlunos();
						break;
					case "6":
						relatoriosController.mostraCursos();
						break;
					case "7":
						relatoriosController.mostraDisciplinas();
						break;
					case "8":
						System.out.println("RA do aluno:" );
						int ra = Integer.parseInt(scan.nextLine());
						relatoriosController.mostraMatriculas(ra);
						break;
					case "9":
						System.out.println("Código do curso:" );
						String cod = scan.nextLine();
						relatoriosController.mostraDisciplinasDoCurso(cod);
						break;
					case "x":
						System.out.println("Finalizado");
						System.exit(0);
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				//System.out.println(e.getClass() + " " + e.getMessage());
			}
			
		} while (!opcao.equals("x"));

		
		scan.close();
	}
	
	private void cadastraAluno() {
		System.out.println("RA:");
		int ra = Integer.parseInt(scan.nextLine());
		System.out.println("Nome:");
		var nome = scan.nextLine();
		System.out.println("E-mail:");
		var email = scan.nextLine();
		System.out.println("Senha:");
		var senha = scan.nextLine();
		
		Aluno aluno = new Aluno(ra, nome, email, senha);				
		alunoController.cadastraAluno(aluno);
	}
	
	private void cadastraCurso() {
		System.out.println("Codigo:");
		String codCurso = scan.nextLine();
		System.out.println("Nome:");
		String nomeCurso = scan.nextLine();
		System.out.println("Carga horária:");
		int cargaHoraria = Integer.parseInt(scan.nextLine());
		
		
		System.out.println( "[0] Extensão"
						  + "\n[1] Graduação"
						  + "\n[2] Pós-Graduação" );
		
		int indiceCurso = Integer.parseInt(scan.nextLine());
		TipoCurso tipo = TipoCurso.values()[indiceCurso];
		
		System.out.println("Sigla das disciplinas, separadas por vírgula:");
		String curriculo = scan.nextLine();
		
		Curso curso = new Curso(codCurso, nomeCurso, cargaHoraria, null, tipo);				
		cursoController.criaCurso(curso, curriculo);				
	}
	
	private void cadastraDisciplina() {
		System.out.println("Nome:");
		String nome = scan.nextLine();
		System.out.println("Sigla:");
		String sigla = scan.nextLine();
		System.out.println("Créditos:");
		int creditos = Integer.parseInt(scan.nextLine());
		System.out.println("Carga Horária:");
		int cargaHoraria = Integer.parseInt(scan.nextLine());
		System.out.println("Sigla dos pré-requisitos, separados por vírgula:");
		String requisitos = scan.nextLine();
		
		Disciplina disc = new Disciplina(nome, sigla, creditos, cargaHoraria, null);				
		disciplinaController.criaDisciplina(disc, requisitos);
	}
	
	private void matriculaAluno() {
		System.out.println("RA do aluno:");
		int ra = Integer.parseInt(scan.nextLine());
		System.out.println("Sigla da Disciplina:");
		String sigla = scan.nextLine();
		System.out.println("Semestre:");
		String semestre = scan.nextLine();
		
		matriculaController.matriculaAluno(ra, sigla, semestre);
	}
}
