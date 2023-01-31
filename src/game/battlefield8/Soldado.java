package game.battlefield8;

import java.util.HashMap;
import game.battlefield8.itens.Item;

/**
 * Classe Soldado - um soldado em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Soldado" representa um jogador que interage no jogo.
 * 
 * @author Wesley Abreu
 * 
 */

public class Soldado {
    // Atributo nome
    private String nome;
    // Atributo que define o limite de itens que um jogador consegue carregar em sua mochila.
    private int capacidadeMochila;
    // HashMap com a chave que é o nome do item, assim retornando o item através da chave
    private HashMap<String, Item> mochila;
    // Energia do jogador, quantos movimentos ele pode realizar
    private int energia;
    // Quantos passos o jogador deu durante o jogo
    private int passos;
    // Quantos inimigos o jogador eliminou durante o jogo
    private int eliminacoes;
    
    /**
     * Cria um soldado com "nome", "energia" e "capacidadeMochila" passados.
     * @param nome Nome do soldado.
     * @param energia Energia inicial do soldado.
     * @param capacidadeMochila Capacidade maxima de sua mochila.
     */
    public Soldado(String nome, int energia, int capacidadeMochila) {
        this.nome = nome;
        this.energia = energia;
        this.capacidadeMochila = capacidadeMochila;
        mochila = new HashMap<>();
        passos = 0;
        eliminacoes = 0;
    }

    /**
     * @return Nome do jogador.
     */
    public String getNomeSoldado(){
        return nome;
    }

    /**
     * @return A capacidade de itens que se pode carregar na mochila.
     */
    public int getCapacidadeMochila() {
        return capacidadeMochila;
    }

    /**
     * Guarda um item na mochila caso ela não esteja cheia.
     * @param item Item a ser guardado na mochila.
     * @return Se foi guardado ou não o item na mochila.
     */
    public Boolean inserirItem(Item item) {
        if (getOcupacaoMochila() < capacidadeMochila) { // verifica se a mochila não está cheia.
            mochila.put(item.getNome(), item);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tira um item da mochila.
     * @param nomeDoItem Nome do item a ser removido da mochila.
     * @return Retorna o item que foi retirado.
     */
    public Item removerItem(String nomeDoItem) {
        if (estaNaMochila(nomeDoItem)) {
            Item itemRemovido = mochila.remove(nomeDoItem);
            return itemRemovido;
        } else {
            return null;
        }
    }

    /**
     * Retorna um item da mochila.
     * @param nomeDoItem Nome do item a ser buscado na mochila.
     * @return Retorna o item que foi buscado.
     */
    public Item getItem(String nomeDoItem) {
        if (estaNaMochila(nomeDoItem)) {
            Item itemBuscado = mochila.get(nomeDoItem);
            return itemBuscado;
        } else {
            return null;
        }
    }

    /**
     * @return String com a lista de itens que tem na mochila.
     */
    public String getItensDaMochila() {
        String textoSaidas = "";
        for (String item : mochila.keySet()) {
            textoSaidas = textoSaidas + item + " ";
        }
       return textoSaidas;
    }

    /**
     * @param nomeDoItem Nome do item a ser consultado na mochila.
     * @return Se o item está ou não na mochila.
     */
    public boolean estaNaMochila(String nomeDoItem) {
        if(mochila.get(nomeDoItem) != null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return Quantos itens estão sendo carregados na mochila.
     */
    public int getOcupacaoMochila() {
        return mochila.size();
    }

    /**
     * @return Se possui item na mochila.
     */
    public boolean temItem() {
        if(!mochila.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * @return A energia do soldado.
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Consome a energia do soldado.
     * @param valor O valor a ser consumido de sua energia.
     */
    public void gastarEnergia(int valor) {
        energia -= valor;
    }

    /**
     * Repoem a energia do soldado.
     * @param valor O valor a ser reposto de sua energia.
     */
    public void reporEnergia(int valor) {
        energia += valor;
    }

    /**
     * Seta a energia do soldado.
     * @param valor O valor a ser de sua energia.
     */
    public void setEnergia(int valor) {
        energia = valor;
    }

    /**
     * @return Se o soldado está vivo.
     */
    public boolean estaVivo() {
        if (energia > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Incrementa a quantidade de passos do jogador
     */
    public void andar() {
        passos++;
    }

    /**
     * @return A quantidade de passos do jogador
     */
    public int getPassos() {
        return passos;
    }

    /**
     * Incrementa a quantidade de inimigos eliminados pelo jogador
     */
    public void eliminou() {
        eliminacoes++;
    }

    /**
     * @return A quantidade de inimigos eliminados pelo jogador
     */
    public int getEliminacoes() {
        return eliminacoes;
    }
}
