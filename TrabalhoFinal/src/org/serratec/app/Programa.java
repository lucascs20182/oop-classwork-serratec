package org.serratec.app;

//import org.serratec.entidades.Funcionario;
import org.serratec.service.Leitor;

public class Programa {
	public static void main(String[] args) {
		String caminhoArquivo = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\entrada.csv";
		Leitor leitura = new Leitor(caminhoArquivo);

		// temp: pro output ficar igual o ex. do professor
		for (int i = leitura.getFuncionarios().size() - 1; i >= 0; i--) {
			leitura.getFuncionarios().get(i).calcularSalarioLiquido();
			System.out.println(leitura.getFuncionarios().get(i));
		}

		/*
		 * for (Funcionario funcionario : leitura.getFuncionarios()) {
		 * funcionario.calcularSalarioLiquido(); System.out.println(funcionario); }
		 */
	}
}
