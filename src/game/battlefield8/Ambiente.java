package game.battlefield8;

import java.util.HashMap;

import game.baseJogo.EntidadeGrafica;
import game.battlefield8.itens.Item;
import game.battlefield8.personagens.Personagem;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author Wesley Abreu
 * 
 */

public class Ambiente extends EntidadeGrafica {
    // Nome do ambiente
    private String nome;
    // Descrição do ambiente.
    private String descricao;
    // Saída bloqueada no ambiente.
    private String saidaBloqueada;
    // Item de desbloqueio de uma saída bloqueada.
    private String itemDeDesbloqueio;
    // Itens que o ambiente possui.
    private HashMap<String, Item> itens;
    // Personagens que o ambiente possui.
    private HashMap<String, Personagem> personagens;
    // Ambientes vizinhos de acordo com a direção.
    private HashMap<String, Ambiente> saidas;

    /**
     * Cria um ambiente com o "nome", "descricao" e "caminhoImagem" passados.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente(String nome, String descricao, String caminhoImagem) {
        super(caminhoImagem);
        this.nome = nome;
        this.descricao = descricao;
        saidaBloqueada = null;
        itemDeDesbloqueio = null;
        itens = new HashMap<>();
        saidas = new HashMap<>();
        personagens = new HashMap<>();
    }

    /**
     * Cria um ambiente com o "nome", "descricao", "item" e "caminhoImagem" passados.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param item Item que o ambiente possui.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente(String nome, String descricao, Item item, String caminhoImagem) {
        this(nome, descricao, caminhoImagem);
        itens.put(item.getNome(),item);
    }

    /**
     * Cria um ambiente com o "nome", "descricao", "item", "personagem" e "caminhoImagem" passados.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param item Item que o ambiente possui.
     * @param personagem Persoanegm que o ambiente tem.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente(String nome, String descricao, Item item, Personagem personagem, String caminhoImagem) {
        this(nome, descricao, item, caminhoImagem);
        personagens.put(personagem.getNome(),personagem);
    }

    /**
     * Cria um ambiente com o "nome", "descricao", "personagem" e "caminhoImagem" passados.
     * @param nome O nome do ambiente.
     * @param descricao A descrição do ambiente.
     * @param personagem Personagem que o ambiente tem.
     * @param caminhoImagem Caminho da imagem do ambiente.
     */
    public Ambiente(String nome, String descricao, Personagem personagem, String caminhoImagem) {
        this(nome, descricao, caminhoImagem);
        personagens.put(personagem.getNome(),personagem);
    }

    /**
     * @return Se possui item no ambiente.
     */
    public boolean temItem() {
        if(!itens.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * @return Se tem personagem no ambiente.
     */
    public boolean temPersonagem() {
        if(!personagens.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * @return String com os itens que o ambiente tem separados por espaços.
     */
    public String consultarItens(){
        if(temItem()){
            String listaItens = "";
            for (String item : itens.keySet()) {
                listaItens = listaItens + item + " ";
            }
            return listaItens;
        }else{
            return null;
        }
    }

    /**
     * @param nome Nome do item buscado.
     * @return Retorna o item do ambiente.
     */
    public Item getItem(String nome){
        if(temItem()){
            if (itens.get(nome) != null) {
                return itens.get(nome);
            }
        }
        return null;
    }

    /**
     * @param nome Nome do personagem buscado.
     * @return Retorna o personagem do ambiente.
     */
    public Personagem getPersonagem(String nome){
        if(temPersonagem()){
            if (personagens.get(nome) != null) {
                return personagens.get(nome);
            }
        }
        return null;
    }

    /**
     * @return O dano que todos os inimigos no ambiente causam juntos.
     */
    public int getDanoInimigos() {
        int danos = 0;
        for ( String p : personagens.keySet() ) {
            Personagem pessoa = personagens.get(p);
            if (!pessoa.isAmigo()) {
                danos += pessoa.getDano();
            }
        }
        return danos;
    }

    /**
     * @return String com os inimigos que o ambiente tem separados por espaços.
     */
    public String consultarInimigos(){
        if(temPersonagem()){
            String listaInimigos = "";
            for (String p : personagens.keySet()) {
                Personagem pessoa = personagens.get(p);
                if (!pessoa.isAmigo()) {
                    listaInimigos = listaInimigos + p + ", ";
                }
            }
            return listaInimigos;
        }else{
            return null;
        }
    }

    /**
     * @param nome Nome do personagem a ser eliminado.
     * @return Elimina e retorna o personagem.
     */
    public Personagem eliminarPersonagem(String nome){
        if((temPersonagem()) && (personagens.get(nome) != null)){
            Personagem personagemEliminado = personagens.remove(nome);
            return personagemEliminado;
        }else{
            return null;
        }
    }

    /**
     * @param nome Nome do item a ser coletado.
     * @return Coleta e retorna o item.
     */
    public Item coletarItem(String nome){
        if((temItem()) && (itens.get(nome) != null)){
            Item itemColetado = itens.remove(nome);
            return itemColetado;
        }else{
            return null;
        }
    }

    /**
     * Ajusta as saídas do ambiente.
     * @param direcao Direção da saída.
     * @param ambiente Ambiente até qual a saída leva.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return Descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param direcao Direção a qual o ambiente leva.
     * @return Retorna o ambiente de acordo com o qual a direção leva.
     */
    public Ambiente getAmbiente(String direcao) {
        if(direcao.equals(saidaBloqueada)){
            return null;
        }else{
            return saidas.get(direcao);
        }
    }

    /**
     * @return Uma string com as opções de saída.
     */
    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
       return textoSaidas;
    }

    /**
     * @return Nome do ambiente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Uma string com a descrição completa do ambiente.
     */
    public String getDescricaoLonga(){

        String texto = "";
        texto += "Você está " + getDescricao() + "\n";

        if(temItem()){
            for (String nomeItem : itens.keySet()) {
                texto += "[%] E há um(a) " + itens.get(nomeItem).getNome() +", que é "+ itens.get(nomeItem).getDescricao() + ".\n";
            }
        }else{
            texto += "E não há itens aqui.\n";
        }
        if(temPersonagem()) {
            for (String nomePersonagem : personagens.keySet()) {
                texto += "[!] Você encontrou com " + nomePersonagem +", que é "+ personagens.get(nomePersonagem).getDescricao() + ".\n";
            }
        }else{
            texto += "E não há pessoas aqui.\n";
        }

        texto += "Saídas: " + getSaidas();

        return texto;  
    }

    /**
     * Ajusta uma saída bloqueada no ambiente.
     * @param direcao Direção da saída.
     * @param ambiente Ambiente até qual a saída leva.
     * @param nomeDoItem Nome do item que desbloqueia a passagem.
     */
    public void ajustarSaidaBloqueada(String direcao, Ambiente ambiente, String nomeDoItem){
        ajustarSaida(direcao, ambiente);
        saidaBloqueada = direcao;
        itemDeDesbloqueio = nomeDoItem;
    }

    /**
     * Usa um item para desbloquear uma saída.
     * @param item Item queserá usado para desbloquear a saída.
     * @return Se a saída foi desbloqueada ou não.
     */
    public boolean usarItem(Item item){
        if(item.getNome().equals(itemDeDesbloqueio)){
            saidaBloqueada = null;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Coloca um item no ambiente.
     * @param item O item a ser colocado no ambiente.
     */
    public void colocarItem(Item item) {
        itens.put(item.getNome(), item);
    }

    /**
     * Coloca um personagem no ambiente.
     * @param persoagem O personagem a ser colocado no ambiente.
     */
    public void colocarPersonagem(Personagem personagem) {
        personagens.put(personagem.getNome(), personagem);
    }
}