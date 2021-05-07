package org.serratec.app;

import java.time.LocalDate;
import org.serratec.excecoes.CpfRepetidoException;
import java.util.List;

public class Funcionario extends Pessoa {
	private double salarioBruto;
	private double descontoInss;
	private double descontoIR;
	private double salarioLiquido;
	private List<Dependente> dependentes;
	private double deducaoDependentes;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto,
			List<Dependente> dependentes) throws CpfRepetidoException {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	public double calculaSalarioLiquido() {
		System.out.println(this.descontoInss);
		System.out.println(this.deducaoDependentes);
		System.out.println(this.descontoIR);
		return this.salarioLiquido = this.salarioBruto - this.descontoInss - this.descontoIR;
	}

	public double calculaDescontoInss() {
		if(this.salarioBruto <= 1100) {
			return descontoInss = this.salarioBruto * 7.5 / 100;
		} else if(this.salarioBruto <= 2203.48) {
			return descontoInss = (this.salarioBruto * 9 / 100) - 16.5;
		} else if(this.salarioBruto <= 3305.22) {
			return descontoInss = (this.salarioBruto * 12 / 100) - 82.61;
		} else if(this.salarioBruto <= 6433.57) {
			return descontoInss = (this.salarioBruto * 14 / 100) - 148.72;
		} else {
			return descontoInss = 751.97;
		}
	}
	
	public double calculaDeducaoDependentes() {
		return this.deducaoDependentes = this.dependentes.size() * 189.59;
	}
	
	public double calculaDescontoIR() {
		double descontoIR = this.salarioBruto - this.deducaoDependentes - this.descontoInss;
		
		if(descontoIR <= 1903.98) {
			return this.descontoIR;
		} else if(descontoIR <= 2826.65) {
			return this.descontoIR = (descontoIR * 7.5 / 100) - 142.80;
		} else if(descontoIR <= 3751.05) {
			return this.descontoIR = (descontoIR * 15 / 100) - 354.80;
		} else if(descontoIR <= 4664.68) {
			return this.descontoIR = (descontoIR * 22.5 / 100) - 636.13;
		} else {
			return this.descontoIR = (descontoIR * 27.5 / 100) - 869.36;
		}
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", salarioBruto="
				+ salarioBruto + ", salarioLiquido=" + salarioLiquido + ", dependentes=" + dependentes + "]";
	}
}
