package Circular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Processo;
import util.ProcessoComparator;
import util.ProcessoTipoOrdenacao;
import util.Scan;

public class Circular {
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

	public boolean todosProcessosFinalizados() {
		boolean retorno = true;

		for (Processo proc : filaProcessos) {
			// se um nao acabou sempre fica false e retorna false.
			retorno &= proc.isAcabou();
		}

		return retorno;
	}

	public Processo getProximoProcessoAExecutar() {
		//testo se na lista existentes nao estao todos finalizados
		if (todosProcessosFinalizados()) {
			return null;
		}

		// ordena pela maior prioridade
		Collections.sort(filaProcessos, new ProcessoComparator(ProcessoTipoOrdenacao.PRIORIDADE, false));

		//como ordenei de forma decrescente conforme o parametro false da classe ProcessoComparator diz
		//só preciso pegar o primeiro processo da lista que é o de maior prioridade.
		Processo processo = filaProcessos.get(0);
		ArrayList<Processo> prioridadesIguais = new ArrayList<Processo>();
		prioridadesIguais.add(processo);

		//verifico se existe mais algum de prioridade igual ao do encontrado
		for (Processo proc : filaProcessos) {
			if (processo.getPrioridade() == proc.getPrioridade()) {
				//guardo todos de mesma prioridade em uma lista
				prioridadesIguais.add(proc);
			}
		}

		//ordeno os de mesma prioridade pelo tempo de chegada e pego o primeiro
		if (!prioridadesIguais.isEmpty()) {
			// ordena pelo menor tempo de chegada
			Collections.sort(prioridadesIguais, new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_CHEGADA));
			processo = prioridadesIguais.get(0);
		}

		return processo;
	}

	public void executaProcessos() throws Exception {
		System.out.println("----------------------------");
		//pego o proximo processo a ser executado.
		Processo processo = getProximoProcessoAExecutar();

		//garantia de que quando todos processos forem concluidos o algoritmo ira finalizar aqui.
		if (processo == null) {
			System.out.println("\n\nfim");
			return;
		}

		
		System.out.println("Executando processo " + processo.getName() + "...");
		for (int i = 0; i < quantum; i++) {
			//esperando o quantum acabar
			Thread.sleep(1 * 1000);
		}

		//diminuo o tempo de duração pois ja executei um pouco do processo
		processo.setTempoDuracao(processo.getTempoDuracao() - quantum);
		//diminuo em 1 a prioridade	
		processo.setPrioridade(processo.getPrioridade() - 1);

		System.out.println("restando " + processo.getTempoDuracao() + " -> " + processo);

		//se tempo de duração acabou sinal que nao tme mais prioridade e que o procesos finalizou
		if (processo.getTempoDuracao() <= 0) {
			processo.setAcabou(true);
			processo.setPrioridade(0);
		}

		//manda executar novamente
		executaProcessos();
	}

	public static void main(String[] args) throws Exception {
		//Aqui tudo inicia
		System.out.println("Quantos Processo Deseja Executar?");
		System.out.println("-------------");
		//instancia a scan
		Scan teclado = new Scan();
		//instancia a classe circular
		Circular circular = new Circular();

		// solicita a quantidade de processos que ele vai executar
		int numeroProcesso = teclado.scanInt();

		// preenche a lista com os processo que ele deseja
		for (int i = 0; i < numeroProcesso; i++) {
			System.out.println("-------------");

			//fixo um nome aqui ppara facilitar os testes
			String nome = "Processo-" + i;
			//imprimo o nome do processo
			System.out.println("Criando " + nome);
			//solicito o tempo de execução desse processo
			int tempoExecucao = teclado.scanInt("Tempo de Execucao: ");
			//solicito a prioridade
			int prioridadeDoProcesso = teclado.scanInt("Prioridade: ");

			//adiciono na lista de processos
			circular.adicionar(new Processo(nome, circular.getFilaProcessos().size() + 1, tempoExecucao, prioridadeDoProcesso));

			System.out.println(nome + " criado com sucesso !\n\n");
		}

		//logs para ficar bonito o algoritmo.
		System.out.println("\n\nColocando os processo na fila de execução.");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print("..\n\n\n\n\n\n\n\n");

		//executo os processos
		circular.executaProcessos();
	}

}
