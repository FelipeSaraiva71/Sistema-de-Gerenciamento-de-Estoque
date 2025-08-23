import java.time.LocalDateTime;

public class MovEntrada extends Movimentacoes{

    public MovEntrada(LocalDateTime dataHora, Produto produto, Pessoa pessoa){
     super(dataHora,produto,pessoa);
    }

    @Override
    public String getTipo(){
        return "ENTRADA";
    }

    @Override
    public String toString(){
        return "\n[ENTRADA]"+ super.toString() ;
    }
}
