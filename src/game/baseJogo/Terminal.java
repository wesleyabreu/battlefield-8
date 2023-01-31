package game.baseJogo;

import java.util.Scanner;

public class Terminal implements InterfaceUsuario {

    private Scanner entrada;

    public Terminal() {
        entrada = new Scanner(System.in);
    }

    @Override
    public void continuarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public String obterComando() {
        return entrada.nextLine();
    }

    @Override
    public String obterInformacao(String instrucao) {
        System.out.println(instrucao);
        return entrada.nextLine();
    }


    // Métodos sem implementação.

    @Override
    public void jogadorDescartouItem(EntidadeGrafica item) {}

    @Override
    public void jogadorPegouItem(EntidadeGrafica item) {}

    @Override
    public void ambienteAtualMudou(EntidadeGrafica ambiente) {}

    @Override
    public void fecharJanela() {}

}
