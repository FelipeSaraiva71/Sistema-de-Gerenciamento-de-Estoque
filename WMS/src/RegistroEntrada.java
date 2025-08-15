public class RegistroEntrada extends Produto {

    protected String fornecedor;
    protected String observacao;

    public RegistroEntrada(String SKU, String nome, String descricao, int quantidade, double pesoUnitario,
                           double precoUnitario, String operador, String posicao, String fornecedor, String observacao) {
        super(SKU, nome, descricao, quantidade, pesoUnitario, precoUnitario, operador, posicao);
        this.fornecedor = fornecedor;
        this.observacao = observacao;
    }

    // Getters
    public String getFornecedor() { return fornecedor; }
    public String getObservacao() { return observacao; }

    // Setters
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    // Tipo de movimentação
    @Override
    public String tipoMovimentacao() {
        return "ENTRADA";
    }

    // Exibição
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Fornecedor: " + getFornecedor());
        System.out.println("Observação: " + getObservacao());
        System.out.println("------------------------------");
    }
}