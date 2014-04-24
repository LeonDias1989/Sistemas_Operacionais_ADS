package OrdemDePrioridade;

import util.Processo;

public class App {

	public static void main(String[] args) {

		OrdemDePrioridade ordemDePrioridade = new OrdemDePrioridade();

		int tempoAtual = 0, menorTempoChegada = 999999999, maiorPrioridade = -1;

		Processo a = new Processo("A", 0, 3, 3);
		Processo b = new Processo("B", 0, 2, 4);
		Processo c = new Processo("C", 1, 5, 1);
		Processo d = new Processo("D", 2, 1, 2);

		ordemDePrioridade.addProcess(a);
		ordemDePrioridade.addProcess(b);
		ordemDePrioridade.addProcess(c);
		ordemDePrioridade.addProcess(d);

		Processo processoEleito = null;

		for (Processo processo : ordemDePrioridade.getLisaDeProcessos()) {

			if (processo.getTempoDeChegada() <= menorTempoChegada
					&& processo.getPrioridade() > maiorPrioridade) {

				maiorPrioridade = processo.getPrioridade();
				menorTempoChegada = processo.getTempoDeChegada();
				processoEleito = processo;

			}

		}

		System.out.println(processoEleito);

	}

}
