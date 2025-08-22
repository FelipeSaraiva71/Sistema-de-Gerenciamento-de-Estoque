public class EstoqueEntrada extends Estoque{
    public EstoqueEntrada(int capacidade){
        super(capacidade);
    }

    @Override
    public boolean adicionarProduto(Produto produto){

        for (int i =0; i < posicoes.size();i++){
            if (!posicoes.get(i).estaOcupada()){
                posicoes.set(i,new PosicaoOcupada(i,produto));
                return  true;
            }
        }
        return false;
    }

    @Override
    public Produto buscarProduto(String codigoProduto){

        for (Posicao posicao:posicoes) {
            if (posicao.estaOcupada()) {
                Produto p = ((PosicaoOcupada) posicao).getProduto();
                if (p.getSKU().equals(codigoProduto)) {
                    return p;
                }
            }
        } return null;
    }

    @Override
    public boolean removerProduto(String codigoProduto) {
        // EstoqueEntrada não remove produtos
        return false;
    }
}


