package org.serratec.app;

import org.serratec.service.Leitura;

public class Programa {
	public static void main(String[] args) {
		String caminhoArquivo = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\entrada.csv";
		Leitura leitura = new Leitura(caminhoArquivo);

		for (Funcionario funcionario : leitura.getFuncionarios()) {
			System.out.println(funcionario + "\n");
		}
	}
}
