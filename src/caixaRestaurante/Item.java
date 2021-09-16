package caixaRestaurante;

/**
 *
 * @author Rafael
 */
public class Item {
    
    private int quantidade;
    private Produto produto;
    
    public Item(Produto produto, int quantidade) {
        
        this.produto = produto;
        this.quantidade = quantidade;
        
    }

    public int getQuantidade() {
        
        return quantidade;
        
    }

    public void setQuantidade(int quantidade) {
        
        this.quantidade = quantidade;
        
    }

    public Produto getProduto() {
        
        return produto;
        
    }

    public void setProduto(Produto produto) {
        
        this.produto = produto;
        
    }
    
    @Override
    public String toString(){
        
        return "Item - Produto: " + produto.getNome()
                + " - Qtd: " + quantidade
                + "\n";
        
    }
    
}
