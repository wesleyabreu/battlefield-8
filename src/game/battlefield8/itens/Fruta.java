package game.battlefield8.itens;

/**
 * Classe Fruta - Fruta é um Item portanto tem (nome, peso, tipo, descricao, se é carregavel, e se é comestivel).
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Uma "Fruta" representa uma fruta que o jogador pode encontrar e pegar em um ambiente.
 * 
 * @author Wesley Abreu
 * 
 */

public class Fruta extends Item {
    // Cor da fruta.
    private String cor;

    /**
     * Cria uma fruta com o seu "nome", "peso", "descrição" e "cor", se ela é "carregavel", se ela é "comestivel" e o valor de "energia" dela passados.
     * @param nome Nome da fruta.
     * @param peso Peso da fruta.
     * @param descricao Descrição da fruta.
     * @param cor Cor da fruta.
     * @param carregavel Se ele é carregavel.
     * @param comestivel Se ele é comestivel.
     * @param energia Valor de energia da fruta.
     */
    public Fruta(String nome, double peso, String descricao, String cor, boolean carregavel, boolean comestivel, int energia, String caminhoImagem) {
        super(nome, peso, "fruta", descricao, carregavel, comestivel, energia, caminhoImagem);
        this.cor = cor;
    }

    /**
     * @return Cor da fruta.
     */
    public String getCorFruta() {
        return cor;
    }
    
    /**
     * @return Descrição do item.
     */
    @Override
    public String getDescricao(){
        return super.getDescricao() + " e tem cor " + cor;
    }
}
