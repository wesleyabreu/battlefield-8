package game.battlefield8.itens;

/**
 * Factory para criação de itens (fazendo uso de SOBRECARGA para as variações de Itens).
 */

public class ItemFactory {

    /**
     * Cria e retorna uma arma.
     * @param nome Nome da arma.
     * @param peso Peso da arma.
     * @param descricao Descrição da arma.
     * @param alcance Alcance da arma.
     * @param carregavel Se ela é carregavel.
     * @return Uma arma.
     */
    public Item criarItem(String nome, double peso, String descricao, String alcance, boolean carregavel, String caminhoImagem) {
        return new Arma(nome, peso, descricao, alcance, carregavel, caminhoImagem);
    }

    /**
     * Cria e retorna um item chave.
     * @param nome Nome da fruta.
     * @param peso Peso da fruta.
     * @param descricao Descrição da fruta.
     * @param carregavel Se ela é carregavel.
     * @return Uma chave.
     */
    public Item criarItem(String nome, double peso, String descricao, boolean carregavel, String caminhoImagem) {
        return new Chave(nome, peso, descricao, carregavel, caminhoImagem);
    }

    /**
     * Cria e retorna um item fruta.
     * @param nome Nome da fruta.
     * @param peso Peso da fruta.
     * @param descricao Descrição da fruta.
     * @param cor Cor da fruta.
     * @param carregavel Se ele é carregavel.
     * @param comestivel Se ele é comestivel.
     * @param energia Valor de energia da fruta.
     * @return Uma fruta.
     */
    public Item criarItem(String nome, double peso, String descricao, String cor, boolean carregavel, boolean comestivel, int energia, String caminhoImagem) {
        return new Fruta(nome, peso, descricao, cor, carregavel, comestivel, energia, caminhoImagem);
    }

}
