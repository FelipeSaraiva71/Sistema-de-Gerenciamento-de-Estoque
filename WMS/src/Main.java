import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciamento gerenciamento = new Gerenciamento();

        while (true) {
            System.out.println("\n=== MENU DE PRODUTOS ===");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Listar produtos cadastrados");
            System.out.println("3. Ver resumo do estoque");
            System.out.println("4. Registrar entrada");
            System.out.println("5. Listar entradas");
            System.out.println("6. Registrar saída");
            System.out.println("7. Listar saídas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Peso por unidade (kg): ");
                    double pesoUnidade = scanner.nextDouble();

                    System.out.print("Preço unitário (R$): ");
                    double precoUnitario = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Nome do operador: ");
                    String operador = scanner.nextLine();

                    System.out.print("Posição no estoque: ");
                    String posicao = scanner.nextLine();

                    System.out.print("Fornecedor: ");
                    String fornecedor = scanner.nextLine();

                    System.out.print("Observação: ");
                    String observacao = scanner.nextLine();

                    gerenciamento.adicionarProduto(nome, descricao, quantidade, pesoUnidade,
                            precoUnitario, operador, posicao, fornecedor, observacao);

                    System.out.println(" Produto cadastrado com sucesso!");
                    break;

                case 2:
                    gerenciamento.listarProdutos();
                    break;

                case 3:
                    gerenciamento.resumoEstoque();
                    break;

                case 4:
                    System.out.println("==== REGISTRAR ENTRADA ====");

                    System.out.print("SKU: ");
                    String skuEntrada = scanner.nextLine();

                    Produto produtoEntrada = gerenciamento.buscarProdutoPorSKU(skuEntrada);

                    if (produtoEntrada == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.println("Nome: " + produtoEntrada.getNome());
                    System.out.println("Descrição: " + produtoEntrada.getDescricao());
                    System.out.println("Peso unitário: " + produtoEntrada.getPesoUnidade());

                    System.out.print("Valor unitário: ");
                    double valorUnitario = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidadeEntrada = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Operador: ");
                    String operadorEntrada = scanner.nextLine();

                    System.out.print("Posição: ");
                    String posicaoEntrada = scanner.nextLine();

                    System.out.print("Fornecedor: ");
                    String fornecedorEntrada = scanner.nextLine();

                    System.out.print("Observação: ");
                    String observacaoEntrada = scanner.nextLine();

                    RegistroEntrada entrada = new RegistroEntrada(
                            skuEntrada,
                            produtoEntrada.getNome(),
                            produtoEntrada.getDescricao(),
                            quantidadeEntrada,
                            produtoEntrada.getPesoUnidade(),
                            valorUnitario,
                            operadorEntrada,
                            posicaoEntrada,
                            fornecedorEntrada,
                            observacaoEntrada
                    );

                    gerenciamento.registrarEntrada(entrada);
                    System.out.println("Entrada registrada com sucesso!");
                    break;

                case 5:
                    gerenciamento.listaEntradas();
                    break;

                case 6:
                    System.out.println("==== REGISTRAR SAÍDA ====");

                    System.out.print("SKU: ");
                    String skuSaida = scanner.nextLine();

                    Produto produtoSaida = gerenciamento.buscarProdutoPorSKU(skuSaida);

                    if (produtoSaida == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    int saldoAtual = gerenciamento.consultarSaldoEstoque(skuSaida);
                    System.out.println("Saldo atual: " + saldoAtual + " unidades");

                    System.out.println("Nome: "+produtoSaida.getNome());
                    System.out.println("Descrição: "+produtoSaida.getDescricao());

                    System.out.print("Valor unitário (R$): ");
                    double valorSaida = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidadeSaida = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidadeSaida > saldoAtual) {
                        System.out.println("Saldo insuficiente para saída.");
                        break;
                    }

                    System.out.print("Operador: ");
                    String operadorSaida = scanner.nextLine();

                    System.out.println("Posição: " );
                    String posicaoSaida = scanner.nextLine();

                    System.out.print("Receptor: ");
                    String receptorSaida = scanner.nextLine();

                    System.out.print("Responsável: ");
                    String responsavelSaida = scanner.nextLine();

                    RegistroSaida saida = new RegistroSaida(
                            skuSaida,
                            produtoSaida.getNome(),
                            produtoSaida.getDescricao(),
                            quantidadeSaida,
                            produtoSaida.getPesoUnidade(),
                            valorSaida,
                            operadorSaida,
                            posicaoSaida,
                            receptorSaida,
                            responsavelSaida
                    );

                    gerenciamento.registrarSaida(saida);
                    System.out.println("Saída registrada com sucesso!");
                    break;

                case 7:
                    gerenciamento.listaSaidas();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}