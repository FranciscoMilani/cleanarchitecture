package application;

import domain.Aluno;
import domain.AtividadeComplementar;
import domain.repositories.AtividadeComplementarRepository;

public class CadastrarAtividadeAluno {
	
	private AtividadeComplementarRepository atvRepository;
	
	public CadastrarAtividadeAluno(AtividadeComplementarRepository atvRepository) {	
		this.atvRepository = atvRepository;
	}
	
	public void cadastraAtividade(AtividadeComplementar atv, Aluno aluno) {	
		
		var atvs = aluno.getAtividadesRealizadas();	
		for (AtividadeComplementar a : atvs) {
			if (a.getNome().equals(atv.getNome())) {
				return;
			}
		}
		
		aluno.addAtividadeComplementar(atv);
	}
}
