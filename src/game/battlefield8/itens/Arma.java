package game.battlefield8.itens;

/**
 * Classe Arma - Arma é um Item portanto tem (nome, peso, tipo e descricao).
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Uma "Arma" representa uma arma que o jogador pode encontrar e pegar em um ambiente.
 * 
 * @author Wesley Abreu
 * 
 */

public class Arma extends Item {
    // Alcance que a arma tem.
    private String alcance;

    /**
     * Cria uma arma com o seu "nome", "peso", "descrição" e "alcance" passados.
     * @param nome Nome da arma.
     * @param peso Peso da arma.
     * @param descricao Descrição da arma.
     * @param alcance Alcance da arma.
     * @param carregavel Se ela é carregavel.
     */
    public Arma(String nome, double peso, String descricao, String alcance, boolean carregavel, String caminhoImagem) {
        super(nome, peso, "arma", descricao, carregavel, false, caminhoImagem);
        this.alcance = alcance;
    }

    /**
     * @return O alcance da arma.
     */
    public String getAlcance() {
        return alcance;
    }

    /**
     * @return Descrição do item.
     */
    @Override
    public String getDescricao(){
        return super.getDescricao() + " e tem alcance " + alcance;
    }
}
