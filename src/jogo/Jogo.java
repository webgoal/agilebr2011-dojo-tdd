package jogo;

public class Jogo {

	char[][] tabuleiro = 
		{
			{'.','.','.','.','.'},
			{'.','.','.','.','.'},
			{'.','.','.','.','.'},
			{'.','.','.','.','.'}
		};
	
	private boolean iniciado = false;
	
	public String getTabuleiro() {
		String tabuleiroString = "";
		for(char[] linha : tabuleiro)
			tabuleiroString += montarLinha(linha) + "\n";
		return tabuleiroString;
	}

	private String montarLinha(char[] linha) {
		String linhaString = "";
		for(char casa : linha)
			linhaString += iniciado && casa == '#' ? '.' : casa;
		return linhaString;
	}

	public void inserirNavio(int linha, int coluna) {
		tabuleiro[linha-1][coluna-1] = '#';
	}

	public void iniciar() {
		iniciado  = true;
	}

	public void atirar(int linha, int coluna) {
		if(tabuleiro[linha-1][coluna-1] == '#')
			tabuleiro[linha-1][coluna-1] = 'x';
		else
			tabuleiro[linha-1][coluna-1] = '@';
		
	}

	public boolean finalizado() {
		boolean terminou = true;
		for (char[] linha : tabuleiro) {
			for(char casa : linha){
				if(casa == '#') terminou = false; 
		} 
			}
		
		return terminou;
	}

}
