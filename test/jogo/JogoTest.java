package jogo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTest {
	
	private Jogo jogo = new Jogo();
	
	@Test
	public void jogoIniciaComTabuleiroVazio() {
		String tabuleiroEsperado = 
			".....\n" + 
			".....\n" + 
			".....\n" + 
			".....\n";
		
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}

	@Test
	public void inserirUmNavio() {
		String tabuleiroEsperado = 
			".....\n" + 
			"..#..\n" + 
			".....\n" + 
			".....\n";
		
		jogo.inserirNavio(2, 3);
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}
	
	@Test
	public void inserirVariosNavios() {
		String tabuleiroEsperado = 
			".....\n" + 
			"..#..\n" + 
			"...#.\n" + 
			".#...\n";
		
		inserir3Navios();
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}
	
	@Test
	public void iniciarJogo() {
		String tabuleiroEsperado = 
			".....\n" + 
			".....\n" + 
			".....\n" + 
			".....\n";
		
		inserir3Navios();
		jogo.iniciar();
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}
	
	@Test
	public void atirarNaPosicaoXY() {
		String tabuleiroEsperado = 
			"....@\n" + 
			".....\n" + 
			".....\n" + 
			".....\n";
		
		inserir3Navios();
		jogo.iniciar();
		jogo.atirar(1,5);
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}

	@Test
	public void validarSeTiroAcertou() {
		String tabuleiroEsperado = 
			".....\n" + 
			".....\n" + 
			".....\n" + 
			".x...\n";;
		
		inserir3Navios();
		jogo.iniciar();
		jogo.atirar(4,2);
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
	}

	@Test
	public void validarSeAcertouTodosNavios() {
		String tabuleiroEsperado = 
			".....\n" + 
			"..x..\n" + 
			"...x.\n" + 
			".x...\n";;
		
		inserir3Navios();
		jogo.iniciar();
		jogo.atirar(2,3);
		jogo.atirar(3,4);
		jogo.atirar(4,2);
		
		assertEquals(tabuleiroEsperado, jogo.getTabuleiro());
		assertTrue(jogo.finalizado());
	}
	
	private void inserir3Navios() {
		jogo.inserirNavio(2, 3);
		jogo.inserirNavio(3, 4);
		jogo.inserirNavio(4, 2);
	}
}
