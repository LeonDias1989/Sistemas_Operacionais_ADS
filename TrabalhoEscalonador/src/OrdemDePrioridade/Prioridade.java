package OrdemDePrioridade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Processo;
import util.ProcessoComparator;
import util.ProcessoTipoOrdenacao;
import util.Scan;

/**
 * 
 * @author Leon Dias
 * 
 */
public class Prioridade {

	static int maiorPrioridade = -1, tempoCorrente = 0;

	private List<Processo> filaProcessos = new ArrayList<>();

	public List<Processo> getFilaProcessos() {
		return filaProcessos;
	}

	public Processo adicionar(Processo novoProcesso) {

		filaProcessos.add(novoProcesso);
		return novoProcesso;

	}

	public Processo remover(Processo processoARemover) {

		filaProcessos.remove(processoARemover);
		return processoARemover;
	}

	public List<Processo> ordenarProcessos() {
		Collections.sort(filaProcessos,new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_CHEGADA));
		return filaProcessos;
	}

	public Processo getMaiorPrioridade() {

		Processo auxiliar = null;

		for (Processo p : filaProcessos) {
			if (p.getPrioridade() > maiorPrioridade) {
				maiorPrioridade = p.getPrioridade();
				auxiliar = p;
			}
		}
		// Zero Priority
		maiorPrioridade = -1;
		// Get Current Time from the chose process
		tempoCorrente += auxiliar.getTempoDuracao();

		return auxiliar;
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Quantos Processo Deseja Executar?");

		Scan teclado = new Scan();
		Prioridade listaProcessos = new Prioridade();

		// Chose number of process that execute
		int numeroProcesso = teclado.scanInt();

		// Chose Process
		for (int i = 0; i < numeroProcesso; i++) {

			System.out.println("Nome do processo: ");
			String nome = teclado.scanString();

			System.out.println("Entrada do Processo: ");
			int entrada = teclado.scanInt();

			System.out.println("Tempo de Execu��o do Processo: ");
			int tempoExecucao = teclado.scanInt();

			System.out.println("Prioridade do Processo: ");
			int prioridadeDoProcesso = teclado.scanInt();

			listaProcessos.adicionar(new Processo(nome, entrada, tempoExecucao,
					prioridadeDoProcesso));
			
			System.out.println("Processo " +nome +" criado com sucesso !");
		}

		System.out.println("\n\nColocando os processo na fila de execu��o.");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print("..");

		while (listaProcessos.getFilaProcessos().size() > 0) {

			Processo auxiliar = listaProcessos.remover(listaProcessos
					.getMaiorPrioridade());

			System.out.println("\n\nExecutando processo " + auxiliar.getName()
					+ "...");
			Thread.sleep(1000 * auxiliar.getTempoDuracao());
			System.out.println("Processo " + auxiliar.getName()
					+ " executado em " + auxiliar.getTempoDuracao() + " segundos"
					+ "\nTempo Atual: " + tempoCorrente);

		}

	}

}
