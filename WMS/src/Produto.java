import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class   Produto {

    protected String SKU;
    protected final String nome;
    protected final String descricao;
    protected int quantidade;
    protected double pesoUnidade;
    protected double precoUnitario;
    protected String operador;


    public Produto(String SKU, String nome, String descricao, int quantidade,double pesoUnidade, double precoUnitario,String operador) {

        this.SKU = SKU;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.pesoUnidade = pesoUnidade;
        this.precoUnitario = precoUnitario;
        this.operador = operador;
    }

    public String getSKU(){
        return  this.SKU;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getPesoUnidade(){
        return this.pesoUnidade;
    }

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public String getOperador(){
        return this.operador;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPeso(double peso){
        this.pesoUnidade = peso;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setOperador(String operador){
        this.operador = operador;
    }

    public double calcularValorTotal() {
        return getQuantidade() * getPrecoUnitario();

    }

    public double calcularPesoBruto() {
        return getQuantidade() * getPesoUnidade();

    }

    public String registroDataHora(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);

    }

    public abstract String tipoMovimentacao();

    public void exibir() {
        System.out.println("=== Dados da movimentação ===");
        System.out.println("SKU: "+getSKU());
        System.out.println("Nome produto: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Peso unitário: "+getPesoUnidade());
        System.out.println("Peso bruto: "+calcularPesoBruto());
        System.out.println("Preço unitário: R$" + getPrecoUnitario());
        System.out.printf("Preço total: R$%.2f%n", calcularValorTotal());
        System.out.println("Tipo movimentação: "+tipoMovimentacao());
        System.out.println("Operador: "+getOperador());
        System.out.println("Movimentação registrada em: "+registroDataHora());

    }
}
