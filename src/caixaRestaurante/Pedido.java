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
    
    private int codigo;
    private Date data;
    private Garcom garcom;
    private LinkedList<Item> itens = new LinkedList<>();
    
    public Pedido(Garcom garcom){
        
        this.codigo = cont++;
        this.garcom = garcom;
        this.data = Calendar.getInstance().getTime();
        
    }
    
    public int getCodigo() {
        
        return codigo;
        
    }

    public String getStrData() {
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d = fmt.format(data);
        return d;
         
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public LinkedList<Item> getItens() {
        return itens;
    }

    public void addItem(Item item) {
        
        this.getItens().add(item);
        
    }
    
    public float fecharPedido(){
        
        float total = 0;
        
        for(Item i: itens) {
            
            total += i.getQuantidade() * i.getProduto().getPreco();
            
        }
        
        return total;
        
    }
    
    @Override
    public String toString(){
        
        return "Pedido - cod: " + this.codigo
                + " Garçom: " + this.getGarcom().getNome()
                + " Data: " + this.getStrData()
                + "\n";
        
    }
    
    
}
