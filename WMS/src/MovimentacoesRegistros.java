import java.util.ArrayList;
import java.util.List;

public class MovimentacoesRegistros {

    private List<Movimentacoes> registros;

    public MovimentacoesRegistros(){
        this.registros = new ArrayList<>();
    }

    public void registrar(Movimentacoes movimentacoes){
        registros.add(movimentacoes);
    }

    public List<Movimentacoes> listarTodas(){
        return  registros;
    }

    public void exibirTodos(){
        for (Movimentacoes mov : registros){
            System.out.println(mov);
        }
    }
}

