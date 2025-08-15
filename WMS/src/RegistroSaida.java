public class RegistroSaida extends Produto {

    protected String receptor;
    protected String responsavel;

    public RegistroSaida(String SKU, String nome, String descricao, int quantidade, double pesoUnitario,
                         double precoUnitario, String operador, String posicao, String receptor, String responsavel) {
        super(SKU, nome, descricao, quantidade, pesoUnitario, precoUnitario, operador, posicao);
        this.receptor = receptor;
        this.responsavel = responsavel;
    }

    // Getters
    public String getReceptor() { return receptor; }
    public String getResponsavel() { return responsavel; }

    // Setters
    public void setReceptor(String receptor) { this.receptor = receptor; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    // Tipo de movimentação
    @Override
    public String tipoMovimentacao() {
        return "SAIDA";
    }

    // Exibição
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Receptor: " + getReceptor());
        System.out.println("Responsável pela retirada: " + getResponsavel());
        System.out.println("------------------------------");
    }
}