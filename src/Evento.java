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

    public int getCodigo() {
        return codigo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public int getQuantSalas() {
        return quantSalas;
    }

    public Salas[] getListaSalas() {
        return listaSalas;
    }

    public int getQuantInscricoes() {
        return quantInscricoes;
    }

    public Inscricoes[] getListaInscricoes() {
        return listaInscricoes;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            System.out.println("Código inválido! Mantendo o código atual.");
        } else {
            this.codigo = codigo;
        }
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataInicial(LocalDate dataInicial) {
        if (dataInicial == null) {
            System.out.println("Data inicial inválida! Mantendo a data atual.");
        } else {
            this.dataInicial = dataInicial;
        }
    }

    public void setDataFinal(LocalDate dataFinal) {
        if (dataFinal == null) {
            System.out.println("Data final inválida! Mantendo a data atual.");
        } else if (dataFinal.isBefore(this.dataInicial)) {
            System.out.println("A data final não pode ser anterior à data inicial! Mantendo a data atual.");
        } else {
            this.dataFinal = dataFinal;
        }
    }

    public void setQuantSalas(int quantSalas) {
        if (quantSalas < 1) {
            System.out.println("Quantidade de salas inválida! Mantendo a quantidade atual.");
        } else {
            this.quantSalas = quantSalas;
            this.listaSalas = new Salas[quantSalas];
        }
    }

    public void setListaSalas(Salas[] listaSalas) {
        if (listaSalas == null || listaSalas.length != this.quantSalas) {
            System.out.println("Lista de salas inválida! Mantendo a lista atual.");
        } else {
            this.listaSalas = listaSalas;
        }
    }

    public void setQuantInscricoes(int quantInscricoes) {
        if (quantInscricoes < 0) {
            System.out.println("Quantidade de inscrições inválida! Mantendo a quantidade atual.");
        } else {
            this.quantInscricoes = quantInscricoes;
            this.listaInscricoes = new Inscricoes[quantInscricoes];
        }
    }

    public void setListaInscricoes(Inscricoes[] listaInscricoes) {
        if (listaInscricoes == null || listaInscricoes.length != this.quantInscricoes) {
            System.out.println("Lista de inscrições inválida! Mantendo a lista atual.");
        } else {
            this.listaInscricoes = listaInscricoes;
        }
    }
}