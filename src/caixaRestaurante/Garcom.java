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
public class Garcom {
    
    private String nome;
    private int matricula;
    
    public Garcom(String nome, int matricula){
        
        this.nome = nome;
        this.matricula = matricula;
        
    }
    
    public String getNome(){
        
        return nome;
        
    }
    
    public int getMatricula(){
        
        return matricula;
        
    }
    
    @Override
    public String toString(){
        
        return "Garçom - " + this.getNome() + " matricula: " + this.getMatricula();
        
    }
    
}
