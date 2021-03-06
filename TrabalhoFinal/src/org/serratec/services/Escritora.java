package org.serratec.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.serratec.interfaces.IEscritora;
import org.serratec.models.Funcionario;

public class Escritora implements IEscritora, AutoCloseable {
	private String caminhoArquivo;
	private Leitora entrada;
	private FileWriter csvFWriter;
	private BufferedWriter csvBWriter;

	public Escritora(Leitora entrada, String CAMINHO_ARQUIVO_SAIDA) {
		this.entrada = entrada;
		this.caminhoArquivo = CAMINHO_ARQUIVO_SAIDA;
	}

	public void escreverCsv() {

		try {
			this.csvFWriter = new FileWriter(caminhoArquivo);
			this.csvBWriter = new BufferedWriter(csvFWriter);

			for (Funcionario funcionario : entrada.getFuncionarios()) {
				this.gerarCsv(funcionario);
			}
		} catch (IOException e) {
			System.out.println("Falha ao escrever arquivo.");
		}
	}

	private void gerarCsv(Funcionario funcionario) throws IOException {
		funcionario.calcularFinancas();

		this.csvBWriter.append(funcionario.toString());
		this.csvBWriter.append("\n");
	}

	@Override
	public void close() {
		try {
			this.csvBWriter.flush();
			this.csvBWriter.close();
		} catch (IOException e) {
			System.out.println("Falha ao fechar leitora.");
		}
	}
}