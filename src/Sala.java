public class Sala {
    private String identificacaoSala;
    private String localizacao;
    private int lotacaoMaxima;
    private double valorLocacao;

    public Sala(String identificacaoSala, String localizacao, int lotacaoMaxima, double valorLocacao) {
        this.identificacaoSala = identificacaoSala;
        this.localizacao = localizacao;
        this.lotacaoMaxima = lotacaoMaxima;
        this.valorLocacao = valorLocacao;

        if (lotacaoMaxima <= 0) {
            System.out.println("Lotação Máxima inválida! Utilizando o código padrão 1.");
            this.lotacaoMaxima = 1;
        } else {
            this.lotacaoMaxima = lotacaoMaxima;
        }

        if (valorLocacao <= 0) {
            System.out.println("Valor da locação inválido! Utilizando o código padrão 1.");
            this.valorLocacao = 1;
        } else {
            this.valorLocacao = valorLocacao;
        }
    }

    public String getIdentificacaoSala() {
        return identificacaoSala;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setIdentificaoSala(String identificacaoSala) {
        this.identificacaoSala = identificacaoSala;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setLotacaoMaxima(int lotacaoMaxima) {
        if (lotacaoMaxima <= 0) {
            System.out.println("Lotação Máxima inválida! Utilizando o código padrão 1.");
            this.lotacaoMaxima = 1;
        } else {
            this.lotacaoMaxima = lotacaoMaxima;
        }
    }

    public void setValorLocacao(double valorLocacao) {
        if (valorLocacao <= 0) {
            System.out.println("Valor da locação inválido! Utilizando o código padrão 1.");
            this.valorLocacao = 1;
        } else {
            this.valorLocacao = valorLocacao;
        }
    }
}