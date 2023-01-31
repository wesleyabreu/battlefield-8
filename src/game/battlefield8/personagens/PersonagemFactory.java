package game.battlefield8.personagens;

/**
 * Factory para criação de personagens.
 */

public class PersonagemFactory {

    /**
     * Cria e retorna um personagem amigo.
     * @param nome Nome do personagem.
     * @param mensagem Mensagem que o personagem fala.
     * @return Um personagem amigo.
     */
    public Personagem criarPersonagem(String nome, String mensagem) {
        return new Amigo(nome, mensagem);
    }

    /**
     * Cria e retorna um personagem inimigo.
     * @param nome Nome do personagem.
     * @param mensagem Mensagem que o personagem fala.
     * @param dano Dano que o inimigo causa.
     * @return Um personagem inimigo.
     */
    public Personagem criarPersonagem(String nome, String mensagem, int dano) {
        return new Inimigo(nome, mensagem, dano);
    }

}
