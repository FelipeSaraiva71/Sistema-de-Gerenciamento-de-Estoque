public class PessoaAdm extends Pessoa {

    public PessoaAdm(String nomePessoa, String id) {

        super(nomePessoa, id);
    }

    @Override
    public boolean acessoAdm() {
        return true;
    }

    @Override
    public boolean acessoOperador() {
        return false;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Nome: " + getNomePessoa() + ", Tipo: Administrador";
    }
}
