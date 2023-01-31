package game.battlefield8;

import game.baseJogo.Tela;

public class App {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Tela("Battlefield 8"));		
		jogo.jogar();
    }
}
