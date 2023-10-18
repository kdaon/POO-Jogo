package br.ufla.gac106.s2022_1.seuJogo;


import java.io.IOException;

import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;


public class Jogo {
    private static Jogo instanciaUnica;
    private Analisador analisador;
    private Jogador jogador;
    private int numeroMaximoMovimentacoes = 30;
    private int passoParaCompletarJogo = 0;
    private boolean completouOJogo = false;
    private InterfaceUsuario interfaceUser;
    private Arquivo arquivo;
    private Jogo(InterfaceUsuario interfaceUser){

        jogador = new Jogador("Marty Mcfly");
        criarAmbientes();
        analisador = new Analisador();
        this.interfaceUser = interfaceUser;
        arquivo = new Arquivo("Recorde");

    }
    public static Jogo getInstancia(InterfaceUsuario interfaceUser){
        if(instanciaUnica == null){
            instanciaUnica = new Jogo(interfaceUser);
        }
        return instanciaUnica;
    }

    private void criarAmbientes() {
        Ambiente casaDoc, cafeteria, poraoCasaDoc, lojaEspelhos, vilaMedieval, acampamentoMilitarMedieval, castelo, estabulo, caverna,
                triboNeandertais, floresta, rio;

        Item bateriaDePlutonio = new Item("Bateria-de-Plutonio","Pode desbloquear uma passagem que leva ao futuro ou passado",true,"Imagens/imagensItens/BateriaDePlutonio.png");
        Item carne = new Item("Carne","Pode ser usado para distrair um Dinossauro",true,"Imagens/imagensItens/Carne.png");
        Item espelho = new Item("Espelho","Pode ser usado para entrar na tribo dos Neandertais",true,"Imagens/imagensItens/Espelho.png");
        Item chaveDelorean = new Item("Chave-da-Delorean","Chave da máquina do tempo",true,"Imagens/imagensItens/ChaveDADelorean.png");
        Item caixaFerramentas = new Item("Caixa-de-ferramentas","Usada na cafeteria para ganhar Dinheiro com o NPC da cafeteria",true,"Imagens/imagensItens/CaixaDeFerramentas.png");
        Item dinheiro = new Item("Dinheiro","Pode ser usado para comprar o espelho com a NPC da loja",true,"Imagens/imagensItens/Dinheiro.png");
        Item delorean = new Item("Delorean","Máquina do tempo",false,"Imagens/imagensItens/Espelho.png");
        Item chaveEstabulo = new Item("Chave-do-Estabulo", "Parece ser a chave para abrir o estabulo no castelo!",true,"Imagens/imagensItens/ChaveEstabulo.png");
        Personagem vendedoraEspelho = new Personagem("Vendedora-de-espelhos",
                "Esses espelhos são bem chamativos, posso troca-los por dinheiro!", espelho, "Dinheiro");
        Personagem jenny = new Personagem("Jenny", "O Doc sumiu!");
        Personagem donoDaCafeteria = new Personagem("Dono-da-cafeteria", "Troco caixa de ferramentas por dinheiro!", dinheiro,"Caixa-de-ferramentas");
        Personagem mulherDaVila = new Personagem("Mulher-da-Vila", "Algo caiu do céu no estábulo do castelo do Rei!");
        Personagem homemDasCavernas = new PersonagemInimigo("Homem-das-avernas", "Buga buga", "Espelho", Direcao.LESTE);
        Personagem dinossauro = new PersonagemInimigo("Dinossauro", "Grrrr Grrr","Carne", Direcao.OESTE);
        Personagem doc = new Personagem("Doc", "Finalmente Marty, essa confusão que aconteceu tem tantos paradoxos que nem tenho tempo de explicar, Vamos de volta para o futuro!!");

        casaDoc = new AmbientePossuiPersonagem("Você está na casa do Doc", chaveDelorean, delorean, jenny,"Imagens/imagensAmbiente/CasaDoDoc.png");
        cafeteria = new AmbientePossuiPersonagem("Você está na cafeteria", donoDaCafeteria,"Imagens/imagensAmbiente/Cafeteria.png");
        poraoCasaDoc = new Ambiente("Você está no porão da casa do Doc", caixaFerramentas,"Imagens/imagensAmbiente/Porao.png");
        lojaEspelhos = new AmbientePossuiPersonagem("Você está na loja de espelhos", vendedoraEspelho,"Imagens/imagensAmbiente/LojaDeEspelhos.png");
        vilaMedieval = new AmbientePossuiPersonagem("Você está em uma vila medieval",delorean, mulherDaVila,"Imagens/imagensAmbiente/VilaMedieval.png");
        acampamentoMilitarMedieval = new Ambiente("Você está no acampamento de soldados medievais",chaveEstabulo,"Imagens/imagensAmbiente/AcampamentoMilitarMedieval.png");
        castelo = new Ambiente("Você está no castelo","Imagens/imagensAmbiente/CasteloMedieval.png");
        estabulo = new Ambiente("Você está no estabulo", bateriaDePlutonio,"Imagens/imagensAmbiente/Estabulo.png");
        caverna = new AmbientePossuiPersonagem("Você está na caverna",delorean, homemDasCavernas,"Imagens/imagensAmbiente/Caverna.png");
        triboNeandertais = new Ambiente("Você está na tribo Neandertais", carne,"Imagens/imagensAmbiente/TriboHomensDasCavernas.png");
        floresta = new AmbientePossuiPersonagem ("Você está na floresta", delorean, dinossauro,"Imagens/imagensAmbiente/FlorestaDino.png");
        rio = new AmbientePossuiPersonagem("Você está no rio", doc,"Imagens/imagensAmbiente/Rio.png");

        casaDoc.ajustarSaidaBloqueada(Direcao.PASSADO.getDescricao(), vilaMedieval, "Chave-da-Delorean","Você Precisa da Chave da Delorean para liga-la!");
        casaDoc.ajustarSaida(Direcao.LESTE.getDescricao(), lojaEspelhos);
        casaDoc.ajustarSaida(Direcao.OESTE.getDescricao(), cafeteria);
        casaDoc.ajustarSaida(Direcao.BAIXO.getDescricao(), poraoCasaDoc);
        poraoCasaDoc.ajustarSaida(Direcao.CIMA.getDescricao(), casaDoc);

        cafeteria.ajustarSaida(Direcao.LESTE.getDescricao(), casaDoc);

        lojaEspelhos.ajustarSaida(Direcao.OESTE.getDescricao(), casaDoc);

        vilaMedieval.ajustarSaida(Direcao.FUTURO.getDescricao(), casaDoc);
        vilaMedieval.ajustarSaida(Direcao.PASSADO.getDescricao(), caverna);
        vilaMedieval.ajustarSaida(Direcao.NORTE.getDescricao(), acampamentoMilitarMedieval);
        vilaMedieval.ajustarSaida(Direcao.OESTE.getDescricao(), castelo);

        acampamentoMilitarMedieval.ajustarSaida(Direcao.SUL.getDescricao(), vilaMedieval);
        castelo.ajustarSaidaBloqueada(Direcao.OESTE.getDescricao(), estabulo,"Chave-do-Estabulo","A porta está trancada preciso de uma chave!");
        castelo.ajustarSaida(Direcao.LESTE.getDescricao(), vilaMedieval);

        estabulo.ajustarSaida(Direcao.LESTE.getDescricao(), castelo);

        caverna.ajustarSaida(Direcao.FUTURO.getDescricao(), vilaMedieval);
        caverna.ajustarSaidaBloqueada(Direcao.PASSADO.getDescricao(), floresta, "Bateria-de-Plutonio", 
        "A Delorean não tem energia suficiente para voltar a um passado tão distante assim, se tivesse alguma coisa que desse energia a ela!");
        caverna.ajustarSaida(Direcao.LESTE.getDescricao(), triboNeandertais);

        triboNeandertais.ajustarSaida(Direcao.OESTE.getDescricao(), caverna);

        floresta.ajustarSaida(Direcao.FUTURO.getDescricao(), caverna);
        floresta.ajustarSaida(Direcao.OESTE.getDescricao(), rio);

        rio.ajustarSaida(Direcao.LESTE.getDescricao(), floresta);

        jogador.setAmbienteAtual(casaDoc);
    }

    public void jogar() {
        imprimirBoasVindas();

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando(interfaceUser.obterComando());
            terminado = processarComando(comando);
        }
        interfaceUser.continuarMensagem("Obrigado por jogar. Até mais!");
    }

    private void imprimirBoasVindas() {
        String mensagem = "\n";
        mensagem += "Bem-vindo a um novo tempo!";
        mensagem += "De volta ao futuro é um novo jogo de aventura que nos dá o poder de viajar no tempo!"+"\n";
        mensagem += "Você é Marty Mcfly sua missão é resgatar o seu Amigo Doc!"+"\n";
        mensagem += "Porem você esta ficando sem tempo você só pode mudar de ambiente 30 vezes"+"\n";
        mensagem += "Digite 'ajuda' se voce precisar de ajuda."+"\n";
        mensagem += "Recorde Atual em passos é: "+ arquivo.carregamento() + "\n";
        interfaceUser.continuarMensagem(mensagem);
        imprimirLocalizacaoAtual();
    }

    private void observar() {
        imprimirLocalizacaoAtualLonga();
    }

    private void pegar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Pegar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();
        Item itemAux = null;
        if (jogador.getAmbienteAtual().temItem()) {
            itemAux = jogador.getAmbienteAtual().getItem(nomeItem);
            if(itemAux != null){
                if(itemAux.eItemCarregavel()){
                    if (jogador.adicionaItem(itemAux)) {
                        jogador.getAmbienteAtual().removerItem(nomeItem);
                        interfaceUser.jogadorPegouItem(itemAux);
                        // passar esse print para o terminal
                        interfaceUser.continuarMensagem("Você pegou o item: " + nomeItem);
                        ChecarPassosCompletouJogo(nomeItem);
                    } else {
                        interfaceUser.continuarMensagem(
                                "Você já está carregando " + jogador.getNomeItensEstaCarregando() + " Tente larga-lo no chão!");
                    }
                }else{
                    interfaceUser.continuarMensagem("Você não pode carregar esse item: " + nomeItem);
                }
            }else{
                interfaceUser.continuarMensagem("O item não está no ambiente!");
            }
        } else {
            interfaceUser.continuarMensagem("Não tem nenhum item no chão desse ambiente!");
        }
    }

    private void largar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Largar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();

        if (jogador.temItem()) {
            Item item = jogador.retornaItemPeloNome(nomeItem);
            if (item != null) {
                interfaceUser.jogadorDescartouItem(item);
                jogador.removeItem(item.getNome());
                jogador.getAmbienteAtual().adicionarItem(item);
                interfaceUser.continuarMensagem("Você largou " + item.getNome() + " no chão!");
            } else {
                interfaceUser.continuarMensagem("Você não está carregando esse item!");
            }
        } else {
            interfaceUser.continuarMensagem("Você não está carregando nada!");
        }

    }

    private void conversar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Conversar com quem o que?");
            return;
        }

        String nomePersonagen = comando.getSegundaPalavra();

        if (jogador.getAmbienteAtual().verificaPersonagemAmbiente()) {
            if (nomePersonagen.equals(jogador.getAmbienteAtual().getPersonagem().getNome())) {
                interfaceUser.continuarMensagem(jogador.getAmbienteAtual().getPersonagem().getNome() +" Disse: " + jogador.getAmbienteAtual().getPersonagem().getFala());
                ChecarPassosCompletouJogo(nomePersonagen);
            } else {
                interfaceUser.continuarMensagem("Não tem ninguem com esse nome por aqui!");
            }
        } else {
            interfaceUser.continuarMensagem("Não tem ninguem aqui...");
        }

    }

    private void trocar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Trocar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();

        if (jogador.temItem()) {
            Item item = jogador.retornaItemPeloNome(nomeItem);
            if (item != null) {
                Item itemTroca = jogador.getAmbienteAtual().getPersonagem().trocar(nomeItem);
                if(itemTroca != null){
                    interfaceUser.jogadorDescartouItem(item);
                    jogador.removeItem(item.getNome());
                    jogador.adicionaItem(itemTroca);
                    interfaceUser.jogadorPegouItem(itemTroca);
                    interfaceUser.continuarMensagem("Você recebeu:"+ itemTroca.getNome());
                }else{
                    interfaceUser.continuarMensagem(jogador.getAmbienteAtual().getPersonagem().getFala());
                }
            } else {
                interfaceUser.continuarMensagem("Você não está carregando esse item!");
            }
        } else {
            interfaceUser.continuarMensagem("Você não está carregando nada!");
        }

    }

    private boolean processarComando(Comando comando) {
        boolean querSair = false;
        if(completouOJogo == true){
            querSair = true;
        }
        if (comando.ehDesconhecido()) {
            interfaceUser.continuarMensagem("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            querSair = irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")) {
            observar();
        } else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        } else if (palavraDeComando.equals("usar")) {
            usarItem(comando);
        } else if (palavraDeComando.equals("largar")) {
            largar(comando);
        } else if (palavraDeComando.equals("conversar")) {
            conversar(comando);
        }
        else if (palavraDeComando.equals("trocar")) {
            trocar(comando);
        }
        return querSair;
    }

    private void usarItem(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Usar o que?"+"\n");
            return;
        }
        String nomeItem = comando.getSegundaPalavra();
        Item itemAux;
        itemAux = jogador.retornaItemPeloNome(nomeItem);
        if (itemAux != null) {
            if (jogador.getAmbienteAtual().usarItem(itemAux)) {
                interfaceUser.continuarMensagem("Você desbloqueou a passagem"+"\n");
                interfaceUser.jogadorDescartouItem(itemAux);
                jogador.removeItem(nomeItem);
            } else if(jogador.getAmbienteAtual().getPersonagem().usarItem(nomeItem)){
                interfaceUser.jogadorDescartouItem(itemAux);
                jogador.removeItem(nomeItem);
                jogador.getAmbienteAtual().InimigoMorreu();
                interfaceUser.continuarMensagem("Você derrotou o inimigo agora poderar passar!"+"\n");
            }
            else {
                interfaceUser.continuarMensagem("Esse item não pode ser usado aqui!"+"\n");
            }
        } else {
            interfaceUser.continuarMensagem("O Jogador não tem esse item!"+"\n");
        }
    }

    private void imprimirAjuda() {
        String ajuda = "\n";
        ajuda = ajuda +"Você precisa salvar o Doc antes que o tempo acabe!"+"\n";
        ajuda = ajuda + "max 30 passos passos dados: "+jogador.getcontadorMovimentacoes()+"\n";
        ajuda = ajuda + "Suas palavras de comando são:"+"\n";
        ajuda = ajuda + "->  " + analisador.palavrasComando()+"\n";
        interfaceUser.continuarMensagem(ajuda);
    }

    private boolean verificaNumeroMovimentacoes() {
        return jogador.getcontadorMovimentacoes() < numeroMaximoMovimentacoes;
    }

    private void mensagemDerrota() {
        interfaceUser.continuarMensagem("Numero de passos maximos atingidos! \n Infelizmente você perdeu o jogo! Tente novamente!"+"\n");
    }
    private void mensagemVitoria() {
        interfaceUser.continuarMensagem("Parabens você salvou o Doc a tempo e completou o jogo!"+"\n");
    }

    private boolean irParaAmbiente(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Ir pra onde?");
            return false;
        }
        boolean inimigoNaoBloqueiaPassagem = true;
        String direcao = comando.getSegundaPalavra();
        inimigoNaoBloqueiaPassagem = checarSeInimigobloqueiaPassagem(direcao);

        if(inimigoNaoBloqueiaPassagem){
            Ambiente proximoAmbiente = jogador.getAmbienteAtual().getAmbiente(direcao);

            if (proximoAmbiente == null && jogador.getAmbienteAtual().verificaSaidaBloqueada(direcao)) {
                interfaceUser.continuarMensagem(jogador.getAmbienteAtual().getfraseBloqueio());

            } else if (proximoAmbiente == null) {
                interfaceUser.continuarMensagem("Nao ha passagem!");

            } else {
                if (verificaNumeroMovimentacoes()) {
                    jogador.setAmbienteAtual(proximoAmbiente);
                    imprimirLocalizacaoAtual();
                    jogador.incrementarContadorMovimentos();
                    return false;
                } else {
                    mensagemDerrota();
                    return true;
                }
            }
        }else{
            interfaceUser.continuarMensagem("O "+jogador.getAmbienteAtual().getPersonagem().getNome()+ " não vai te deixar passar");
            interfaceUser.continuarMensagem("Ele diz:  "+jogador.getAmbienteAtual().getPersonagem().getFala());
            return false;
        }
        return false;
    }

    private void imprimirLocalizacaoAtualLonga() {
        interfaceUser.continuarMensagem(jogador.getAmbienteAtual().getDescricaoLonga());
        interfaceUser.ambienteAtualMudou(jogador.getAmbienteAtual());
        imprimirSaidas();
        if (jogador.getNomeItensEstaCarregando() != null) {
            interfaceUser.continuarMensagem("Itens carregados: " + jogador.getNomeItensEstaCarregando());
        } else {
            interfaceUser.continuarMensagem("Nenhum item está sendo carregado!"+ "\n");
        }
    }

    private void imprimirLocalizacaoAtual() {
        interfaceUser.continuarMensagem(jogador.getAmbienteAtual().getDescricao()+"\n");
        interfaceUser.ambienteAtualMudou(jogador.getAmbienteAtual());
        imprimirSaidas();
    }

    private void imprimirSaidas() {
        String saidas = "Saidas: ";
        saidas = saidas + jogador.getAmbienteAtual().getSaidas();
        saidas = saidas + "\n";
        interfaceUser.continuarMensagem(saidas);
    }

    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            interfaceUser.continuarMensagem("Sair o que?"+"\n");
            return false;
        } else {
            return true;
        }
    }

    private void ChecarPassosCompletouJogo(String passo){
        
        if(passo.equals("Chave-da-Delorean") && passoParaCompletarJogo == 0){
            passoParaCompletarJogo = passoParaCompletarJogo + 1;

        }
        if(passo.equals("Bateria-de-Plutonio") && passoParaCompletarJogo == 1){
            passoParaCompletarJogo = passoParaCompletarJogo + 1;
        }
        if(passo.equals("Doc") && passoParaCompletarJogo == 2){
            passoParaCompletarJogo = passoParaCompletarJogo + 1;
        }
        if(passoParaCompletarJogo == 3){
            mensagemVitoria();
            salvarRecorde();
            completouOJogo = true;
        }
    }

    private Boolean checarSeInimigobloqueiaPassagem(String passagem){
        if(jogador.getAmbienteAtual().getPersonagem() != null){
            if(jogador.getAmbienteAtual().getPersonagem().naoBloqueiaEssaPassagem(passagem)){
                return true;
            }
            return false;
        }
        return true;
    }

    private void salvarRecorde(){
        int recorde = Integer.valueOf(arquivo.carregamento());
        if(recorde > jogador.getcontadorMovimentacoes()){
            recorde = jogador.getcontadorMovimentacoes();
        }
        try {
            arquivo.salvar(Integer.toString(recorde));
        } catch (IOException e) {
            interfaceUser.exibirMensagem("Erro ao salvar recorde!");
        }
    }
}
