package org.serratec.app;

import java.io.IOException;
import org.serratec.service.Leitora;
import org.serratec.service.Escritora;

public class Programa {
	public static void main(String[] args) {
		final String CAMINHO_DO_ARQUIVO = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\entrada.csv";
		
		Leitora leitura = new Leitora(CAMINHO_DO_ARQUIVO);
		Escritora escrita = new Escritora(leitura);
		
		try {
			escrita.escreveCsv();
			System.out.println("Arquivo gerado!");
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo.");
			e.printStackTrace();
		}
	}
}
