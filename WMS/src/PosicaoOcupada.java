public class PosicaoOcupada extends Posicao {

    private Produto produto;

    public PosicaoOcupada(int id, Produto produto) {
        super(id);
        this.produto = produto;
    }

    public Produto getProduto(){
        return produto;
    }

    @Override
    public boolean estaOcupada(){
        return true;
    }

    @Override
    public String toString() {
        return "Posição " + getId() + " ocupada por: " + getProduto();
    }
}
