package OrdemDePrioridade;

import util.Processo;
import util.Scan;

public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {

		Prioridade filaDeProcessos = new Prioridade();
		
		System.out.println("Quantos processo quer executar?");
		
		Scan var = new Scan();
		
		int x = var.scanInt();
		
		for (int i = 0; i < x; i++) {
			
			System.out.println("Nome: ");
			String nome = var.scanString();
			
			System.out.println("Hora de Chegada: ");
			int hora = var.scanInt();
			
			System.out.println("Tempo de Execução: ");
			int tempo = var.scanInt();
			
			System.out.println("Prioridade: ");
			int prioridade = var.scanInt();
			
			filaDeProcessos.adicionarProcesso(new Processo(nome, hora, tempo, prioridade));
			System.out.println("Enfileirando processo " +nome);
			Thread.sleep(2000);

			
		}
		System.out.println("\n\nExecutando os processos...");
		Thread.sleep(2000);
		for (Processo processo : filaDeProcessos.getLisaDeProcessos()) {
			
			System.out.println("Executando o processo "+processo.getName() +"...");
			Thread.sleep(1000 * processo.getTime());
			System.out.println("Processo executado em " +processo.getTime() +" segundos");
		}
		
		System.out.println("\nTotal de Processos: " +Prioridade.totalDeProcessos +"\nTempo total: " +Prioridade.tempoCorrente);
		
		
		
	}

}
