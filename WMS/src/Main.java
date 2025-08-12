public class Main {
    public static void main(String[] args) {
        Gerenciamento gerenciamento = new Gerenciamento();
        RegistroEntrada entrada = new RegistroEntrada("HD Externo", "1TB USB 3.0", 10, 299.90,"Felipe","COMERCIO LTDA","LADO A");
        gerenciamento.registrarEntrada(entrada);
        gerenciamento.listaEntradas();
        RegistroSaida saida = new RegistroSaida("HD Externo","1TB USB 3.0",11,299.90,"Felipe","Felipe","Saraiva");

        gerenciamento.registrarSaida(saida);
        gerenciamento.listaSaidas();

        gerenciamento.resumoEstoque();

    }
}