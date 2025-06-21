import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 

        //variaveis evento
        int codigo;
        String nomeEvento;
        String tipo;
        LocalDate dataIncial;
        LocalDate dataFinal;
        int quantSalas;
        Sala[] listaSalas;
        int quantInscricoes;
        int inscricoesCadastradas;
        Inscricao[] listaInscricoes;

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
        int acaoCategoria = 0;
        int acaoConsulta = 0;
        int acaoConsultaEvento = 0;
        int acaoConsultaInscricaoEvento = 0;
        int acaoConsultaInscricao = 0;

        while (acaoPrincipal != 3) {
            menuPrincipal();
            acaoPrincipal = in.nextInt();

            switch (acaoPrincipal) {
                case 1: // Cadastro
                    menuCadastro();
                    acaoCadastro = in.nextInt();
                    switch (acaoCadastro) {
                        case 1:
                            System.out.println("Cadastrar novo Evento");
                            // chamada do método de cadastro de evento
                            break;
                        case 2:
                            System.out.println("Cadastrar nova Inscrição no Evento");
                            // chamada do método de cadastro de inscrição
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
                                    System.out.println("Adicionar Sala ao Evento");
                                    break;
                                case 2:
                                    System.out.println("Remover Sala do Evento");
                                    break;
                                case 3:
                                    System.out.println("Buscar Salas por Lotação Máxima");
                                    break;
                                case 4:
                                    System.out.println("Buscar Sala");
                                    break;
                                case 5:
                                    System.out.println("Quantidade de Salas Alocadas");
                                    break;
                                case 6:
                                    System.out.println("Quantidade de Inscritos no Evento");
                                    break;
                                case 7:
                                    System.out.println("Quantidade de Inscritos por Categoria");
                                    break;
                                case 8:
                                    System.out.println("Valor Total das Inscrições");
                                    break;
                                case 9:
                                    System.out.println("Listar Todas as Salas Alocadas");
                                    break;
                                case 10:
                                    System.out.println("Listar Todas as Inscrições no Evento");
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
                                    System.out.println("Buscar Inscrição no Evento");
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
                                    System.out.println("Buscar Inscrição Geral");
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