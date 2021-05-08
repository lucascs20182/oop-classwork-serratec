package org.serratec.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.serratec.models.Funcionario;

public class Escritora {
	private final String CAMINHO_DO_ARQUIVO = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\saida.csv";
	private Leitora entrada;

	public Escritora(Leitora entrada) {
		this.entrada = entrada;
	}

	public void escreveCsv() throws IOException {

		FileWriter csvWriter = new FileWriter(CAMINHO_DO_ARQUIVO);

		for (Funcionario funcionario : entrada.getFuncionarios()) {
			String[] atributos;
			List<String> linha;

			funcionario.calcularFinancas();

			atributos = funcionario.toString().split(";");
			linha = Arrays.asList(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4]);

			csvWriter.append(String.join(";", linha));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}
}
