import java.util.List;
import java.util.ArrayList;

public abstract class Estoque {

    protected List<Posicao>posicoes = new ArrayList<>();

    public Estoque (int capacidade){
        for (int i =0; i<capacidade;i++){
            posicoes.add(new PosicaoVaga(i));
        }
    }

    public void exibirEstoque(){
        for (Posicao posicao : posicoes){
            System.out.println(posicao);
        }
    }

    public abstract boolean adicionarProduto(Produto produto);
    public abstract boolean removerProduto(String codigoProduto);
    public abstract Produto buscarProduto(String codigoProduto);
}
