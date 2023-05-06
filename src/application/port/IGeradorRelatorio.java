package application.port;

import java.util.List;

import application.TipoRelatorio;

public interface IGeradorRelatorio {
	public void armazenar(String[] colunas, List<String> dados, TipoRelatorio tipo);
}

