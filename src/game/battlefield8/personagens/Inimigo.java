package game.battlefield8.personagens;

/**
 * Classe Inimigo - um inimigo em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Inimigo" representa um inimigo que o jogador pode interagir e atacar.
 * 
 * @author Wesley Abreu
 * 
 */

public class Inimigo extends Personagem {
    // Atributos
    private int dano;

    /**
     * Cria um inimigo com o seu "nome", "mensagem", e "dano" que ele causa passados.
     * @param nome Nome do inimigo.
     * @param mensagem Mensagem que o inimigo fala.
     * @param dano Dano que o inimigo causa.
     */
    public Inimigo(String nome, String mensagem, int dano) {
        super(nome, mensagem, false);
        this.dano = dano;
    }

    /**
     * @return Dano que o inimigo causa.
     */
    @Override
    public int getDano() {
        return dano;
    }

    /**
     * @return Descrição do inimgo.
     */
    @Override
    public String getDescricao() {
        return "seu inimigo, pode te ferir em " + dano + " ponto(s) de energia, e talvez tenha algo para te falar";
    }
}
