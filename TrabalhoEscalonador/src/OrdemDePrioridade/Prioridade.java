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

		if (listaDeProcessos.isEmpty()) {

			listaDeProcessos.addFirst(novoProcesso);
			tempoCorrente += novoProcesso.getTime();
			totalDeProcessos++;
		} else if (novoProcesso.getPrioridade() > maiorPrioridade) {

			listaDeProcessos.addFirst(novoProcesso);
			tempoCorrente += novoProcesso.getTime();
			maiorPrioridade = novoProcesso.getPrioridade();
			totalDeProcessos++;
		} else {

			listaDeProcessos.addLast(novoProcesso);
			tempoCorrente += novoProcesso.getTime();
			maiorPrioridade = novoProcesso.getPrioridade();
			totalDeProcessos++;
		}
		return novoProcesso;
	}
	


	public void removerProcesso() {

		listaDeProcessos.removeFirst();
	}

}
