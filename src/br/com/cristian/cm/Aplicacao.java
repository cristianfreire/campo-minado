package br.com.cristian.cm;

import br.com.cristian.cm.modelo.Tabuleiro;
import br.com.cristian.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);
		
		
	}
}
