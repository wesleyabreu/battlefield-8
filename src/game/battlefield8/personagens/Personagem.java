package game.battlefield8.personagens;

/**
 * Classe Personagem - um personagem em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Personagem" representa um personagem que o jogador pode interagir.
 * 
 * @author Wesley Abreu
 * 
 */

public abstract class Personagem {
    // Atributos
    private String nome;
    private String mensagem;
    private boolean amigo;
    
    /**
     * Cria um personagem com o seu "nome", "mensagem", e se é "amigo" passados.
     * @param nome Nome do personagem.
     * @param mensagem Mensagem que o personagem fala.
     * @param amigo Se o personagem é amigo ou não.
     */
    public Personagem(String nome, String mensagem, boolean amigo) {
        this.nome = nome;
        this.amigo = amigo;
        this.mensagem = mensagem;
    }

    /**
     * @return Nome do personagem.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Se é amigo.
     */
    public boolean isAmigo() {
        return amigo;
    }

    /**
     * @return Mensagem que ele fala.
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @return Descrição do personagem.
     */
    public abstract String getDescricao();

    /**
     * @return Dano que o personagem causa.
     */
    public abstract int getDano();
}
