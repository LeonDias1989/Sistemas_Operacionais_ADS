package Sjf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Processo;
import util.ProcessoComparator;
import util.ProcessoTipoOrdenacao;
import util.Scan;

public class Sjf {
	
	static int tamanhoSjf = 0;
	static Scan scan = new Scan();
	static int tempoCorrente = 0;

	public static void main(String[] args) throws Exception {

		int quantidadeProcessosDesejados = scan
				.scanInt("Quantos processos deseja executar?");

		List<Processo> lista = new ArrayList();

		for (int i = 0; i < quantidadeProcessosDesejados; i++) {
			// obtendo informações dos processos
			lista.add(getProcess());
		}

		Collections.sort(lista, new ProcessoComparator(
				ProcessoTipoOrdenacao.TEMPO_DURACAO));

		System.out.println();
		System.out.println("Iniciando a execucao dos processos");
		System.out.println();

		for (Processo processo : lista) {
			System.out.println("executando o processo = " + processo);
			tempoCorrente+= processo.getTempoDuracao();
			Thread.sleep(processo.getTempoDuracao() * 1000);
			System.out.println("fim do processo = " + processo.getName() +"\nTempo Corrente: " +tempoCorrente);
		}
	}

	private static Processo getProcess() {
		tamanhoSjf++;

		Processo p = new Processo();

		System.out.println("informacaes do processo = " + tamanhoSjf);
		p.setName(scan.scanString("nome:"));
		p.setTempoDeChegada(scan.scanInt("tempo chegada(em segundos):"));
		p.setTempoDuracao(scan.scanInt("tempo Duracao(em segundos):"));

		return p;
	}

}