package game.battlefield8.itens;

/**
 * Classe Chave - Chave é um Item portanto tem (nome, peso, tipo e descricao).
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Uma "Chave" representa uma chave que o jogador pode encontrar e pegar em um ambiente 
 * e usar para desbloquear lugares.
 * 
 * @author Wesley Abreu
 * 
 */

public class Chave extends Item {
    /**
     * Cria uma chave com o seu "nome", "peso", "descrição" e "cor" passados.
     * @param nome Nome da fruta.
     * @param peso Peso da fruta.
     * @param descricao Descrição da fruta.
     * @param carregavel Se ela é carregavel.
     */
    public Chave(String nome, double peso, String descricao, boolean carregavel, String caminhoImagem) {
        super(nome, peso, "chave", descricao, carregavel, false, caminhoImagem);
    }
}
