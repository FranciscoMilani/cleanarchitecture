package infrastructure.adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import application.TipoRelatorio;
import application.port.IGeradorRelatorio;

public class ArmazenarArquivoCsv implements IGeradorRelatorio {
    
	@Override
	public void armazenar(String[] colunas, List<String> dados, TipoRelatorio tipo) {
		 try {
	            FileWriter writer = new FileWriter(String.format("%s_%s.csv", tipo, Instant.now().toEpochMilli()));
	            CSVPrinter csvPrinterHeader = new CSVPrinter(writer, CSVFormat.EXCEL.withDelimiter(';'));
	            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL.withDelimiter(','));

	            // headers
	            csvPrinterHeader.printRecord((Object[]) colunas);
	            
	            // dados
	            csvPrinter.printRecords(dados);

	            csvPrinterHeader.close();
	            csvPrinter.close();
	        } catch (IOException e) {
	            System.out.println("Erro");
	            e.printStackTrace();
	        }
		
	}
}
