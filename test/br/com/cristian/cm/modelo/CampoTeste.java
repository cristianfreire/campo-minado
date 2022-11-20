package br.com.cristian.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cristian.cm.excecao.ExplosaoException;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistanciaLados() {
		Campo vizinhoEsquerda = new Campo(3,2);
		Campo vizinhoDireita = new Campo(3,4);
		
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
		
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
		
	}
	
	@Test
	void testeVizinhoRealDistanciaCimaBaixo() {
		Campo vizinhoCima = new Campo(2,3);
		Campo vizinhoBaixo = new Campo(4,3);
		
		boolean resultadoCima = campo.adicionarVizinho(vizinhoCima);
		assertTrue(resultadoCima);
		
		boolean resultadoBaixo = campo.adicionarVizinho(vizinhoBaixo);
		assertTrue(resultadoBaixo);
		
	}
	
	@Test
	void testeNaoVizinho() {
		Campo naoVizinho = new Campo(1,1);
		
		boolean resultadoNaoVizinho = campo.adicionarVizinho(naoVizinho);
		assertFalse(resultadoNaoVizinho);
	}
	
	@Test
	void testeVizinhoDiagonal() {
		Campo vizinhoDiagonal = new Campo(2,2);
		
		boolean resultadoVizinhoDiagonal = campo.adicionarVizinho(vizinhoDiagonal);
		assertTrue(resultadoVizinhoDiagonal);		
	}
	
	@Test
	void testeValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoSemMinaNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
		
	}
	
	@Test
	void testeAbirComVizinhos() {
		Campo vizinho1 = new Campo(2,2);
		Campo vizinhoDoVizinho1 = new Campo(1,1);
		
		
		campo.adicionarVizinho(vizinho1);
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
	}
	
	@Test
	void testeAbirComVizinhos2() {
		Campo vizinho1 = new Campo(2,2);
		Campo vizinhoDoVizinho1 = new Campo(1,2);
		vizinhoDoVizinho1.minar();
		
		
		campo.adicionarVizinho(vizinho1);
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && !vizinhoDoVizinho1.isAberto());
	}
	
}
