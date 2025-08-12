import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gerenciamento {
    private ArrayList<RegistroEntrada> entradas;
    private ArrayList<RegistroSaida> saidas;
    private Map<String, Integer> estoqueAtual;

    public Gerenciamento (){
        entradas = new ArrayList<>();
        saidas = new ArrayList<>();
        estoqueAtual = new HashMap<>();
    }

    public void registrarEntrada(RegistroEntrada entrada){
        entradas.add(entrada);

        String nomeProduto = entrada.getNome();
        int quantidade = entrada.getQuantidade();

        int saldoAtual = estoqueAtual.getOrDefault(nomeProduto,0);
        estoqueAtual.put(nomeProduto,saldoAtual+ quantidade);
    }

    public void registrarSaida(RegistroSaida saida){
        String nomeProduto = saida.getNome();
        int quantidade = saida.getQuantidade();

        int saldoAtual = estoqueAtual.getOrDefault(nomeProduto,0);

        if (saida.getQuantidade() > saldoAtual){
            System.out.println("Erro: estoque insuficiente para o produto '"+nomeProduto+".");
            System.out.println("Saldo disponível: "+saldoAtual+", solicitado: "+quantidade);
            return;
        }
        saidas.add(saida);
        estoqueAtual.put(nomeProduto,saldoAtual - quantidade);
    }

    public void listaEntradas(){

        for (RegistroEntrada entrada : entradas){
            entrada.exibir();
        }
    }

    public void listaSaidas() {

        for (RegistroSaida saida : saidas) {
            saida.exibir();
        }
    }//DESTRINCHAR O METODO RESUMO ESTOQUE PARA APLICAR A LOGICA COM MAIS CLAREZA
        public void resumoEstoque() {
            System.out.println("\nSALDO DO ESTOQUE");
            if (estoqueAtual.isEmpty()) {
                System.out.println("Estoque vazio.");
                return;
            }

            for (Map.Entry<String, Integer> item : estoqueAtual.entrySet()) {
                String nomeProduto = item.getKey();
                int quantidade = item.getValue();
                System.out.println("Nome produto" + nomeProduto + ": " + quantidade + " unidades");
            }
        }

    }
