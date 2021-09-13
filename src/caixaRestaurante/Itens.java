/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaRestaurante;

/**
 *
 * @author Rafael
 */
public class Itens {
    
    private int quantidade;
    private Produto produto;

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
        
        return "Item - Produto: " + produto.getNome() + " - Qtd: " + quantidade;
        
    }
    
}
