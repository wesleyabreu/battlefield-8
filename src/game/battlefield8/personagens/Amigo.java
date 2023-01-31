package game.battlefield8.personagens;

/**
 * Classe Amigo - um amigo em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Amigo" representa um amigo que o jogador pode interagir.
 * 
 * @author Wesley Abreu
 * 
 */

public class Amigo extends Personagem {

    /**
     * Cria um amigo com o seu "nome", "mensagem" passados.
     * @param nome Nome do amigo.
     * @param mensagem Mensagem que o amigo fala.
     */
    public Amigo(String nome, String mensagem) {
        super(nome, mensagem, true);
    }
    
    /**
     * @return Descrição do amigo.
     */
    @Override
    public String getDescricao() {
        return "seu amigo, e talvez tenha algo para te falar";
    }

    /**
     * @return Amigos não causam dano retorna 0.
     */
    @Override
    public int getDano() {
        return 0;
    }
   
}
