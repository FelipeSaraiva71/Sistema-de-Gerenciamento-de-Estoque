import java.time.LocalDateTime;

public class MovSaida extends Movimentacoes{

    public MovSaida(LocalDateTime dataHora, Produto produto, Pessoa pessoa){
        super(dataHora,produto,pessoa);
    }

    @Override
    public String getTipo(){
        return "SAIDA";
    }

    @Override
    public String toString(){
        return "[SAIDA] Produto: " + produto + ", Realizado por: " + pessoa.getNomePessoa() + ", Data/Hora: " + dataHora;
    }
}
