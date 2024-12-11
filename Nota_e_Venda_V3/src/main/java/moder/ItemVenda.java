package moder;

public class ItemVenda {
    private Produto produto;

    public ItemVenda(Produto produto) {
        this.produto = produto;
    }

    public double calcularPrecoTotal() {
        return produto.calcularPrecoTotal();
    }

    public Produto getProduto() {
        return produto;
    }
}
