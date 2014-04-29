package Circular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Processo;
import util.ProcessoComparator;
import util.ProcessoTipoOrdenacao;
import util.Scan;

public class Circular {
	int maiorPrioridade = -1;
	int tempoCorrente = 0;
	int quantum = 2;

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

	public List<Processo> ordenarPorChegada() {
		Collections.sort(filaProcessos, new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_CHEGADA));
		return filaProcessos;
	}

	public List<Processo> ordenarPorDuracao() {
		Collections.sort(filaProcessos, new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_DURACAO));
		return filaProcessos;
	}

	public boolean todosProcessosFinalizados() {
		boolean retorno = true;

		for (Processo proc : filaProcessos) {
			// se um nao acabou sempre fica false e retorna false.
			retorno &= proc.isAcabou();
		}

		return retorno;
	}

	public Processo getProximoProcessoAExecutar() {
		if (todosProcessosFinalizados()) {
			return null;
		}

		// ordena pela maior prioridade
		Collections.sort(filaProcessos, new ProcessoComparator(ProcessoTipoOrdenacao.PRIORIDADE, false));

		Processo processo = filaProcessos.get(0);
		ArrayList<Processo> prioridadesIguais = new ArrayList<Processo>();
		prioridadesIguais.add(processo);

		for (Processo proc : filaProcessos) {
			if (processo.getPrioridade() == proc.getPrioridade()) {
				prioridadesIguais.add(proc);
			}
		}

		if (!prioridadesIguais.isEmpty()) {
			// ordena pelo menor tempo de chegada
			Collections.sort(prioridadesIguais, new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_CHEGADA));
			processo = prioridadesIguais.get(0);
		}

		return processo;
	}

	public void executaProcessos() throws Exception {
		System.out.println("----------------------------");
		Processo processo = getProximoProcessoAExecutar();

		if (processo == null) {
			System.out.println("\n\nfim");
			return;
		}

		System.out.println("Executando processo " + processo.getName() + "...");
		Thread.sleep(1000 * 1);
		System.out.println("..");
		Thread.sleep(1000 * 1);

		processo.setTempoDuracao(processo.getTempoDuracao() - quantum);
		processo.setPrioridade(processo.getPrioridade() - 1);

		System.out.println("restando " + processo.getTempoDuracao()+" -> "+processo);

		if (processo.getTempoDuracao() <= 0) {
			processo.setAcabou(true);
			processo.setPrioridade(0);
		}

		executaProcessos();
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Quantos Processo Deseja Executar?");
		System.out.println("-------------");
		Scan teclado = new Scan();
		Circular circular = new Circular();

		// Chose number of process that execute
		int numeroProcesso = teclado.scanInt();

		// Chose Process
		for (int i = 0; i < numeroProcesso; i++) {
			System.out.println("-------------");

			String nome = "Processo-" + i;
			System.out.println("Criando " + nome);
			int tempoExecucao = teclado.scanInt("Tempo de Execucao: ");
			int prioridadeDoProcesso = teclado.scanInt("Prioridade: ");

			circular.adicionar(new Processo(nome, circular.getFilaProcessos().size() + 1, tempoExecucao, prioridadeDoProcesso));

			System.out.println(nome + " criado com sucesso !\n\n");
		}

		System.out.println("\n\nColocando os processo na fila de execução.");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print("..\n\n\n\n\n\n\n\n");

		circular.executaProcessos();
	}

}
