package game.battlefield8.itens;

import game.baseJogo.EntidadeGrafica;

/**
 * Classe Item - um item em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Item" representa um item que o jogador pode encontrar e pegar em um ambiente.
 * 
 * @author Wesley Abreu
 * 
 */

public abstract class Item extends EntidadeGrafica {
    // Atributos
    private String nome;
    private double peso;
    private String tipo;
    private String descricao;
    private boolean carregavel;
    private boolean comestivel;
    private int energia;

    /**
     * Cria um item com o seu "nome", "peso", "descrição", se ele é "carregavel" e se ele é "comestivel" passados.
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param tipo Tipo do item.
     * @param descricao Descrição do item.
     * @param carregavel Se ele é um item carregavel.
     * @param comestivel Se ele é um item comestivel.
     */
    public Item(String nome, double peso, String tipo, String descricao, boolean carregavel, boolean comestivel, String caminhoImagem) {
        super(caminhoImagem);
        this.nome = nome;
        this.peso = peso;
        this.tipo = tipo;
        this.descricao = descricao;
        this.carregavel = carregavel;
        this.comestivel = comestivel;
    }

    /**
     * Cria um item com o seu "nome", "peso", "descrição", se ele é "carregavel", se ele é "comestivel" e o valor de "energia" passados.
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param tipo Tipo do item.
     * @param descricao Descrição do item.
     * @param carregavel Se ele é um item carregavel.
     * @param comestivel Se ele é um item comestivel.
     * @param energia Valor de energia que a fruta tem.
     */
    public Item(String nome, double peso, String tipo, String descricao, boolean carregavel, boolean comestivel, int energia, String caminhoImagem) {
        this(nome, peso, tipo, descricao, carregavel, comestivel, caminhoImagem);
        this.energia = energia;
    }

    /**
     * @return Nome do item.
     */
    public String getNome(){
        return nome;
    }

    /**
     * @return Peso do item.
     */
    public double getPeso(){
        return peso;
    }

    /**
     * @return Energia do item no caso dos comestiveis.
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * @return O tipo do item.
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * @return Descrição do item.
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * @return Se ele é carregavel.
     */
    public boolean isCarregavel() {
        return carregavel;
    }

    /**
     * @return Se ele é comestivel.
     */
    public boolean isComestivel() {
        return comestivel;
    }
}
