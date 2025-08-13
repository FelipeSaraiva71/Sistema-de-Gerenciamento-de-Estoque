public class RegistroSaida extends Produto {


    protected String receptor;
    protected String responsavel;

    public RegistroSaida (String SKU,String nome, String descricao,int quantidade,double pesoUnitario, double precoUnitario,String operador,String receptor, String responsavel){

        super(SKU,nome, descricao,quantidade,pesoUnitario, precoUnitario,operador);
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
