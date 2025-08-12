public class RegistroSaida extends Produtos {


    protected String receptor;
    protected String responsavel;

    public RegistroSaida (String nome, String descricao,int quantidade, double precoUnitario,String operador,String receptor, String responsavel){

        super(nome, descricao,quantidade, precoUnitario,operador);
        this.receptor = receptor;
        this.responsavel = responsavel;

    }

    public String getReceptor(){
        return this.receptor;
    }

    public String getResponsavel(){
        return  this.responsavel;
    }

    public void setReceptor (String receptor){
        this.receptor = receptor;
    }

    public void setResponsavel(String responsavel){
        this.responsavel = responsavel;
    }

    @Override
    public String tipoMovimentacao(){
        return "outbound";
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Receptor: "+getReceptor());
        System.out.println("Responsavel pela retirada: "+getResponsavel());
        System.out.println("------------------------------");
    }

}
