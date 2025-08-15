import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// VALIDAR CADASTRO POR NOME E DESCRIÇÃO
// VALIDAR POSIÇÃO NO RESUMO DO ESTOQUE INDICANDO QUANTOS SKU TEM EM CADA POSIÇÃO
public class Gerenciamento {

    private int contadorProduto = 0;
    private List<Produto> listaProdutos = new ArrayList<>();
    private ArrayList<RegistroEntrada> entradas;
    private ArrayList<RegistroSaida> saidas;
    private Map<String, Integer> estoqueAtual;

    public Gerenciamento() {
        entradas = new ArrayList<>();
        saidas = new ArrayList<>();
        estoqueAtual = new HashMap<>();
    }


    public void registrarEntrada(RegistroEntrada entrada) {
        entradas.add(entrada);

        String SKU = entrada.getSKU();
        int quantidade = entrada.getQuantidade();

        int saldoAtual = estoqueAtual.getOrDefault(SKU, 0);
        estoqueAtual.put(SKU, saldoAtual + quantidade);
    }


    public void registrarSaida(RegistroSaida saida) {
        String sku = saida.getSKU();
        int quantidade = saida.getQuantidade();

        int saldoAtual = estoqueAtual.getOrDefault(sku, 0);

        if (saida.getQuantidade() > saldoAtual) {
            System.out.println("Erro: estoque insuficiente para o SKU '" + sku + "'.");
            System.out.println("Saldo disponível: " + saldoAtual + ", solicitado: " + quantidade);
            return;
        }

        saidas.add(saida);
        estoqueAtual.put(sku, estoqueAtual.get(sku) - quantidade);
    }


    public void listaEntradas() {
        if (entradas.isEmpty()) {
            System.out.println("Nenhuma entrada registrada.");
            return;
        }

        for (RegistroEntrada entrada : entradas) {
            entrada.exibir();
        }
    }


    public void listaSaidas() {
        if (saidas.isEmpty()) {
            System.out.println("Nenhuma saida registrada.");
            return;
        }

        for (RegistroSaida saida : saidas) {
            saida.exibir();
        }
    }

    public int consultarSaldoEstoque(String sku) {
        return estoqueAtual.getOrDefault(sku, 0);
    }


    public void resumoEstoque() {
        System.out.println("\nSALDO DO ESTOQUE");
        if (estoqueAtual.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }



        for (Map.Entry<String, Integer> item : estoqueAtual.entrySet()) {
            String SKU = item.getKey();
            int quantidade = item.getValue();
            System.out.println("SKU do produto '" + SKU + "' : " + quantidade + " unidades");
        }
    }





    private String gerarSKU() {
        contadorProduto++;
        return "PROD-" + String.format("%04d", contadorProduto);
    }


    public void adicionarProduto(String nome, String descricao, int quantidade, double pesoUnidade,
                                 double precoUnitario, String operador, String posicao,
                                 String fornecedor, String observacao) {

        String sku = gerarSKU();
        RegistroEntrada produtoInicial = new RegistroEntrada(sku, nome, descricao, quantidade,
                pesoUnidade, precoUnitario, operador, posicao, fornecedor, observacao);

        listaProdutos.add(produtoInicial);
        registrarEntrada(produtoInicial);
    }


    public Produto buscarProdutoPorSKU(String sku) {
        for (Produto produto : listaProdutos) {
            if (produto.getSKU().equalsIgnoreCase(sku)) {
                return produto;
            }
        }
        return null;
    }


    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");
        for (Produto produto : listaProdutos) {
            System.out.println("SKU: " + produto.getSKU());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Peso unitario: " + produto.getPesoUnidade());
        }
    }
}