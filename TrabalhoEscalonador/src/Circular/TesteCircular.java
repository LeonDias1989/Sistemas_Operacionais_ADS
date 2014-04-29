package Circular;

import util.Processo;

public class TesteCircular {
	
public static void main(String[] args) throws Exception{
		
		
		Circular filaProcessos = new Circular();
		
		//nome,chegada,duracao,prioridade
		filaProcessos.adicionar(new Processo("A", 1, 2, 3));
		filaProcessos.adicionar(new Processo("B", 0, 1, 4));
		filaProcessos.adicionar(new Processo("C", 1, 3, 2));
		filaProcessos.adicionar(new Processo("D", 0, 3, 2));
		filaProcessos.adicionar(new Processo("E", 2, 3, 5));
		
		filaProcessos.executaProcessos();
		
	}

}
