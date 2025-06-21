public class App {
    public static void main(String[] args) {
         
    }

    public void menuPrincipal() {
        System.out.println(" __________________");
        System.out.println("|       MENU       |");
        System.out.println("|  1 - Cadastrar   |");
        System.out.println("|  2 - Consultar   |");
        System.out.println("|__________________|");
    }

    public void menuCadastro() {
        System.out.println(" ______________________________________");
        System.out.println("|            MENU CADASTRAR            |");
        System.out.println("|  1 - Cadastrar Novo Evento           |");
        System.out.println("|  2 - Cadastrar Inscrição no Evento   |");
        System.out.println("|______________________________________|");
    }

    public void menuConsulta() {
        System.out.println(" _______________________________________________");
        System.out.println("|                 MENU CONSULTAR                |");
        System.out.println("|  1 - Consultar Evento                         |");
        System.out.println("|  2 - Consultar Inscricao no Evento            |");
        System.out.println("|  3 - Consultar Inscricao em mais de um Evento |");
        System.out.println("|_______________________________________________|");
    }

    public void menuConsultaEvento() {
         System.out.println("_______________________________________________________");
        System.out.println("|                    MENU CONSULTA EVENTO               |");
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
        System.out.println("|  11 - Voltar para o Menu Principal                    |");
        System.out.println("|_______________________________________________________|");
    }

    public void menuConsultaInscricaoEvento() {
        System.out.println(" ________________________________________");
        System.out.println("|     MENU CONSULTA INSCRICAO EVENTO     |");
        System.out.println("|  1 - Buscar Inscricao no Evento        |");
        System.out.println("|________________________________________|");
    }

    public void menuConsultaInscricao() {
        System.out.println(" _______________________________________");
        System.out.println("|     MENU CONSULTA INSCRICAO GERAL     |");
        System.out.println("|  1 - Buscar Inscricao                 |");
        System.out.println("|_______________________________________|");
    }
}