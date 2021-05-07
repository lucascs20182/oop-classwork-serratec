package org.serratec.app;

import org.serratec.entidades.Funcionario;
import org.serratec.service.Leitor;

public class Programa {
	public static void main(String[] args) {
		String caminhoArquivo = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\entrada.csv";
		Leitor leitura = new Leitor(caminhoArquivo);

		for (Funcionario funcionario : leitura.getFuncionarios()) {
			System.out.println(funcionario);
		}
	}
}
