public abstract class Pessoa {

    protected final String nomePessoa;
    protected final String id ;

    public Pessoa (String nomePessoa , String id){

        this.nomePessoa = nomePessoa;
        this.id = id;

    }

    public String getNomePessoa(){
        return nomePessoa;
    }

    public String getId(){
        return id;
    }

    public abstract boolean acessoAdm();
    public abstract boolean acessoOperador();

    @Override
    public String toString(){
        return "Id: "+getId()+", Nome: "+getNomePessoa();
    }
}
