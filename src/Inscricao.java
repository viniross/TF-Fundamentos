public class Inscricao {
    private String identificacaoInscricao;
    private String nomeInscricao;
    private String categoria;
    private String cpf;
    private String cargo;
    private String instituicao;
    private double preco;

    public Inscricao(String identificacaoInscricao, String nomeInscricao, String categoria, String cpf, String cargo, String instituicao, double preco){
        this.identificacaoInscricao = identificacaoInscricao;
        this.nomeInscricao = nomeInscricao;
        this.categoria = categoria;
        this.cpf = cpf;
        this.cargo = cargo;
        this.instituicao = instituicao;
        this.preco = preco;
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

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }

    public void setPreco(double preco){
        if(preco<-1){
        System.out.println("Preço invalido, informe um valor maior que zero.");
        } else {
            this.preco = preco;
        }
    }
}