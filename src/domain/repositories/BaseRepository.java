package domain.repositories;

import java.util.List;

public interface BaseRepository<T> {
	
	public void salvar(T tipo);
	
	public T criar(T tipo);
	
	public List<T> encontrarTodos();
}
