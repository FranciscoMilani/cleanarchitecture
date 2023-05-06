package domain.repositories;

import java.util.List;

import domain.AtividadeComplementar;
import domain.enums.TipoAtividade;

public interface AtividadeComplementarRepository extends BaseRepository<AtividadeComplementar> {
	
//	void salvar(AtividadeComplementar atv);
//	
//	AtividadeComplementar criar(AtividadeComplementar atv);
//	
//	List<AtividadeComplementar> encontrarTodos();
	
	List<AtividadeComplementar> encontrarPorTipo(TipoAtividade tipo);
	
}
