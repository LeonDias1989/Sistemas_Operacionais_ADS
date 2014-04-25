package OrdemDePrioridade;


import java.util.LinkedList;

import util.Processo;

/**
 * 
 * @author Leon Dias
 * 
 */
public class Prioridade {

	private LinkedList<Processo> listaDeProcessos = new LinkedList<>();
	static int tempoCorrente = 0, maiorPrioridade = -1, totalDeProcessos = 0;

	public LinkedList<Processo> getLisaDeProcessos() {
		return listaDeProcessos;
	}

	public Processo adicionarProcesso(Processo novoProcesso) {

		if (listaDeProcessos.isEmpty()
				&& novoProcesso.getTempoDeChegada() < tempoCorrente) {

			listaDeProcessos.addFirst(novoProcesso);
			tempoCorrente += novoProcesso.getTempoDeChegada();
			totalDeProcessos++;
		} else if (novoProcesso.getTempoDeChegada() <= tempoCorrente
				&& novoProcesso.getPrioridade() > maiorPrioridade) {

			listaDeProcessos.addFirst(novoProcesso);
			tempoCorrente += novoProcesso.getTempoDeChegada();
			maiorPrioridade = novoProcesso.getPrioridade();
			totalDeProcessos++;
		} else {

			listaDeProcessos.addLast(novoProcesso);
			tempoCorrente += novoProcesso.getTempoDeChegada();
			maiorPrioridade = novoProcesso.getPrioridade();
			totalDeProcessos++;
		}
		return novoProcesso;
	}
	


	public void removerProcesso() {

		listaDeProcessos.removeFirst();
	}

}
