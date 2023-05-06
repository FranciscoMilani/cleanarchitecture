package domain;

import domain.enums.TipoAtividade;

public final class AtividadeComplementar {
	private String nome;
	private int cargaHoraria;
	private TipoAtividade tipoAtividade;
	
	public AtividadeComplementar(String nome, TipoAtividade tipo, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.tipoAtividade = tipo;
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
	
	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}
	
	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
}
