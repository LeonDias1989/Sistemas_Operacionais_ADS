package OrdemDePrioridade;

import util.Processo;

public class Testes {
	
public static void main(String[] args) {
		
		
		Prioridade filaProcessos = new Prioridade();
		
		//Create Process 
		filaProcessos.adicionar(new Processo("A", 1, 2, 3));
		filaProcessos.adicionar(new Processo("B", 0, 1, 4));
		filaProcessos.adicionar(new Processo("C", 1, 3, 2));
		filaProcessos.adicionar(new Processo("D", 0, 3, 2));
		filaProcessos.adicionar(new Processo("E", 2, 3, 5));
		
		//Sort Process
		filaProcessos.ordenarProcessos();
		
		//Execute Process
		System.out.println("Processo Executado: " +filaProcessos.remover(filaProcessos.getMaiorPrioridade()));
		System.out.println("Tempo Atual: " +Prioridade.tempoCorrente);
		System.out.println(filaProcessos.getFilaProcessos());
		System.out.println("Processo Executado: " +filaProcessos.remover(filaProcessos.getMaiorPrioridade()));
		System.out.println("Tempo Atual: " +Prioridade.tempoCorrente);
		System.out.println(filaProcessos.getFilaProcessos());
		System.out.println("Processo Executado: " +filaProcessos.remover(filaProcessos.getMaiorPrioridade()));
		System.out.println("Tempo Atual: " +Prioridade.tempoCorrente);
		System.out.println("Processo Executado: " +filaProcessos.remover(filaProcessos.getMaiorPrioridade()));
		System.out.println("Tempo Atual: " +Prioridade.tempoCorrente);
		System.out.println("Processo Executado: " +filaProcessos.remover(filaProcessos.getMaiorPrioridade()));
		System.out.println("Tempo Atual: " +Prioridade.tempoCorrente);
		
		System.out.println(filaProcessos.getFilaProcessos());
		
		
	}

}
