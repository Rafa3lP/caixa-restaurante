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
        
        return "Garçom - " + this.getNome()
                + " - matricula: " + this.getMatricula()
                + "\n";
        
    }
    
}
