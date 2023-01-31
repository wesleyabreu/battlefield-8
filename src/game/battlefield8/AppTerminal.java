package game.battlefield8;

import game.baseJogo.Terminal;

public class AppTerminal {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Terminal());		
		jogo.jogar();
    }
}
