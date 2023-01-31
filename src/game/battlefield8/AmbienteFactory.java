package game.battlefield8;

import game.battlefield8.itens.Item;
import game.battlefield8.personagens.Personagem;

/**
 * Factory para criação de ambientes.
 */

public class AmbienteFactory {
    
    /**
     * Cria e retorna um ambiente.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente criarAmbiente(String nome, String descricao, String caminhoImagem) {
        return new Ambiente(nome, descricao, caminhoImagem);
    }

   /**
     * Cria e retorna um ambiente.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param item Item que o ambiente possui.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente criarAmbiente(String nome, String descricao, Item item, String caminhoImagem) {
        return new Ambiente(nome, descricao, item, caminhoImagem);
    }

    /**
     * Cria e retorna um ambiente.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param item Item que o ambiente possui.
     * @param personagem Persoanegm que o ambiente tem.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente criarAmbiente(String nome, String descricao, Item item, Personagem personagem, String caminhoImagem) {
        return new Ambiente(nome, descricao, item, personagem, caminhoImagem);
    }

    /**
     * Cria e retorna um ambiente.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param personagem Personagem que o ambiente tem.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente criarAmbiente(String nome, String descricao, Personagem personagem, String caminhoImagem) {
        return new Ambiente(nome, descricao, personagem, caminhoImagem);
    }

}
