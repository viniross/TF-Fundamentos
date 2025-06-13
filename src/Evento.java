import java.time.*;

public class Evento {
    private int codigo;
    private String nomeEvento;
    private String tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int quantSalas;
    private Salas[] listaSalas;
    private int quantInscricoes;
    private Inscricoes[] listaInscricoes;

    public Evento(int codigo, String nomeEvento, String tipo, LocalDate dataInicial, LocalDate dataFinal, int quantSalas) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.quantSalas = quantSalas;
        this.listaSalas = new Salas[quantSalas];
        this.quantInscricoes = 0;
        this.listaInscricoes = new Inscricoes[quantInscricoes];

        if (codigo <= 0) {
            System.out.println("Código inválido! Utilizando o código padrão 1.");
            this.codigo = 1;
        } else {
            this.codigo = codigo;
        }

        if (dataInicial == null) {
            System.out.println("Data incial inválida! Utilizando a data atual.");
            this.dataInicial = LocalDate.now();
        } else {
            this.dataInicial = dataInicial;
        }

        if (dataFinal == null) {
            System.out.println("Data final inválida! Utilizando a data atual.");
            this.dataFinal = LocalDate.now();
        } else {
            this.dataFinal = dataFinal;
        }

        if (this.dataFinal.isBefore(this.dataIncial)) {
            System.out.println("A data final não pode ser anterior à data inicial! Corrigindo para a data inicial.");
            this.dataFinal = this.dataInicial;
        }

        if (quantSalas < 1) {
            System.out.println("Quantidade de salas inválida! Utilizando 1 sala.");
            this.quantSalas = 1;
        } else {
            this.quantSalas = quantSalas;
        }

        this.listaSalas = new Salas[this.quantSalas];

        this.quantInscricoes = 0;
        this.listaInscricoes = new Inscricoes[0];
    }
}