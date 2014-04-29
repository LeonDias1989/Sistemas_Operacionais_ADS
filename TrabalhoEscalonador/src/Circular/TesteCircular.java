package Circular;

import util.Processo;

public class TesteCircular {
	
public static void main(String[] args) throws Exception{
		
		
		Circular filaProcessos = new Circular();
		
		//nome,chegada,duracao,prioridade
		filaProcessos.adicionar(new Processo("P1", 1, 10, 2));
		filaProcessos.adicionar(new Processo("P2", 2, 6, 4));
		filaProcessos.adicionar(new Processo("P3", 3, 8, 5));
		
		filaProcessos.executaProcessos();
		
	}

}
