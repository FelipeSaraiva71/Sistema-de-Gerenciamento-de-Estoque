public class EstoqueSaida extends Estoque{

    public EstoqueSaida (int capacidade){
        super (capacidade);
    }

    @Override
    public boolean adicionarProduto(Produto produto){
        return false; //saida não adiciona
    }

    @Override
    public boolean removerProduto(String codigoProduto){

        for (int i=0;i<posicoes.size();i++){
            Posicao posicao = posicoes.get(i);
            if (posicao.estaOcupada()){
                Produto p =((PosicaoOcupada)posicao).getProduto();
                if (p.getSKU().equals(codigoProduto)){
                    posicoes.set(i, new PosicaoVaga(i));
                    return   true;
                }
            }
        } return false;
    }
    @Override
    public Produto buscarProduto(String codigoProduto){

        for (Posicao posicao: posicoes){
            if (posicao.estaOcupada()){
                Produto p = ((PosicaoOcupada)posicao).getProduto();
                if (p.getSKU().equals(codigoProduto)){
                    return p;
                }
            }
        } return  null;
    }
}
