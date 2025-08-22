import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstoqueEntrada estoque = new EstoqueEntrada(10); // capacidade inicial
        MovimentacoesRegistros historico = new MovimentacoesRegistros();
        GeradorSku gerador = new GeradorSku(1, "PROD-");

        // === LOGIN ===
        System.out.println("=== LOGIN ===");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu ID: ");
        String id = scanner.nextLine();

        System.out.print("Você é Administrador (A) ou Operador (O)? ");
        String tipo = scanner.nextLine().toUpperCase();

        Pessoa pessoaLogada;

        if (tipo.equals("A")) {
            pessoaLogada = new PessoaAdm(nome, id);
            System.out.println("Login como Administrador realizado com sucesso.");
        } else if (tipo.equals("O")) {
            pessoaLogada = new PessoaOperador(nome, id);
            System.out.println("Login como Operador realizado com sucesso.");
        } else {
            System.out.println("Tipo inválido. Encerrando...");
            scanner.close();
            return;
        }

        // === MENU PRINCIPAL ===
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Adicionar produto ao estoque");
            if (pessoaLogada.acessoAdm()) {
                System.out.println("2. Registrar saída de produto");
            }
            System.out.println("3. Buscar produto por SKU");
            System.out.println("4. Exibir movimentações");
            System.out.println("5. Exibir mapa de posições do estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Peso por unidade (kg): ");
                    double pesoUnidade = scanner.nextDouble();

                    System.out.print("Preço unitário (R$): ");
                    double precoUnitario = scanner.nextDouble();
                    scanner.nextLine(); // consumir quebra de linha

                    String novoSKU = gerador.gerarSKU();

                    Produto novoProduto = new Produto(novoSKU, nomeProduto, descricao, quantidade, pesoUnidade, precoUnitario) {
                        // Classe anônima temporária, já que Produto é abstrato
                    };

                    if (estoque.adicionarProduto(novoProduto)) {
                        historico.registrar(new MovEntrada(LocalDateTime.now(), novoProduto, pessoaLogada));
                        System.out.println("Produto adicionado com sucesso! SKU: " + novoSKU);
                    } else {
                        System.out.println("Estoque cheio. Não foi possível adicionar.");
                    }
                    break;

                case 2:
                    if (pessoaLogada.acessoAdm()) {
                        System.out.print("Digite o SKU do produto para saída: ");
                        String codigoSaida = scanner.nextLine();
                        Produto produtoSaida = estoque.buscarProduto(codigoSaida);

                        if (produtoSaida != null && estoque.removerProduto(codigoSaida)) {
                            historico.registrar(new MovSaida(LocalDateTime.now(), produtoSaida, pessoaLogada));
                            System.out.println("Produto removido com sucesso.");
                        } else {
                            System.out.println("Produto não encontrado ou não pode ser removido.");
                        }
                    } else {
                        System.out.println("Acesso negado. Apenas administradores podem registrar saídas.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o SKU para busca: ");
                    String buscaSKU = scanner.nextLine();
                    Produto encontrado = estoque.buscarProduto(buscaSKU);
                    System.out.println(encontrado != null ? encontrado : "Produto não encontrado.");
                    break;

                case 4:
                    System.out.println("\n=== HISTÓRICO DE MOVIMENTAÇÕES ===");
                    historico.exibirTodos();
                    break;

                case 5:
                    System.out.println("\n=== MAPA DE POSIÇÕES DO ESTOQUE ===");
                    System.out.println(estoque); // Certifique-se de que o toString() da classe Estoque está implementado
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}