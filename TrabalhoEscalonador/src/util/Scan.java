package util;

import java.util.Scanner;

public class Scan {

	Scanner scanner = new Scanner(System.in);

	public String scanString() {
		return scanString(null);
	}

	public String scanString(String mensagem) {
		if (mensagem != null && !mensagem.isEmpty()) {
			System.out.println(mensagem);
		}
		return scanner.nextLine();
	}

	public int scanInt() {
		return scanInt(null);
	}

	public int scanInt(String mensagem) {
		if (mensagem != null && !mensagem.isEmpty()) {
			System.out.println(mensagem);
		}

		return Integer.parseInt(scanner.nextLine());
	}

}
