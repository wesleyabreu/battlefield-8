package game.battlefield8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import game.baseJogo.InterfaceUsuario;
import game.baseJogo.Tela;
import game.battlefield8.itens.Item;
import game.battlefield8.itens.ItemFactory;
import game.battlefield8.personagens.Personagem;
import game.battlefield8.personagens.PersonagemFactory;

/**
 * Essa é a classe principal da aplicacao "Battlefield 8".
 * "Battlefield 8" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author Wesley Abreu
 * 
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    // ambiente final do jogo
    private Ambiente ambienteFinal;
    // jogador
    private Soldado soldado;
    // factory de personagem
    private PersonagemFactory personagemFactory;
    // factory de itens
    private ItemFactory itemFactory;
    // factory de ambientes
    private AmbienteFactory ambienteFactory;
    // interface usuario
    private InterfaceUsuario ui;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario ui)  {
        this.ui = ui;
        criarSoldado();
        analisador = new Analisador(ui);
        personagemFactory = new PersonagemFactory();
        itemFactory = new ItemFactory();
        ambienteFactory = new AmbienteFactory();
        criarAmbientes();
    }

    public void criarSoldado(){
        soldado = new Soldado("Soldado", 15, 3);
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {

        // AMBIENTES DO JOGO
        Ambiente floresta, arvore, copa;
        Ambiente acampamento, cabanaHospitalar, cidade, casa, deserto, caverna;
        Ambiente campoDeBatalha, trincheira;

        // ITENS DO JOGO
        Item m16, faca, chave, pedra, carambola, banana;

        // PERSONAGENS DO JOGO
        Personagem a_zanda, i_ronald, i_wesley, i_denis, i_julio, i_luiz;
        
        // CRIAÇÃO DOS ITENS
        m16 = itemFactory.criarItem("m16", 3.99, "um rifle de alta precisão","Longo", true, "img/itens/m16.png");
        faca = itemFactory.criarItem("faca", 0.25, "uma arma de corte","Corpo a corpo", true, "img/itens/faca.png");
        chave = itemFactory.criarItem("chave", 0.05, "uma alternativa para fuga caso o inimigo estiver vencendo", true, "img/itens/chave.png");
        pedra = itemFactory.criarItem("pedra", 20, "um pedaço grande de rocha","Nenhum", false, "img/itens/pedra.png");
        carambola = itemFactory.criarItem("carambola", 0.3, "uma fruta e pode ser comida para repor energias","Amarela", true, true, 10, "img/itens/carambola.png");
        banana = itemFactory.criarItem("banana", 0.5, "uma fruta e pode ser comida para repor energias","Amarela", true, true, 10, "img/itens/banana.png");
        // CRIAÇÃO DOS PERSONAGENS
        a_zanda = personagemFactory.criarPersonagem("zanda", "cara vaza daqui, pega a chave do carro que deixei cair em algum lugar perto daqui");
        i_ronald = personagemFactory.criarPersonagem("galdino", "eu quero que você morra", 5);
        i_wesley = personagemFactory.criarPersonagem("abreu", "vou estourar sua cabeça", 7);
        i_denis = personagemFactory.criarPersonagem("cordeiro", "por favor não me mate estou desarmado", 0);
        i_julio = personagemFactory.criarPersonagem("caburu", "se você quiser pegar essa chave, vai ter que me matar! ou então pode morrer tentando", 4);
        i_luiz = personagemFactory.criarPersonagem("merschmann", "pelo jeito alguem nao fez a copia da chave", 3);

        // CRIAÇÃO DOS AMBIENTES
        floresta = ambienteFactory.criarAmbiente("Floresta","na floresta", faca, "img/ambientes/floresta3d.jpg"); // Colocar faca.
        arvore = ambienteFactory.criarAmbiente("Arvore", "do lado de uma arvore da floresta, pode ser que na sua copa tenha alguma fruta", "img/ambientes/arvore.jpg");
        copa = ambienteFactory.criarAmbiente("Copa", "na copa de uma árvore", carambola, i_wesley, "img/ambientes/copa.jpg"); // Colocar carambola e inimigo.
        deserto = ambienteFactory.criarAmbiente("Deserto", "no deserto", m16, i_ronald, "img/ambientes/deserto3d.jpg"); // Colocar m16 e inimigo.
        acampamento = ambienteFactory.criarAmbiente("Acampamento", "no acampamento militar", "img/ambientes/acampamento3d.jpeg");
        cabanaHospitalar = ambienteFactory.criarAmbiente("Cabana Hospitalar", "na cabana hospitalar", banana, i_denis, "img/ambientes/cabana3d.jpg"); // Colocar banana e inimigo.
        cidade = ambienteFactory.criarAmbiente("Cidade", "no centro da cidade", "img/ambientes/cidade.jpg");
        casa = ambienteFactory.criarAmbiente("Casa", "na sua casa!", "img/ambientes/casa.jpg");
        campoDeBatalha = ambienteFactory.criarAmbiente("Campo de Batalha", "no campo de batalha", a_zanda, "img/ambientes/campo3d.jpg"); // Colocar amigo.
        trincheira = ambienteFactory.criarAmbiente("Trincheira", "na trincheira", chave, i_luiz, "img/ambientes/trincheira3d.jpg"); 
        trincheira.colocarPersonagem(i_julio); // Adiciona mais um inimigo ao ambiente
        caverna = ambienteFactory.criarAmbiente("Caverna", "na caverna",pedra, "img/ambientes/caverna3d.jpg"); // Colocar pedra.
        
        // INICIALIZA AS SAÍDAS DOS AMBIENTES
        floresta.ajustarSaida("leste", acampamento);
        floresta.ajustarSaida("norte", arvore);
        arvore.ajustarSaida("sul",floresta);
        arvore.ajustarSaida("cima", copa);
        copa.ajustarSaida("baixo", arvore);
        acampamento.ajustarSaida("norte", cabanaHospitalar);
        acampamento.ajustarSaida("oeste", floresta);
        acampamento.ajustarSaidaBloqueada("carro", cidade, "chave");
        cabanaHospitalar.ajustarSaida("sul", acampamento);
        cabanaHospitalar.ajustarSaida("oeste", caverna);
        cabanaHospitalar.ajustarSaida("leste", campoDeBatalha);
        cabanaHospitalar.ajustarSaida("norte", deserto);
        campoDeBatalha.ajustarSaida("baixo", trincheira);
        campoDeBatalha.ajustarSaida("oeste", cabanaHospitalar);
        trincheira.ajustarSaida("cima", campoDeBatalha);
        caverna.ajustarSaida("leste", cabanaHospitalar);
        cidade.ajustarSaida("carro", acampamento);
        cidade.ajustarSaida("leste", casa);
        casa.ajustarSaida("oeste", cidade);   
        deserto.ajustarSaida("sul", cabanaHospitalar);    

        ambienteAtual = acampamento;  // o jogo comeca no acampamento
        ambienteFinal = casa; // o jogo termina na casa
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
        ui.ambienteAtualMudou(ambienteAtual);
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        
        ui.continuarMensagem("Obrigado por jogar. Até mais!");
        
        if (ui instanceof Tela) { // Verifica se a IU se trata de uma Tela
            
            ui.continuarMensagem("ENCERRANDO O JOGO EM INSTANTES...");

            try {
                // aguarda 5 segundos
                Thread.sleep(5000);
            }
            catch (Exception e) {}
            
            ui.fecharJanela(); // fecha a janela automaticamente
        }

    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        ui.continuarMensagem("Bem-vindo ao Battlefield 8!");
        ui.continuarMensagem("Battlefield 8 eh um novo jogo de aventura, incrivelmente divertido e emocionante.");
        // printei qual a missão do jogo
        ui.continuarMensagem("Sua missão é chegar em casa.");
        ui.continuarMensagem("Digite 'ajuda' se você precisar de ajuda.");
        
        exibirAmbienteAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            ui.continuarMensagem("Eu não entendi o que você disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            querSair = irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("observar")) {
            observar();
        }
        else if (palavraDeComando.equals("pegar")) {
            pegarItem(comando);
        }
        else if (palavraDeComando.equals("usar")) {
            usarItem(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("comer")){
            comer(comando);
        }
        else if (palavraDeComando.equals("largar")){
            largarItem(comando);
        }
        else if (palavraDeComando.equals("atacar")){
            atacar(comando);
        }
        else if (palavraDeComando.equals("conversar")){
            conversar(comando);
        }
        else if (palavraDeComando.equals("historico")){
            obterHistoricoJogo();
        }

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        ui.continuarMensagem("Você deve encontrar a chave do carro");
        ui.continuarMensagem("em meio a guerra.");
        ui.continuarMensagem("");
        ui.continuarMensagem("Suas palavras de comando sao:");
        ui.continuarMensagem(analisador.mostrarComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private boolean irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Ir pra onde?");
            return false;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        // Pontos de energia que o jogador perde ao se movimentar.
        int energiaGasta = 1;

        if (proximoAmbiente == null) {
            ui.continuarMensagem("A passagem está bloqueada ou não há passagem!");
        }
        // tratando quando a missão do jogo for concluída
        else if(proximoAmbiente == ambienteFinal ){ 
            soldado.andar();
            ambienteAtual = proximoAmbiente;
            ui.ambienteAtualMudou(ambienteAtual);
            ui.continuarMensagem("Parabéns! você chegou em casa e venceu o jogo.");
            ui.continuarMensagem("Até a próxima Soldado!");
            salvarJogo();
            return true;
        }
        else {
            soldado.gastarEnergia(energiaGasta);
            soldado.andar();
            ui.exibirMensagem("Você gastou " + energiaGasta + " ponto(s) de energia ao se movimentar! Restam: [" + soldado.getEnergia() + "]");
            if (ambienteAtual.temPersonagem()) {
                int dano = ambienteAtual.getDanoInimigos();
                if (dano > 0) {
                    soldado.gastarEnergia(dano);
                    ui.continuarMensagem("Você foi atacado por " + ambienteAtual.consultarInimigos() + "! Que te tiraram " + dano + " ponto(s) de energia! Restam: [" + soldado.getEnergia() + "]");
                }
            }
            if (soldado.estaVivo()) {
                ambienteAtual = proximoAmbiente;
                ui.ambienteAtualMudou(ambienteAtual);
                exibirAmbienteAtual();
            } else {
                ui.continuarMensagem("GAME OVER: Você morreu pois seus pontos de energia acabaram!");
                return true;
            }

        }

        return false;
    }

    private void exibirAmbienteAtual() {
        ui.continuarMensagem(ambienteAtual.getDescricaoLonga());
    }

    /* 
     * Método auxiliar que faz a exibição do conteúdo da mochila.
     */
    private void exibirMochila() {
        if (soldado.temItem()) {
            ui.continuarMensagem("Sua mochila tem: " + soldado.getItensDaMochila());
        } else {
            ui.continuarMensagem("Sua mochila esta vazia!");
        }
        ui.continuarMensagem("Ocupação da mochila: [" + soldado.getOcupacaoMochila() + "/" + soldado.getCapacidadeMochila() + "]");
    }

    /* 
     * Método auxiliar para impressão da Enegia do jogador (que é a vida e potuação do jogo)
     */
    private void exibirStatus() {
        ui.continuarMensagem("Você tem " + soldado.getEnergia() + " pontos de energia!");
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            ui.continuarMensagem("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }

    /*
     * Método que faz a exibição de todas as informações que o jogador precisa.
     * Ambiente, Mochila, Npc's, Saídas, etc
     */

    private void observar(){
        ui.exibirMensagem("Observando...");
        exibirStatus();
        exibirMochila();
        exibirAmbienteAtual();
    }

    /*
     * Confere se tem item no ambiente. Se tiver, retira o item do ambiente
     * e insere na mochila. Caso não haver item ou o item descrito não tiver
     * no local, imprime mensagem de erro.
     */
    private void pegarItem(Comando comando)  {
        // se não há segunda palavra, não sabemos o que pegar...
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Pegar o que?");
            return;
        }

        String itemRequerido = comando.getSegundaPalavra(); // Pega o nome do item digitado
        
        if(ambienteAtual.temItem()){ // Confiro se o ambiente tem algum item

            if(ambienteAtual.consultarItens().contains(itemRequerido)){ // Se o digitado for igual ao item do ambiente
                Item item = ambienteAtual.getItem(itemRequerido);
                if (item == null) {
                    ui.continuarMensagem("Digite o nome do item corretamente!");
                    return;
                }
                if(!item.isCarregavel()){ // se o item for a fruta, não é possível carregar
                    ui.continuarMensagem("Não é possível carregar esse item!");
                }else{ // se o item não for uma fruta, coleta e insere na mochila
                    Item itemPegar = ambienteAtual.getItem(itemRequerido);// Item é pego
                    if (soldado.inserirItem(itemPegar)) { // Coloca o item na mochila e verifica se a mochila não está cheia.
                        ambienteAtual.coletarItem(itemRequerido); // Remove o item do ambiente.
                        ui.continuarMensagem("Item coletado!");
                        ui.jogadorPegouItem(itemPegar);
                    }else{
                        ui.continuarMensagem("Sua mochila está cheia você pode carregar até " + soldado.getCapacidadeMochila() + " itens!");
                    }
                    
                }
            }else{// se o item digitado não estiver no ambiente
                ui.continuarMensagem("Esse item não está no ambiente!");
            } 
            
        }else{
            ui.continuarMensagem("Esse ambiente não tem item!");
        }
    }

    /**
     * Método que trata o comando largar.
     */
    private void largarItem(Comando comando) {
        // se não há segunda palavra, não sabemos o que largar...
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Largar o que?");
            return;
        }

        String itemNome = comando.getSegundaPalavra();

        if(soldado.estaNaMochila(itemNome) == true){
            Item item = soldado.removerItem(itemNome);
            ambienteAtual.colocarItem(item);
            ui.continuarMensagem("Você largou um(a) " + item.getNome() + " no chão!");
            ui.jogadorDescartouItem(item);
        }else {
            ui.continuarMensagem("Esse item não está na sua mochila!");
        }
    }

    /**
     * Método que trata o comando usar.
     */
    private void usarItem(Comando comando)  {
        // se não há segunda palavra, não sabemos o que usar...
        if(!comando.temSegundaPalavra()) {     
            ui.continuarMensagem("Usar o que?");
            return;
        }

        String itemRequerido = comando.getSegundaPalavra();

        if(soldado.estaNaMochila(itemRequerido) == true){ // Se o item a ser usado está na mochila
            Item item = soldado.getItem(itemRequerido);
            if(ambienteAtual.usarItem(item)){ // Se o item a ser usado é o correto
                soldado.removerItem(itemRequerido); // Remove da mochila
                ui.continuarMensagem("Passagem desbloqueada!");
                ui.jogadorDescartouItem(item);
            }else{
                ui.continuarMensagem("Esse item não desbloqueia a passagem!");
            }
        }else{
            ui.continuarMensagem("Você não tem esse item!");
        }
    }

    /**
     * Método que trata o comando comer.
     */
    private void comer(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Comer o que?");
            return;
        }

        String itemRequerido = comando.getSegundaPalavra();

        if (soldado.temItem()) { // Verifica se a mochila não esta vazia
            if(soldado.estaNaMochila(itemRequerido)){ // Se o item a ser consumido está na mochila
                Item item = soldado.getItem(itemRequerido);
                if (item.isComestivel()) {
                    soldado.removerItem(itemRequerido); // Remove o item comestivel da mochila
                    int pontosEnergia = item.getEnergia();
                    soldado.reporEnergia(pontosEnergia);
                    ui.continuarMensagem("Você comeu um(a) " + item.getNome() + "! E recuperou " + pontosEnergia + " pontos de energia!");
                    ui.jogadorDescartouItem(item);
                }else{
                    ui.continuarMensagem("Esse item não é comestivel!");
                }

            }else{
                ui.continuarMensagem("Você não tem esse item!");
            } 
            
        }else{
            ui.continuarMensagem("Sua mochila esta vazia!");
        }

    }

    /**
     * Método que trata o comando atacar.
     */
    private void atacar(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Atacar quem?");
            return;
        }

        String personagemRequerido = comando.getSegundaPalavra();

        if (ambienteAtual.temPersonagem()) { // Verifica se o ambiente tem personagem
            Personagem personagem = ambienteAtual.getPersonagem(personagemRequerido);

            if (personagem == null) {
                ui.continuarMensagem("Essa pessoa não esta aqui!");
                return;
            }

            if (personagem.isAmigo()) {
                ui.continuarMensagem("Você não pode atacar seu amigo!");
                return;
            } 

            ui.continuarMensagem("Digite o nome da arma que deseja usar para atacar");
            String nomeArma = ui.obterComando();

            if (soldado.estaNaMochila(nomeArma)) {
                boolean ehArma = soldado.getItem(nomeArma).getTipo().equals("arma");
                if (ehArma) {
                        Item item = soldado.removerItem(nomeArma); // Remove a arma da mochila e usa ela
                        ambienteAtual.eliminarPersonagem(personagemRequerido); // Elemina o personagem
                        soldado.eliminou(); // Incrementa o score kills
                        ui.continuarMensagem("Você matou " + personagem.getNome() + "! E gastou sua/seu " + nomeArma + " durante o combate! Eliminações [" + soldado.getEliminacoes() + "]"); 
                        ui.jogadorDescartouItem(item);
                }else{
                    ui.continuarMensagem("Isso não é uma arma!");
                }
            }else{
                ui.continuarMensagem("Você não tem essa arma!");
            }
        }else{
            ui.continuarMensagem("Não tem ninguém aqui!");
        }

    }

    /**
     * Método que trata o comando conversar.
     */
    private void conversar(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            ui.continuarMensagem("Conversar com quem?");
            return;
        }

        String personagemRequerido = comando.getSegundaPalavra();

        if (ambienteAtual.temPersonagem()) { // Verifica se o ambiente tem personagem
            Personagem personagem = ambienteAtual.getPersonagem(personagemRequerido);

            if (personagem != null) {
                ui.continuarMensagem("Essa pessoa diz: \"" + personagem.getMensagem() + "\"");
            }else{
                ui.continuarMensagem("Essa pessoa não esta aqui!");
            }
            
        }else{
            ui.continuarMensagem("Não tem ninguém aqui!");
        }
    }

    /**
     * Salva os dados da partida ao finalizar o jogo (registrando o "placar").
     */
    private void salvarJogo() {
        String historicoAntigo = "";
        
        try {
            BufferedReader arqLeitura = new BufferedReader(new FileReader("historico_jogador.txt"));
           
            String linha = arqLeitura.readLine();
           
            while (linha != null) {
                historicoAntigo += linha + "\n";
            
                linha = arqLeitura.readLine();
            }

            arqLeitura.close();
        } catch (Exception e) {}


        try {   
            BufferedWriter arqEscrita = new BufferedWriter(new FileWriter("historico_jogador.txt"));

            arqEscrita.write(historicoAntigo);

            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            arqEscrita.write("Finalizado em: " + timeStamp + " | Movimentos: " + soldado.getPassos() + " | Pontos de energia: "
            + soldado.getEnergia() + " | Inimigos eliminados: " + soldado.getEliminacoes() + "\n");
            
            arqEscrita.close();
        }
        catch (Exception e) {
            ui.continuarMensagem("Falha ao salvar o jogo!");
        }

    }

    /**
     * Lista o historico de partidas concluidas
     */
    private void obterHistoricoJogo() {
        try {
            BufferedReader arq = new BufferedReader(new FileReader("historico_jogador.txt"));
           
            String linha = arq.readLine();
           
            while (linha != null) {
                ui.continuarMensagem(linha);
            
                linha = arq.readLine();
            }
            arq.close();
        }
        catch (Exception e) {
            ui.continuarMensagem("Não há historico de antigas partidas!");
        }
    }
}