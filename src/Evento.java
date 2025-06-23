import java.time.*;
import java.time.format.DateTimeFormatter;

public class Evento {
    private static int contadorEventos = 1;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String codigo;
    private String nomeEvento;
    private String tipo;
    private double precoBaseInscricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int quantSalas;
    private Sala[] listaSalas;
    private int quantInscricoes;
    private int inscricoesCadastradas;
    private Inscricao[] listaInscricoes;
    private int index;

    public Evento(String nomeEvento, String tipo, double precoBaseInscricao, LocalDate dataInicial, LocalDate dataFinal, int quantSalas) {
        this.codigo = gerarCodigoEvento();

        this.nomeEvento = nomeEvento;
        this.tipo = tipo;
        if (precoBaseInscricao < 0) {
            System.out.println("Preco inválido! Evento gratis.");
            this.precoBaseInscricao = 0;
        } else {
            this.precoBaseInscricao = precoBaseInscricao;
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

        if (this.dataFinal.isBefore(this.dataInicial)) {
            System.out.println("A data final não pode ser anterior à data inicial! Corrigindo para a data inicial.");
            this.dataFinal = this.dataInicial;
        }

        if (quantSalas < 1) {
            System.out.println("Quantidade de salas inválida! Utilizando 1 sala.");
            this.quantSalas = 1;
        } else {
            this.quantSalas = quantSalas;
        }

        this.listaSalas = new Sala[this.quantSalas];
        this.quantInscricoes = 100;
        this.listaInscricoes = new Inscricao[this.quantInscricoes];
        this.inscricoesCadastradas = 0;
        index = 0;
    }

     private String gerarCodigoEvento() {
        return String.format("%04d", contadorEventos++);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoBaseInscricao() {
        return precoBaseInscricao;
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

    public Sala[] getListaSalas() {
        return listaSalas;
    }

    public int getQuantInscricoes() {
        return quantInscricoes;
    }

    public int getInscricoesCadastradas() {
        return inscricoesCadastradas;
    }

    public Inscricao[] getListaInscricoes() {
        return listaInscricoes;
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
            this.listaSalas = new Sala[quantSalas];
        }
    }

    public void setListaSalas(Sala[] listaSalas) {
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
            this.listaInscricoes = new Inscricao[quantInscricoes];
        }
    }

    public void setListaInscricoes(Inscricao[] listaInscricoes) {
        if (listaInscricoes == null || listaInscricoes.length != this.quantInscricoes) {
            System.out.println("Lista de inscrições inválida! Mantendo a lista atual.");
        } else {
            this.listaInscricoes = listaInscricoes;
        }
    }

    public void addSala(Sala sala) {
        if (sala == null) {
            System.out.println("Sala inválida! Não foi possível adicionar.");
            return;
        }

        if(index != this.quantSalas) {
            this.listaSalas[index] = sala;
            index++;
            System.out.println("Sala adicionada com sucesso!");
        } else {
            System.out.println("Não há espaço para mais salas!");
        }
    }

    public void removeSala(String identificacaoSala) {
        if (identificacaoSala == null || identificacaoSala.isEmpty()) {
            System.out.println("Identificação da sala inválida! Não foi possível remover.");
            return;
        }

        for (int i = 0; i < this.quantSalas; i ++) {
            if (this.listaSalas[i] != null && this.listaSalas[i].getIdentificacaoSala().equals(identificacaoSala)) {
                this.listaSalas[i] = null;
                System.out.println("Sala removida com sucesso!");
                return;
            }
        }
        System.out.println("Sala não encontrada!");
    }

    public Sala[] buscaSalasPorLotacao(int lotacaoMaxima) {
        int contSalas = 0;
        for (int i = 0; i < quantSalas; i++) {
            if (listaSalas[i] != null && listaSalas[i].getLotacaoMaxima() <= lotacaoMaxima) {
                contSalas++;
            }
        }

        Sala[] resultado = new Sala[contSalas];
        int indexBuscaSalas = 0;

        for (int i = 0; i < quantSalas; i++) {
            if (listaSalas[i] != null && listaSalas[i].getLotacaoMaxima() <= lotacaoMaxima) {
                resultado[indexBuscaSalas] = listaSalas[i];
                indexBuscaSalas++;
            }
        }
        return resultado;
    }


    public Sala buscaSalaPorIdentificacao(String identificacaoSala) {
        if (identificacaoSala == null || identificacaoSala.isEmpty()) {
            return null;
        }
        for (int i = 0; i < quantSalas; i++) {
            if (listaSalas[i] != null && listaSalas[i].getIdentificacaoSala().equals(identificacaoSala)) {
                return listaSalas[i];
            }
        }
        return null;
    }

    public int quantSalasAlocadas() {
        int contSalasAlocadas = 0;

        for (int i = 0; i < quantSalas; i++) {
            if (listaSalas[i] != null) {
                contSalasAlocadas++;
            }
        }
        return contSalasAlocadas;
    }

    public boolean addInscricao(Inscricao inscricao) {
        if (inscricao == null) {
            return false;
        } 

        if (inscricoesCadastradas < quantInscricoes) {
            listaInscricoes[inscricoesCadastradas] = inscricao;
            inscricoesCadastradas++;
            return true;
        } else {
            return false;
        }
    }

    public Inscricao buscaInscricaoPorCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "").trim(); // normaliza o CPF buscado

        for (int i = 0; i < inscricoesCadastradas; i++) {
            if (listaInscricoes[i] != null) {
                String cpfSalvo = listaInscricoes[i].getCpf().replace(".", "").replace("-", "").trim(); // normaliza o CPF salvo
                if (cpfSalvo.equals(cpf)) {
                    return listaInscricoes[i]; // CPF encontrado
                }
            }
        }
        return null; // não encontrado
    }


    public int quantInscritos(){
        int contInscritos = 0;

        for (int i = 0; i < quantInscricoes; i++) {
            if(listaInscricoes[i] != null) {
                contInscritos++;
            }
        }
        return contInscritos;
    }

    public int[] quantInscritosPorCat() {
        int[] categoriasTemp = new int[quantInscricoes];
        int count = 0;

        for (int i = 0; i < quantInscricoes; i++) {
            if (listaInscricoes[i] != null) {
                int cat = listaInscricoes[i].getCategoria();
                boolean jaExiste = false;
                for (int j = 0; j < count; j++) {
                    if (categoriasTemp[j] == cat) {
                        jaExiste = true;
                        break;
                    }
                }
                if (!jaExiste) {
                    categoriasTemp[count] = cat;
                    count++;
                }
            }
        }

        int[] categoriasUnicas = new int[count];
        for (int i = 0; i < count; i++) {
            categoriasUnicas[i] = categoriasTemp[i];
        }
        return categoriasUnicas;
    }

    public double valorTotalInscricoes() {
        double valorTotal = 0;

        for (int i = 0; i < inscricoesCadastradas; i++) {
            if (listaInscricoes[i] != null) {
                valorTotal += listaInscricoes[i].getValorInscricao();
            }
        }
        return valorTotal;
    }
}