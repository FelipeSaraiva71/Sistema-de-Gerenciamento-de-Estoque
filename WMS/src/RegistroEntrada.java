
public class RegistroEntrada extends Produto{

    protected String fornecedor;
    protected String local;

    public RegistroEntrada (String SKU,String nome, String descricao,int quantidade,double pesoUnitario, double precoUnitario,String operador,String fornecedor,String local){

        super(SKU,nome, descricao,quantidade,pesoUnitario, precoUnitario,operador);
        this.fornecedor = fornecedor;
        this.local = local;

    }

    public String getFornecedor(){
        return this.fornecedor;
    }

    public String getLocal(){
        return this.local;
    }


    public  void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }

    public void setLocal (String local){
        this.local = local;
    }

    @Override
    public String tipoMovimentacao(){
        return "inbound";
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Fornecedor: "+getFornecedor());
        System.out.println("Local armazenagem: "+getLocal());
        System.out.println("------------------------------");
    }

}