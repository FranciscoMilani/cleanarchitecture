package infrastructure.adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import application.TipoRelatorio;
import application.port.IGeradorRelatorio;

public class ArmazenarArquivoTxt implements IGeradorRelatorio{

	
	@Override
	public void armazenar(String[] colunas, List<String> dados, TipoRelatorio tipo) {
		
		Path p = Paths.get(System.getProperty("user.dir"));
    	p = p.resolve(tipo.toString() + "_" + Instant.now().toEpochMilli() + ".txt");
    	
		File file = p.toFile();
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
				
			for (String col : colunas) {
				fr.write(String.format("%s;", col));
			}
			
			for (String dado : dados) {
				fr.write("\n"+dado);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
