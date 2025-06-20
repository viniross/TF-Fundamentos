public class Inscricao {
    private String identificacaoInscricao;
    private String nomeInscricao;
    private int categoria;
    private String cpf;
    private String cargo;
    private String instituicao;
    private double preco;

    public Inscricao(String identificacaoInscricao, String nomeInscricao, int categoria, String cpf, String cargo, String instituicao, double preco){
        this.identificacaoInscricao = identificacaoInscricao;
        this.nomeInscricao = nomeInscricao;

        if (categoria == 1 || categoria == 2 || categoria == 3) {
            this.categoria = categoria;
        } else {
            this.categoria = 0;
        }

        this.cpf = cpf;
        this.cargo = cargo;
        this.instituicao = instituicao;

        if(preco < 1){
        System.out.println("Preço invalido, informe um valor maior que zero.");
        } else {
            this.preco = preco;
        }
    }

    public String getIdentificacaoInscricao(){
        return identificacaoInscricao;
    }

    public String getNomeInscricao(){
        return nomeInscricao;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getCpf(){
        return cpf;
    }

    public String getCargo(){
        return cargo;
    }

    public String getInstituicao(){
        return instituicao;
    }

    public double getPreco(){
        return preco;
    }

    public void setIdentificacaoInscricao(String identificacaoInscricao){
        this.identificacaoInscricao = identificacaoInscricao;
    }

    public void setNomeInscricao(String nomeInscricao){
        this.nomeInscricao = nomeInscricao;
    }

    public void setCategoria(int categoria){
        if (categoria == 1 || categoria == 2 || categoria == 3) {
            this.categoria = categoria;
        } else {
            this.categoria = 0;
        }
    }

    public void setCpf(String cpf){
        if (cpf.length() == 11 && cpf.matches("[0-9]+")){
            this.cpf = cpf;
        }
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }

    public void setPreco(double preco){
        if(preco < 1){
        System.out.println("Preço invalido, informe um valor maior que zero.");
        } else {
            this.preco = preco;
        }
    }
}