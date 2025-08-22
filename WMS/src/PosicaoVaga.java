public class PosicaoVaga extends Posicao{

    public PosicaoVaga (int id){
        super(id);
    }

    @Override
    public boolean estaOcupada(){
        return false;
    }

    @Override
    public String toString() {
        return "Posição " + getId() + " [Vaga]";
    }

}
