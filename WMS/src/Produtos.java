import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class   Produtos {


    protected final String nome;
    protected final String descricao;
    protected int quantidade;
    protected double precoUnitario;
    protected String operador;


    public Produtos(String nome, String descricao, int quantidade, double precoUnitario,String operador) {

        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.operador = operador;
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

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public String getOperador(){
        return this.operador;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public String registroDataHora(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);

    }

    public abstract String tipoMovimentacao();

    public void exibir() {
        System.out.println("=== Dados da movimentação ===");
        System.out.println("Nome produto: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Preço unitário: R$" + getPrecoUnitario());
        System.out.printf("Preço total: R$%.2f%n", calcularValorTotal());
        System.out.println("Tipo movimentação: "+tipoMovimentacao());
        System.out.println("Operador: "+getOperador());
        System.out.println("Movimentação registrada em: "+registroDataHora());

    }
}
