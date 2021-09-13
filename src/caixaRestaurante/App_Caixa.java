/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaRestaurante;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class App_Caixa {
    
    static Scanner teclado = new Scanner(System.in);
    static LinkedList<Garcom> garcons = new LinkedList<>();
    static LinkedList<Produto> produtos = new LinkedList<>();
    static LinkedList<Pedido> pedidos = new LinkedList<>();
    
    static float valor_caixa = 0;
    
    public static void cadastrarGarcom(){
        
        String nome;
        int matricula;
        
        System.out.println("Digite o nome do garçom: ");
        nome = teclado.next();
        System.out.println("Digite a matricula do garçom: ");
        matricula = teclado.nextInt();
        
        garcons.add(new Garcom(nome, matricula));
        
        System.out.println(garcons.getLast() + "\nAdicionado com sucesso!");
        
    }
    public static void cadastrarProduto(){
        
        String nome;
        int codigo;
        float preco;
        
        System.out.println("Digite o nome do novo produto:");
        nome = teclado.next();
        System.out.println("Digite o codigo do novo produto: ");
        codigo = teclado.nextInt();
        System.out.println("Digite o preço do novo produto: ");
        preco = teclado.nextFloat();
        
        produtos.add(new Produto(nome, codigo, preco));
        
        System.out.println(produtos.getLast() + "\nAdicionado com sucesso!");
        
    }
    public static void abrirPedido(){
        
        int matricula;
        Garcom garcom = null;
        
        if(garcons.isEmpty()){
            
            System.out.println("Nenhum garçom cadastrado!");
            
        }else{
            
            System.out.println("ABRIR PEDIDO");
            imprimirGarcons();
            System.out.println("matricula do garçon: ");
            matricula = teclado.nextInt();
            for(Garcom g: garcons){

                if(g.getMatricula() == matricula){

                    garcom = g;
                    break;

                }

            }

            if(garcom == null){

                System.out.println("Garçom nao encontrado!");

            }else{

                pedidos.add(new Pedido(garcom));
                System.out.println("Pedido aberto com sucesso!\n" + pedidos.getLast());

            }

        }
        
    }
    
    public static void escolheProduto(Pedido pedido) {
        
        Produto produto = null;
        Itens item;
        int cod, qtd;
        
        System.out.println("ADICIONAR PRODUTO");
        imprimirProdutos();
        System.out.println("Digite o codigo do produto: ");
        cod = teclado.nextInt();
        for(Produto p: produtos){

            if(p.getCodigo() == cod){

                produto = p;
                break;

            }

        }
        if(produto == null){

            System.out.println("Produto nao encontrado!");

        }else{

            System.out.println("Digite a quantidade desejada: ");
            qtd = teclado.nextInt();
            if(qtd > 0){

                item = new Itens();
                item.setProduto(produto);
                item.setQuantidade(qtd);

                pedido.setItens(item);

                System.out.println(item + " Adicionado com sucesso!");


            }else{

                System.out.println("Quantidade invalida!");

            }

        }
        
    }
    
    public static void adicionarProduto(){
        
        Pedido pedido = null;
        int cod;
        char op;
        
        if(produtos.isEmpty()){
            
            System.out.println("Nenhum produto cadastrado!");
            
        }else{
            
            if(pedidos.isEmpty()){
                
                System.out.println("Nenhum pedido aberto!");
                
            }else{
 
                imprimirPedidos();
                System.out.println("Digite o codigo do pedido: ");
                try{
                    
                    cod = teclado.nextInt();
                    
                    for(Pedido p: pedidos) {
                        
                        if(p.codigo == cod) {
                            
                            pedido = p;
                            break;
                            
                        }
                        
                    }
                    if(pedido == null){
                        
                        System.out.println("Pedido nao encontrado!");
                        
                    }else{
                        while(true){
                            
                            System.out.println(pedido);
                            System.out.println("ITENS DO PEDIDO");
                            imprimirItensPedido(pedido);
                            System.out.println("Deseja adicionar um produto?(s/n) ");
                            op = teclado.next().charAt(0);
                            switch(op){

                                case 's':
                                case 'S':
                                    escolheProduto(pedido);
                                    break;
                                case 'n':
                                case 'N':
                                    return;
                                default:
                                    System.out.println("opcao invalida!");
                                    break;

                            }   
                            
                        }
                        
                    }
                    
                }catch(Exception e) {
                    
                    System.out.println("Digite apenas numeros!");
                    teclado.nextLine();
                    
                }
                
            }
            
        }
        
    } 
    public static void fecharPedido(){
        
        if(pedidos.isEmpty()){
            
            System.out.println("Nenhum pedido aberto!");
            
        }else{
            
            System.out.println("FECHAR PEDIDO");
            imprimirPedidos();
            System.out.println("Digite o codigo do pedido: ");
            
        }
        
    }
    public static void totalCaixa(){
        
        System.out.println("O caixa tem R$" + String.format("%.2f", valor_caixa) + " no total");
        
    }
    
    public static void imprimirPedidos(){
        
        System.out.printf("                                PEDIDOS\n");
        System.out.printf(" _______________________________________________________________________\n");
        System.out.printf("|     CODIGO    |       GARÇOM      |              DATA                 |\n");
        System.out.printf("|_______________|___________________|___________________________________|\n");
        pedidos.forEach(p -> {

            System.out.printf("| %-14d| %-18s| %-34s|\n", p.codigo, p.getGarcom().getNome(), p.getData());
            System.out.printf("|_______________|___________________|___________________________________|\n");

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
    
 
    public static void main(String[] args) {
        
        int op;
        
        while(true){
            
            try {
                
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
                
                op = teclado.nextInt();
                
                switch(op){

                    case 1:
                        cadastrarGarcom();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        abrirPedido();
                        break;
                    case 4:
                        adicionarProduto();
                        break;
                    case 5:
                        fecharPedido();
                        break;
                    case 6:
                        totalCaixa();
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    case 8:
                        imprimirProdutos();
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        break;

                }
                
            } catch (InputMismatchException e) {
                
                System.out.println("Digite apenas numeros!");
                teclado.nextLine();
    
            }
            
        }
        
    }
    
}
