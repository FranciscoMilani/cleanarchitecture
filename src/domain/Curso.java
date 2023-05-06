package domain;

import java.util.List;

import domain.enums.TipoCurso;

public final class Curso {
	
	private String codigo;
	private String nome;
	private int cargaHoraria;
	private List<Disciplina> curriculo;
	private TipoCurso tipo;
	
	public Curso(String codigo, String nome, int cargaHoraria, List<Disciplina> curriculo, TipoCurso tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.curriculo = curriculo;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Disciplina> getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(List<Disciplina> curriculo) {
		this.curriculo = curriculo;
	}
	
	public void addDisciplina(Disciplina d) {
		this.curriculo.add(d);
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", curriculo=");
		builder.append(curriculo);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
}
