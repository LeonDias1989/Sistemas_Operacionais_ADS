package fifo;

import java.util.LinkedList;

import util.Process;
import util.Scan;

/**
 * 
 * @author jandrei masiero
 * 
 */
public class Fifo {
	static int tamanhoFifo = 0;
	static Scan scan = new Scan();

	public static void main(String[] args) throws Exception {

		int quantidadeProcessosDesejados = scan.scanInt("Quantos processos deseja executar?");

		LinkedList<Process> lista = new LinkedList<Process>();

		for (int i = 0; i < quantidadeProcessosDesejados; i++) {
			//obtendo informações dos processos
			lista.add(getProcess());
		}

		System.out.println();
		System.out.println("Iniciando a execução dos processos");
		System.out.println();
		
		while(!lista.isEmpty()) {
			Process p = lista.pop();
			System.out.println("executando o processo = " + p.getName() + ", " + p.getTime()+" segundos");
			
			Thread.sleep(p.getTime() * 1000);
			
			System.out.println("fim do processo = " + p.getName());
		}
	}

	private static Process getProcess() {
		tamanhoFifo++;

		Process p = new Process();

		System.out.println("informações do processo = " + tamanhoFifo);
		p.setName(scan.scanString("nome:"));
		p.setTime(scan.scanInt("tempo(em segundos):"));

		return p;
	}

}
