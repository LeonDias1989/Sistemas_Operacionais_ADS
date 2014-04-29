package Sjf;

import java.util.Collections;
import java.util.LinkedList;

import util.Processo;
import util.ProcessoComparator;
import util.ProcessoTipoOrdenacao;
import util.Scan;

public class Sjf {
	static int tamanhoFifo = 0;
	static Scan scan = new Scan();

	public static void main(String[] args) throws Exception {

		int quantidadeProcessosDesejados = scan.scanInt("Quantos processos deseja executar?");

		LinkedList<Processo> lista = new LinkedList<>();

		for (int i = 0; i < quantidadeProcessosDesejados; i++) {
			//obtendo informações dos processos
			lista.add(getProcess());
		}
		
		Collections.sort(lista, new ProcessoComparator(ProcessoTipoOrdenacao.TEMPO_DURACAO));
		
		System.out.println("-----------------------");
		System.out.println("Iniciando a execução dos processos");
		System.out.println("-----------------------");
		
		while(!lista.isEmpty()) {
			Processo p = lista.pop();
			System.out.println("executando o processo = " + p.getName() + ", " + p.getTempoDuracao()+" segundos");
			
			Thread.sleep(p.getTempoDuracao() * 1000);
			
			System.out.println("fim do processo = " + p.getName());
		}
	}

	private static Processo getProcess() {
		tamanhoFifo++;

		Processo p = new Processo();

		System.out.println("informações do processo = " + tamanhoFifo);
		p.setName(scan.scanString("nome:"));
		p.setTempoDuracao(scan.scanInt("tempo(em segundos):"));

		return p;
	}

}



