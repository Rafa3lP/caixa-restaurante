/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaRestaurante;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Rafael
 */
public class Pedido {
   
    private static int cont = 0;
    public int codigo;
    private Calendar c = Calendar.getInstance();
    private Date data = c.getTime();
    private Garcom garcom;
    private LinkedList<Itens> itens = new LinkedList<>();
    
    public Pedido(Garcom garcom){
        
        codigo = cont++;
        this.garcom = garcom;
        
    }
   

    public String getData() {
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d = fmt.format(data);
        return d;
         
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public LinkedList<Itens> getItens() {
        return itens;
    }

    public void setItens(Itens item) {
        
        this.getItens().add(item);
        
    }
    
    public int fecharPedido(){
        
        return 0;
        
    }
    
    @Override
    public String toString(){
        
        return "Pedido - cod: " + this.codigo + " Garçom: " + this.getGarcom().getNome() + " Data: " + this.getData();
        
    }
    
    
}
