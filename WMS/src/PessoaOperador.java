public class PessoaOperador extends Pessoa{

    public PessoaOperador(String nomePessoa, String id) {

        super(nomePessoa, id);
    }

    @Override
    public boolean acessoAdm() {
        return false;
    }

    @Override
    public boolean acessoOperador() {
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Nome: " + getNomePessoa() + ", Tipo: Operador";
    }
}
