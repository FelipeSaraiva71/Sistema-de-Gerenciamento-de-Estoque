import java.util.List;
import java.util.ArrayList;

public class Estoque {

    protected List<Posicao> posicoes = new ArrayList<>();

    public Estoque(int capacidade) {
        for (int i = 0; i < capacidade; i++) {
            posicoes.add(new PosicaoVaga(i));
        }
    }

    public boolean adicionarProduto(Produto produto) {
        for (int i = 0; i < posicoes.size(); i++) {
            if (!posicoes.get(i).estaOcupada()) {
                posicoes.set(i, new PosicaoOcupada(i, produto));
                return true;
            }
        }
        return false;
    }

    public boolean removerProduto(String codigoProduto) {
        for (int i = 0; i < posicoes.size(); i++) {
            Posicao posicao = posicoes.get(i);
            if (posicao.estaOcupada()) {
                Produto p = ((PosicaoOcupada) posicao).getProduto();
                if (p.getSKU().equals(codigoProduto)) {
                    posicoes.set(i, new PosicaoVaga(i));
                    return true;
                }
            }
        }
        return false;
    }

    public Produto buscarProduto(String codigoProduto) {
        for (Posicao posicao : posicoes) {
            if (posicao.estaOcupada()) {
                Produto p = ((PosicaoOcupada) posicao).getProduto();
                if (p.getSKU().equals(codigoProduto)) {
                    return p;
                }
            }
        }
        return null;
    }

    public void exibirEstoque() {
        for (Posicao posicao : posicoes) {
            System.out.println(posicao);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Posicao posicao : posicoes) {
            sb.append(posicao.toString()).append("\n");
        }
        return sb.toString();
    }
}