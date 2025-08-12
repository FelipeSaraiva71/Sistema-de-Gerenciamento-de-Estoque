import java.util.Map;
import java.util.HashMap;

public class RegistroEntrada extends Produtos{

    protected String fornecedor;
    protected String local;

    public RegistroEntrada (String nome, String descricao,int quantidade, double precoUnitario,String operador,String fornecedor,String local){

        super(nome, descricao,quantidade, precoUnitario,operador);
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