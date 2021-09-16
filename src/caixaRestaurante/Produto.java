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
public class Produto {
    
    private static int cont = 0;
    private int codigo;
    private String nome;
    private float preco;
    
    public Produto(String nome, float preco){
        
        this.codigo = cont++;
        this.nome = nome;
        this.preco = preco;
        
    }

    public int getCodigo() {
        
        return codigo;
        
    }
    
    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
        
        this.nome = nome;
        
    }

    public float getPreco() {
        
        return preco;
        
    }

    public void setPreco(float preco) {
        
        this.preco = preco;
        
    }
    
    @Override
    public String toString(){
        
        return "Produto - " + nome
                + " - Codigo " + codigo
                + " - Preço R$" + String.format("%.2f", preco)
                + "\n";
        
    }

    
}
