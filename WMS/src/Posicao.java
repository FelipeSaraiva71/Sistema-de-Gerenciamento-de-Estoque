public abstract class Posicao {

    protected final int id;

    public Posicao (int id){

        this.id = id;
    }

    public int getId(){
        return id;
    }

    public abstract boolean estaOcupada();

    @Override
    public String toString() {
        return "Posição " + id + " [" + (estaOcupada() ? "Ocupada" : "Vaga") + "]";
    }

}
