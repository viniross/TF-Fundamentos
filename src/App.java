import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int totalEventos = 0;
        Evento[] listaEventos = new Evento[100];

        //variaveis evento
        String codigo;
        String nomeEvento;
        String tipo;
        double precoBaseInscricao;
        LocalDate dataInicial;
        LocalDate dataFinal;
        int quantSalas;
        Sala[] listaSalas;
        int quantInscricoes;
        int inscricoesCadastradas = 0;
        Inscricao[] listaInscricoes = new Inscricao[100];

        //variaveis inscricao
        String identificacaoInscricao;
        String nomeInscricao;
        int categoria;
        String cpf;
        String cargo;
        String instituicao;
        double preco;

        //variaveis sala
        String identificacaoSala;
        String localizacao;
        int lotacaoMaxima;
        double valorLocacao;

        //variaveis para o switch case
        int acaoPrincipal = 0;
        int acaoCadastro = 0;
        int acaoConsulta = 0;
        int acaoConsultaEvento = 0;
        int acaoConsultaInscricaoEvento = 0;
        int acaoConsultaInscricao = 0;

        while (acaoPrincipal != 3) {
            menuPrincipal();
            acaoPrincipal = in.nextInt();

            switch (acaoPrincipal) {
                case 1: 
                    menuCadastro();
                    acaoCadastro = in.nextInt();
                    switch (acaoCadastro) {
                        case 1:
                            System.out.println("Digite o nome do Evento:");
                            in.nextLine();
                            nomeEvento = in.nextLine();

                            System.out.println("Digite o tipo do Evento:");
                            tipo = in.nextLine();

                            System.out.println("Digite o valor do Evento:");
                            precoBaseInscricao = in.nextDouble();
                            in.nextLine();

                            System.out.println("Digite a data inicial (DD/MM/AAAA):");
                            String dataInicialStr = in.nextLine();
                            dataInicial = LocalDate.parse(dataInicialStr, formatter);

                            System.out.println("Digite a data final (DD/MM/AAAA):");
                            String dataFinalStr = in.nextLine();
                            dataFinal = LocalDate.parse(dataFinalStr, formatter);

                            System.out.println("Digite a quantidade de salas:");
                            quantSalas = in.nextInt();
                            in.nextLine();

                            Evento evento = new Evento(nomeEvento, tipo, precoBaseInscricao, dataInicial, dataFinal, quantSalas);
                            listaEventos[totalEventos] = evento;
                            totalEventos++;

                            System.out.println("Evento cadastrado com sucesso!");

                            System.out.println("Informações do Evento:");
                            System.out.println("Código: " + evento.getCodigo());
                            System.out.println("Nome do Evento: " + nomeEvento);
                            System.out.println("Tipo do Evento " + tipo);
                            System.out.println("Data Inicial: " + dataInicial);
                            System.out.println("Data Final: " + dataFinal);
                            System.out.println("Quantidade de Salas: " + quantSalas);
                            break;

                        case 2:
                            System.out.println("Digite o código do evento:");
                            in.nextLine();
                            codigo = in.nextLine();
                                    
                            evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                            System.out.println("Digite seu Nome:");
                            in.nextLine();
                            nomeInscricao = in.nextLine();

                            System.out.println("Escolha a sua Categoria:");
                            menuCategoria();
                            categoria = in.nextInt();

                            System.out.println("Digite seu CPF:");
                            in.nextLine();
                            cpf = in.nextLine();

                            System.out.println("Digite seu Cargo:");
                            cargo = in.nextLine();

                            System.out.println("Digite sua instituicao:");
                            instituicao = in.nextLine();

                            Inscricao novaInscricao = new Inscricao(nomeInscricao, categoria, cpf, cargo, instituicao, evento.getPrecoBaseInscricao());
                            boolean adicionada = evento.addInscricao(novaInscricao);

                            if (adicionada) {
                                System.out.println("Informações da Inscrição:");
                                System.out.println("Identificação da Inscrição: " + novaInscricao.getIdentificacaoInscricao());
                                System.out.println("Nome: " + nomeInscricao);
                                System.out.println("Categoria: " + categoria);
                                System.out.println("CPF: " + cpf);
                                System.out.println("Cargo: " + cargo);
                                System.out.println("Instituição: " + instituicao);
                            } else {
                                System.out.println("Não foi possível adicionar a inscrição. Limite de inscrições atingido!");
                            }

                            System.out.println("Informações da Inscrição:");
                            System.out.println("Identificação da Inscrição: " + novaInscricao.getIdentificacaoInscricao());
                            System.out.println("Nome: " + nomeInscricao);
                            System.out.println("Categoria: " + categoria);
                            System.out.println("CPF: " + cpf);
                            System.out.println("Cargo: " + cargo);
                            System.out.println("Instituição: " + instituicao);
                            break;

                        case 3:
                            System.out.println("Voltando ao menu principal...");
                            break;

                        default:
                            System.out.println("Opção inválida no menu de cadastro.");
                    }
                    break;

                case 2: // Consulta
                    menuConsulta();
                    acaoConsulta = in.nextInt();
                    switch (acaoConsulta) {
                        case 1:
                            menuConsultaEvento();
                            acaoConsultaEvento = in.nextInt();
                            switch (acaoConsultaEvento) {
                                case 1:
                                    System.out.println("Digite o código do evento para adicionar uma sala");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    Evento evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    if (evento == null) {
                                        System.out.println("Evento não encontrado!");
                                        break;
                                    }

                                    System.out.println("Digite a Identificação da Sala:");
                                    identificacaoSala = in.nextLine();
                                    in.nextLine();

                                    System.out.println("Digite a Localização da Sala:");
                                    localizacao = in.nextLine();

                                    System.out.println("Digite a Lotação Máxima da Sala:");
                                    lotacaoMaxima = in.nextInt();

                                    System.out.println("Digite o Valor da Locação da Sala:");
                                    valorLocacao = in.nextDouble();

                                    Sala novaSala = new Sala(identificacaoSala, localizacao, lotacaoMaxima, valorLocacao);
                                    evento.addSala(novaSala);

                                    System.out.println("Informações da Sala");
                                    System.out.println("Identificação da Sala: " + novaSala.getIdentificacaoSala());
                                    System.out.println("Localização: " + localizacao);
                                    System.out.println("Lotação Máxima: " + lotacaoMaxima);
                                    System.out.println("Valor da Locação da Sala: " + valorLocacao);
                                    break;

                                case 2: //remove sala
                                    System.out.println("Digite o código do evento para remover uma sala");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Digite a Identificação da Sala:");
                                    identificacaoSala = in.nextLine();

                                    evento.removeSala(identificacaoSala);
                                    break;

                                case 3: //procura lotacao maxima
                                    System.out.println("Digite o código do evento para procurar a sala pela sua lotação máxima");
                                    in.nextLine();
                                    codigo = in.nextLine();

                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Digite a Lotação Máxima da Sala:");
                                    lotacaoMaxima = in.nextInt();

                                    Sala[] salasEncontradas = evento.buscaSalasPorLotacao(lotacaoMaxima);
                                    if (salasEncontradas.length == 0) {
                                        System.out.println("Nenhuma sala encontrada com essa lotação máxima.");
                                    } else {
                                        System.out.println("Salas encontradas:");
                                        for (Sala sala : salasEncontradas) {
                                            if (sala != null) {
                                                System.out.println("Identificação: " + sala.getIdentificacaoSala() + 
                                                                ", Lotação: " + sala.getLotacaoMaxima() + 
                                                                ", Localização: " + sala.getLocalizacao() + 
                                                                ", Valor Locação: " + sala.getValorLocacao());
                                            }
                                        }
                                    }
                                    break;

                                case 4: // procura sala ident
                                    System.out.println("Digite o código do evento para procurar a sala por sua identificação");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Digite a Identificação da Sala:");
                                    identificacaoSala = in.nextLine();

                                    Sala salaEncontrada = evento.buscaSalaPorIdentificacao(identificacaoSala);

                                    if (salaEncontrada != null) {
                                        System.out.println("Sala encontrada:");
                                        System.out.println("Identificação: " + salaEncontrada.getIdentificacaoSala());
                                        System.out.println("Localização: " + salaEncontrada.getLocalizacao());
                                        System.out.println("Lotação Máxima: " + salaEncontrada.getLotacaoMaxima());
                                        System.out.println("Valor de Locação: " + salaEncontrada.getValorLocacao());
                                    } else {
                                        System.out.println("Sala não encontrada.");
                                    }
                                    break;

                                case 5: //quant salas alocadas
                                    System.out.println("Digite o código do evento saber a quantidade de salas alocadas");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Quantidade de Salas Alocadas: " + evento.quantSalasAlocadas());
                                    break;

                                case 6: //quant pessoas inscritas
                                    System.out.println("Digite o código do evento para saber a quantidade de pessoas inscritas");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Quantidade de Pessoas Inscritas: " + evento.quantInscritos());
                                    break;

                                case 7: //quant pessoas inscritas por cat
                                    System.out.println("Digite o código do evento para saber a quantidade de pessoas inscritas por categoria");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Quantidade de Pessoas Inscritas por Categoria: " + evento.quantInscritosPorCat());
                                    break;

                                case 8:
                                    System.out.println("Valor Total das Inscrições");

                                    System.out.println("Digite o código do evento para saber quanto foi arrecadado");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    System.out.println("Valor Total Arrecado " + evento.valorTotalInscricoes());
                                    break;

                                case 9:
                                    System.out.println("Digite o código do evento para listar todas as salas alocadas");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);

                                    Sala[] listaSalasAux = evento.getListaSalas();
                                    int totalSalas = evento.getQuantSalas();

                                    System.out.println("Salas alocadas no evento:");
                                    for (int i = 0; i < totalSalas; i++) {
                                        if (listaSalasAux[i] != null) {
                                            System.out.println("Identificação: " + listaSalasAux[i].getIdentificacaoSala());
                                        }
                                    }
                                    break;

                                case 10:                                   
                                    System.out.println("Digite o código do evento para saber quem está inscrito neste evento");
                                    in.nextLine();
                                    codigo = in.nextLine();
                                    
                                    evento = buscarEventoPorCodigo(listaEventos, totalEventos, codigo);;

                                    Inscricao[] listaInscricao = evento.getListaInscricoes();
                                    int total = evento.getInscricoesCadastradas();

                                    System.out.println("Lista de inscritos no evento:");
                                        for (int i = 0; i < total; i++) {
                                            System.out.println("Nome: " + listaInscricao[i].getNomeInscricao() + "\nID Inscrição: " + listaInscricao[i].getIdentificacaoInscricao());
                                        }
                                    break;

                                case 11:
                                    System.out.println("Voltando ao menu de consulta...");
                                    break;

                                default:
                                    System.out.println("Opção inválida no menu de consulta de evento.");
                            }
                            break;
                        case 2:
                            menuConsultaInscricaoEvento();
                            acaoConsultaInscricaoEvento = in.nextInt();
                            switch (acaoConsultaInscricaoEvento) {
                                case 1:
                                    System.out.println("Escolha o evento para buscar um inscrito pelo seu CPF");
                                    int eventoEscolhido = in.nextInt();
                                    Evento evento = listaEventos[eventoEscolhido];

                                    System.out.println("Digite o seu CPF:");
                                    cpf = in.nextLine();

                                    System.out.println("CPF: " + evento.buscaInscricaoPorCpf(cpf));
                                    break;

                                case 2:
                                    System.out.println("Voltando ao menu de consulta...");
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                            }
                            break;
                        case 3:
                            menuConsultaInscricao();
                            acaoConsultaInscricao = in.nextInt();
                            switch (acaoConsultaInscricao) {
                                case 1:
                                    System.out.println("Digite seu CPF para saber todos eventos que voce está cadastrado");
                                    cpf = in.nextLine();

                                    Evento[] eventosDaPessoa = buscaEventosPorCpf(cpf, listaEventos);

                                    for (int i = 0; i < eventosDaPessoa.length; i++) {
                                        System.out.println("Inscrito no evento: " + eventosDaPessoa[i].getNomeEvento());
                                    }
                                    break;

                                case 2:
                                    System.out.println("Voltando ao menu de consulta...");
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                            }
                            break;

                        case 4:
                            System.out.println("Voltando ao menu principal...");
                            break;

                        default:
                            System.out.println("Opção inválida no menu de consulta.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida no menu principal.");
            }
        }
    }

    public static Evento buscarEventoPorCodigo(Evento[] listaEventos, int totalEventos, String codigo) {
        for (int i = 0; i < totalEventos; i++) {
            if (listaEventos[i] != null && listaEventos[i].getCodigo().equals(codigo)) {
                return listaEventos[i];
            }
        }
        return null; // evento não encontrado
    }


    public static Evento[] buscaEventosPorCpf(String cpf, Evento[] listaEventos) {
        int count = 0;
        for (int i = 0; i < listaEventos.length; i++) {
            if (listaEventos[i] != null && listaEventos[i].buscaInscricaoPorCpf(cpf) != null) {
                count++;
            }
        }

        Evento[] eventosEncontrados = new Evento[count];
        int idx = 0;
        for (int i = 0; i < listaEventos.length; i++) {
            if (listaEventos[i] != null && listaEventos[i].buscaInscricaoPorCpf(cpf) != null) {
                eventosEncontrados[idx++] = listaEventos[i];
            }
        }
        return eventosEncontrados;
    }

    public static void menuPrincipal() {
        System.out.println(" __________________");
        System.out.println("|       MENU       |");
        System.out.println("|  1 - Cadastrar   |");
        System.out.println("|  2 - Consultar   |");
        System.out.println("|  3 - Sair        |");
        System.out.println("|__________________|");
    }

    public static void menuCadastro() {
        System.out.println(" ______________________________________");
        System.out.println("|            MENU CADASTRAR            |");
        System.out.println("|  1 - Cadastrar Novo Evento           |");
        System.out.println("|  2 - Cadastrar Inscrição no Evento   |");
        System.out.println("|  3 - Voltar para o Menu Principal    |");
        System.out.println("|______________________________________|");
    }

    public static void menuCategoria() {
         System.out.println("___________________");
        System.out.println("|   MENU CATEGORIA  |");
        System.out.println("|  1 - Professor    |");
        System.out.println("|  2 - Estudante    |");
        System.out.println("|  3 - Profissional |");
        System.out.println("|___________________|");
    }

    public static void menuConsulta() {
        System.out.println(" _______________________________________________");
        System.out.println("|                 MENU CONSULTAR                |");
        System.out.println("|  1 - Consultar Evento                         |");
        System.out.println("|  2 - Consultar Inscricao no Evento            |");
        System.out.println("|  3 - Consultar Inscricao em mais de um Evento |");
        System.out.println("|  4 - Voltar para o Menu Principal             |");
        System.out.println("|_______________________________________________|");
    }

    public static void menuConsultaEvento() {
         System.out.println("_______________________________________________________");
        System.out.println("|                   MENU CONSULTA EVENTO                |");
        System.out.println("|  1 - Adicionar Sala                                   |");
        System.out.println("|  2 - Remover Sala                                     |");
        System.out.println("|  3 - Buscar Salas por Lotacao Maxima                  |");
        System.out.println("|  4 - Buscar Sala                                      |");
        System.out.println("|  5 - Quantidade de Salas Alocadas                     |");
        System.out.println("|  6 - Quantidade de Inscritos no Evento                |");
        System.out.println("|  7 - Quantidade de Inscritos  por Categoria no Evento |");
        System.out.println("|  8 - Valor Total das Inscricoes                       |");
        System.out.println("|  9 - Listar Todas Salas Alocadas                      |");
        System.out.println("|  10 - Listar Todas Inscricoes                         |");
        System.out.println("|  11 - Voltar para o Menu Consultar                    |");
        System.out.println("|_______________________________________________________|");
    }

    public static void menuConsultaInscricaoEvento() {
        System.out.println(" ________________________________________");
        System.out.println("|     MENU CONSULTA INSCRICAO EVENTO     |");
        System.out.println("|  1 - Buscar Inscricao no Evento        |");
        System.out.println("|  2 - Voltar para o Menu Consultar      |");
        System.out.println("|________________________________________|");
    }

    public static void menuConsultaInscricao() {
        System.out.println(" _______________________________________");
        System.out.println("|     MENU CONSULTA INSCRICAO GERAL     |");
        System.out.println("|  1 - Buscar Inscricao                 |");
        System.out.println("|  2 - Voltar para o Menu Consultar     |");
        System.out.println("|_______________________________________|");
    }
}