package game.battlefield8;

/**
 * Esta classe é parte da aplicação "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.  
 * 
 * Essa classe guarda uma enumeração de todos os comandos conhecidos do
 * jogo. Ela é usada no reconhecimento de comandos como eles são digitados.
 *
 * @author Wesley Abreu
 * 
 */

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos válidas
    private static final String[] comandosValidos = {
        // adicionado comando para comer a fruta
        "ir", "sair", "ajuda", "observar", "pegar", "usar", "comer", "largar", "atacar", "conversar", "historico"
    };

    /**
     * Verifica se uma dada String é uma palavra de comando válida. 
     * @return true se a string dada é um comando valido, false se não é.
     */
    public boolean ehComando(String umaString) {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string não foi encontrada nos comandos.
        return false;
    }
    
    /**
     * Retorna uma string com todos os comandos válidos no jogo.
     */
    public String obterComandos(){
        String textoComandos = "";
        for(String comando : comandosValidos){
            textoComandos += comando + " ";
        }

        return textoComandos;
    }
}