package caixaRestaurante;

import static caixaRestaurante.Caixa.garcons;
import static caixaRestaurante.Caixa.pedidos;
import static caixaRestaurante.Caixa.produtos;

/**
 *
 * @author Rafael
 */
public class Interface {
    
    public static void imprimirMenuPrincipal() {
        
        System.out.print(
                
            "Bem vindo ao Restaurante Rafael - MENU\n"+ 
            "------------------------\n"+
            "1 - Cadastrar Garçom\n"+
            "2 - Cadastrar Produtos\n"+
            "3 - Abrir Pedido\n"+
            "4 - Adicionar Produto\n"+
            "5 - Fechar Pedido\n"+
            "6 - Total do Caixa\n"+
            "7 - Sair\n"+
            "------------------------\n"+
            "Opcao: "
                
        );
        
    }
 
    public static void imprimirPedidos(){
        
        System.out.printf("                                PEDIDOS\n");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("|    CODIGO     |           GARÇOM            |           DATA          |\n");
        System.out.printf("|_______________|_____________________________|_________________________|\n");
        pedidos.forEach(p -> {

            System.out.printf("| %-14d| %-28s| %-24s|\n", p.getCodigo(), p.getGarcom().getNome(), p.getStrData());
            System.out.printf("|_______________|_____________________________|_________________________|\n");

        });
        
    }
    
    public static void imprimirGarcons(){
        
        System.out.printf("                               GARÇONS\n");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("|   MATRICULA   |                          NOME                         |\n");
        System.out.printf("|_______________|_______________________________________________________|\n");
        garcons.forEach(g -> {

            System.out.printf("| %-14d| %-54s|\n", g.getMatricula(), g.getNome());
            System.out.printf("|_______________|_______________________________________________________|\n");

        });
        
    }
    
    public static void imprimirProdutos(){
        
        System.out.printf("                                PRODUTOS\n");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("|     CODIGO    |              NOME            |          PREÇO         |\n");
        System.out.printf("|_______________|______________________________|________________________|\n");
        produtos.forEach(p -> {

            System.out.printf("| %-14d| %-29s| %-23s|\n", p.getCodigo(), p.getNome(), String.format("R$%.2f", p.getPreco()));
            System.out.printf("|_______________|______________________________|________________________|\n");

        });
        
    }
    
    public static void imprimirItensPedido(Pedido p) {
        
        System.out.printf("                                ITENS\n");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("|     QTD       |           PRODUTO            |          PREÇO         |\n");
        System.out.printf("|_______________|______________________________|________________________|\n");
        if(p.getItens().isEmpty()){
            return;
        }
        p.getItens().forEach(i -> {
        
            System.out.printf("| %-14d| %-29s| %-23s|\n", i.getQuantidade(), i.getProduto().getNome(), String.format("R$%.2f", i.getQuantidade()*i.getProduto().getPreco()));
            System.out.printf("|_______________|______________________________|________________________|\n");
        
        });
        
    }
    
    public static void imprimirNotaPedido(Pedido p) {
        
        System.out.println("                            NOTA DO PEDIDO");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("| CODIGO: %-14d DATA: %-41s|\n", p.getCodigo(), p.getStrData());
        System.out.printf("| GARÇOM: %-62s|\n", p.getGarcom().getNome());
        imprimirItensPedido(p);
        System.out.printf("|                                                                       |\n");
        System.out.printf("| TOTAL DO PEDIDO: %-53s|\n",  String.format("R$%.2f",p.fecharPedido()));
        System.out.printf("|                                                                       |\n");
        System.out.printf(" _______________________________________________________________________\n");
        
    }
    
}
