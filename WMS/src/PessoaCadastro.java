import java.util.ArrayList;
import java.util.List;

public class PessoaCadastro {
    private List<PessoaOperador> operadores = new ArrayList<>();

    public void cadastrarOperador(PessoaOperador operador) {
        operadores.add(operador);
    }

    public boolean existeOperador(String nome, String id) {
        for (PessoaOperador op : operadores) {
            if (op.getNomePessoa().equalsIgnoreCase(nome) && op.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public boolean cadastrarOperadorSeguro(PessoaOperador operador) {
        if (!existeOperador(operador.getNomePessoa(), operador.getId())) {
            operadores.add(operador);
            return true;
        }
        return false;
    }

    public void listaOperadores(){
        if (operadores.isEmpty()){
            System.out.println("Nenhum operador cadastrado.");
        }else {
            System.out.println("=== Operadores cadastrados ===");
            for (PessoaOperador op : operadores){
                System.out.println(op);
            }
        }
    }
}