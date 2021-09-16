package caixaRestaurante;

import java.util.LinkedList;

/**
 *
 * @author Rafael
 */
public class Caixa {
    
    private static float totalCaixa = 0;
    
    public static LinkedList<Garcom> garcons = new LinkedList<>();
    public static LinkedList<Produto> produtos = new LinkedList<>();
    public static LinkedList<Pedido> pedidos = new LinkedList<>();
    
    public static Boolean existeMatriculaGarcom(int matricula) {
        
        for(Garcom g: garcons) {
            
            if(g.getMatricula() == matricula){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public static Garcom procuraGarcom(int matricula) {
        
        for(Garcom g: garcons){

            if(g.getMatricula() == matricula){

                return g;

            }

        }
        
        return null;
        
    }
    
    public static Pedido procuraPedido(int codigo) {
        
        for(Pedido p: pedidos) {
                        
            if(p.getCodigo() == codigo) {

                return p;

            }

        }
        
        return null;
        
    }
    
    public static Produto procuraProduto(int codigo) {
        
        for(Produto p: produtos) {
                        
            if(p.getCodigo() == codigo) {

                return p;

            }

        }
        
        return null;
        
    }
    
    public static void addGarcom(Garcom garcom) {
        
        garcons.add(garcom);
        
    }
    
    public static void addPedido(Pedido pedido) {
        
        pedidos.add(pedido);
        
    }
    
    public static void addProduto(Produto produto) {
        
        produtos.add(produto);
        
    }
    
    public static void removePedido(Pedido pedido) {
        
        pedidos.remove(pedido);
        
    }

    
    public static float getTotalCaixa() {
        
        return totalCaixa;
        
    }
    
    public static void recebePagamento(float pagamento) {
        
        totalCaixa += pagamento;
        
    }
    
    
    
}
