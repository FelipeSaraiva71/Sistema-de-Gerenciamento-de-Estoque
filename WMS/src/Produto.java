import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Produto {

    protected String SKU;
    protected final String nome;
    protected final String descricao;
    protected int quantidade;
    protected double pesoUnidade;
    protected double precoUnitario;
    protected String operador;
    protected String posicao;
    protected LocalDateTime dataHora;

    public Produto(String SKU, String nome, String descricao, int quantidade, double pesoUnidade,
                   double precoUnitario, String operador, String posicao) {
        this.SKU = SKU;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.pesoUnidade = pesoUnidade;
        this.precoUnitario = precoUnitario;
        this.operador = operador;
        this.posicao = posicao;
        this.dataHora = LocalDateTime.now();
    }

    // Getters
    public String getSKU() { return SKU; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getQuantidade() { return quantidade; }
    public double getPesoUnidade() { return pesoUnidade; }
    public double getPrecoUnitario() { return precoUnitario; }
    public String getOperador() { return operador; }
    public String getPosicao() { return posicao; }
    public LocalDateTime getDataHora() { return dataHora; }

    // Setters
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setPeso(double peso) { this.pesoUnidade = peso; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
    public void setOperador(String operador) { this.operador = operador; }
    public void setPosicao(String posicao) { this.posicao = posicao; }

    // Cálculos
    public double calcularValorTotal() {
        return quantidade * precoUnitario;
    }

    public double calcularPesoBruto() {
        return quantidade * pesoUnidade;
    }

    // Tipo de movimentação
    public String tipoMovimentacao() {
        return "CADASTRO";
    }

    // Exibição
    public void exibir() {
        System.out.println("=== Dados da movimentação ===");
        System.out.println("SKU: " + getSKU());
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Peso unitário: " + getPesoUnidade() + " kg");
        System.out.printf("Peso bruto: %.2f kg%n", calcularPesoBruto());
        System.out.printf("Preço unitário: R$ %.2f%n", getPrecoUnitario());
        System.out.printf("Preço total: R$ %.2f%n", calcularValorTotal());
        System.out.println("Tipo de movimentação: " + tipoMovimentacao());
        System.out.println("Operador: " + getOperador());
        System.out.println("Posição no estoque: " + getPosicao());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Movimentação registrada em: " + dataHora.format(formatter));
    }
}