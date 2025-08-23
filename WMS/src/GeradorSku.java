public class GeradorSku {
    protected int contador ;
    protected String prefixo ;

    public GeradorSku (int contador,String prefixo){

        this.contador = contador;
        this.prefixo = prefixo;
    }

    public int getContador(){
        return this.contador;
    }

    public String getPrefixo(){
        return this.prefixo;
    }

    public String gerarSKU(){
        String sku = prefixo + String.format("%04d", contador);
        contador++;
        return sku;
    }

    @Override
    public String toString(){
        return "GeradorSKU [Prefixo: " + getPrefixo() + ", Próximo SKU: " + getPrefixo() + String.format("%04d", getContador()) + "]";
    }

}
