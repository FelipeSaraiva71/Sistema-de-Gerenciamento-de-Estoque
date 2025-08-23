import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque(10); // capacidade inicial
        MovimentacoesRegistros historico = new MovimentacoesRegistros();
        GeradorSku gerador = new GeradorSku(1, "PROD-"); //iniciando sku
        PessoaCadastro cadastro = new PessoaCadastro(); // controle de operadores
        List<Produto> produtosCadastrados = new ArrayList<>(); // lista de produtos cadastrados

        boolean sistemaAtivo = true;

        while (sistemaAtivo) {

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
                if (cadastro.existeOperador(nome, id)) {
                    pessoaLogada = new PessoaOperador(nome, id);
                    System.out.println("Login como Operador realizado com sucesso.");
                } else {
                    System.out.println("Operador não cadastrado. Retornando ao login...");
                    continue;
                }
            } else {
                System.out.println("Tipo inválido. Retornando ao login...");
                continue;
            }

            // === MENU PRINCIPAL ===
            boolean executando = true;

            while (executando) {
                System.out.println("\n=== MENU PRINCIPAL ===");

                if (pessoaLogada.acessoAdm()) {
                    System.out.println("1. Cadastrar produto");
                    System.out.println("2. Cadastrar operador");
                    System.out.println("3. Listar operadores");
                    System.out.println("4. Buscar produto por SKU");
                    System.out.println("5. Exibir movimentações");
                    System.out.println("6. Exibir mapa de posições do estoque");
                    System.out.println("7. Listar produtos cadastrados");
                    System.out.println("0. Encerrar sessão");
                } else {
                    System.out.println("1. Entrada de mercadoria");
                    System.out.println("2. Saída de mercadoria");
                    System.out.println("3. Exibir mapa de posições");
                    System.out.println("4. Exibir movimentações");
                    System.out.println("0. Encerrar sessão");
                }

                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // consumir quebra de linha

                if (pessoaLogada.acessoAdm()) {
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

                            Produto novoProduto = new Produto( novoSKU, nomeProduto, descricao, quantidade, pesoUnidade, precoUnitario) {
                                // Classe anônima temporária
                            };

                            produtosCadastrados.add(novoProduto);
                            System.out.println("Produto cadastrado com sucesso! SKU: " + novoSKU);
                            break;

                        case 2:
                            System.out.print("Nome do operador: ");
                            String nomeOp = scanner.nextLine();
                            System.out.print("ID do operador: ");
                            String idOp = scanner.nextLine();
                            PessoaOperador novoOp = new PessoaOperador(nomeOp, idOp);
                            if (cadastro.cadastrarOperadorSeguro(novoOp)) {
                                System.out.println("Operador cadastrado com sucesso.");
                            } else {
                                System.out.println("Operador já existe. Cadastro não realizado.");
                            }
                            break;

                        case 3:
                            cadastro.listaOperadores();
                            break;

                        case 4:
                            System.out.print("Digite o SKU para busca: ");
                            String buscaSKU = scanner.nextLine();
                            Produto encontrado = null;
                            for (Produto p : produtosCadastrados) {
                                if (p.getSKU().equals(buscaSKU)) {
                                    encontrado = p;
                                    break;
                                }
                            }
                            System.out.println(encontrado != null ? encontrado : "Produto não encontrado.");
                            break;

                        case 5:
                            System.out.println("\n=== HISTÓRICO DE MOVIMENTAÇÕES ===");
                            historico.exibirTodos();
                            break;

                        case 6:
                            System.out.println("\n=== MAPA DE POSIÇÕES DO ESTOQUE ===");
                            System.out.println(estoque);
                            break;

                        case 7:
                            System.out.println("\n=== PRODUTOS CADASTRADOS ===");
                            if (produtosCadastrados.isEmpty()) {
                                System.out.println("Nenhum produto cadastrado.");
                            } else {
                                for (Produto p : produtosCadastrados) {
                                    System.out.println(p);
                                    System.out.println("----------------------------------");
                                }
                            }
                            break;

                        case 0:
                            executando = false;
                            System.out.println("Sessão encerrada.");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                } else {
                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o SKU do produto para entrada: ");
                            String skuEntrada = scanner.nextLine();
                            Produto produtoEntrada = null;
                            for (Produto p : produtosCadastrados) {
                                if (p.getSKU().equals(skuEntrada)) {
                                    produtoEntrada = p;
                                    break;
                                }
                            }

                            if (produtoEntrada != null && estoque.adicionarProduto(produtoEntrada)) {
                                historico.registrar(new MovEntrada(LocalDateTime.now(), produtoEntrada, pessoaLogada));
                                System.out.println("Entrada registrada com sucesso.");
                            } else {
                                System.out.println("Produto não encontrado ou estoque cheio.");
                            }
                            break;

                        case 2:
                            System.out.print("Digite o SKU do produto para saída: ");
                            String skuSaida = scanner.nextLine();
                            Produto produtoSaida = estoque.buscarProduto(skuSaida);

                            if (produtoSaida != null && estoque.removerProduto(skuSaida)) {
                                historico.registrar(new MovSaida(LocalDateTime.now(), produtoSaida, pessoaLogada));
                                System.out.println("Saída registrada com sucesso.");
                            } else {
                                System.out.println("Produto não encontrado ou não pode ser removido.");
                            }
                            break;

                        case 3:
                            System.out.println("\n=== MAPA DE POSIÇÕES DO ESTOQUE ===");
                            System.out.println(estoque);
                            break;

                        case 4:
                            System.out.println("\n=== HISTÓRICO DE MOVIMENTAÇÕES ===");
                            historico.exibirTodos();
                            break;

                        case 0:
                            executando = false;
                            System.out.println("Sessão encerrada.");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                }
            }

            System.out.print("\nDeseja fazer login com outro usuário? (S/N): ");
            String resposta = scanner.nextLine().toUpperCase();
            if (!resposta.equals("S")) {
                sistemaAtivo = false;
                System.out.println("Encerrando o sistema...");
            }
        }

        scanner.close();
    }
}