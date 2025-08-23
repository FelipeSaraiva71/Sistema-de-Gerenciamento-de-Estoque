
public abstract class Produto {

    protected final String SKU;
    protected final String nomeProduto;
    protected final String descricao;
    protected int quantidade;
    protected double pesoUnidade;
    protected double precoUnitario;

    public Produto(String SKU, String nomeProduto, String descricao, int quantidade, double pesoUnidade,
                   double precoUnitario) {

        this.SKU = SKU;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.pesoUnidade = pesoUnidade;
        this.precoUnitario = precoUnitario;

    }

    // Getters
    public String getSKU() {
        return SKU;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPesoUnidade() {
        return pesoUnidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    // Setters
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPeso(double peso) {
        this.pesoUnidade = peso;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // Cálculos
    public double calcularValorTotal() {
        return quantidade * precoUnitario;
    }

    public double calcularPesoBruto() {
        return quantidade * pesoUnidade;
    }

    @Override
    public String toString() {
        return  "SKU: " + getSKU() + "\n" +
                "Nome: " + getNomeProduto() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Quantidade: " + getQuantidade() + " unidades\n" +
                "Peso unitário: " + String.format("%.2f", getPesoUnidade()) + " kg\n" +
                "Peso bruto: " + String.format("%.2f", calcularPesoBruto()) + " kg\n" +
                "Preço unitário: R$ " + String.format("%.2f", getPrecoUnitario()) + "\n" +
                "Valor total: R$ " + String.format("%.2f", calcularValorTotal()) + "\n";
    }
}
