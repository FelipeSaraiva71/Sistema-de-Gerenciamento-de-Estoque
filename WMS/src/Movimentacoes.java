import java.time.LocalDateTime;

public abstract class Movimentacoes {

    protected LocalDateTime dataHora;
    protected Produto produto;
    protected Pessoa pessoa;

    public Movimentacoes(LocalDateTime dataHora, Produto produto, Pessoa pessoa){

        this.dataHora = dataHora;
        this.produto = produto;
        this.pessoa = pessoa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }


    public abstract String getTipo();


    @Override
    public String toString() {
        return "[" + getTipo() + "] Produto: " + produto + ", Realizado por: " + pessoa.getNomePessoa() + ", Data/Hora: " + dataHora;
    }


}
