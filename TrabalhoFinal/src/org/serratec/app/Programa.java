package org.serratec.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.excecoes.CpfRepetidoException;
import org.serratec.excecoes.DependenteException;

public class Programa {
	public static void main(String[] args)
			throws NumberFormatException, IOException, CpfRepetidoException, DependenteException {
		String caminhoArquivo = "C:\\Users\\Residencia Note 13\\Desktop\\serratec_stuff\\requisitos\\entrada.csv";
		FileReader arquivo = null;

		try {
			arquivo = new FileReader(caminhoArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Formato errado de arquivo.");
			e.getMessage();
		}
		
		BufferedReader lerArquivo = new BufferedReader(arquivo);

		List<Funcionario> funcionarios = processarArquivo(lerArquivo);

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario + "\n");
		}
		
		arquivo.close();
		lerArquivo.close();
	}

	// escolher um nome melhor pra fun��o; talvez lerArquivo, transformarArquivoEmObjeto, sei l�... 
	public static List<Funcionario> processarArquivo(BufferedReader lerArquivo)
			throws IOException, NumberFormatException, CpfRepetidoException, DependenteException {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		List<Dependente> dependentesDeFuncionario = new ArrayList<Dependente>();
		Funcionario funcionario = null;
		Dependente dependente = null;
		TipoParentesco tipo = null;

		for (String linha = lerArquivo.readLine(); linha != null; linha = lerArquivo.readLine()) {
			String[] campo;
			int ano, mes, dia;

			if (linha.equals("")) {
				funcionarios.add(funcionario);
				dependentesDeFuncionario = new ArrayList<Dependente>();
				continue;
			}

			campo = linha.split(";");
			ano = Integer.parseInt(campo[2].substring(0, 4));
			mes = Integer.parseInt(campo[2].substring(4, 6));
			dia = Integer.parseInt(campo[2].substring(6, 8));

			switch (campo[3]) {
			case "FILHO":
				tipo = TipoParentesco.FILHO;
				break;
			case "SOBRINHO":
				tipo = TipoParentesco.SOBRINHO;
				break;
			case "OUTROS":
				tipo = TipoParentesco.OUTROS;
				break;
			default:
				break;
			}

			if (!(campo[3].equals("FILHO") || campo[3].equals("SOBRINHO") || campo[3].equals("OUTROS"))) {
				funcionario = new Funcionario(campo[0], campo[1], LocalDate.of(ano, mes, dia),
						Double.parseDouble(campo[3]), dependentesDeFuncionario);
			} else {
				dependente = new Dependente(campo[0], campo[1], LocalDate.of(ano, mes, dia), tipo);
				dependentesDeFuncionario.add(dependente);
			}
		}

		// adiciona �ltimo funcionario � lista de funcionarios
		funcionarios.add(funcionario);

		return funcionarios;
	}
}
