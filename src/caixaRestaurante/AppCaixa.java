package caixaRestaurante;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class AppCaixa {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        Garcom garcom;
        Pedido pedido;
        Produto produto;
        Item item;
        
        String nome;
        Float preco;
        int op, cod, matricula, qtd;
        char sn;
        
        while(true){
            
            Interface.imprimirMenuPrincipal();
            
            try {
                
                op = teclado.nextInt();
                
                teclado.nextLine();
                
                switch(op){

                    case 1:
                        System.out.println("CADASTRAR GARÇOM");
                        System.out.println("Digite o nome do garçom: ");
                        nome = teclado.nextLine();
                        System.out.println("Digite a matricula do garçom: ");
                        matricula = teclado.nextInt();
                        if (Caixa.existeMatriculaGarcom(matricula)) {
                            System.out.println("Matricula ja existe");
                        } else {
                            garcom = new Garcom(nome, matricula);
                            Caixa.addGarcom(garcom);
                            System.out.println(garcom + "Adicionado com sucesso!");
                        }
                        break;
                    case 2:
                        System.out.println("CADASTRAR PRODUTO");
                        System.out.println("Digite o nome do produto: ");
                        nome = teclado.nextLine();
                        System.out.println("Digite o preço do produto: ");
                        preco = teclado.nextFloat();
                        
                        produto = new Produto(nome, preco);
                        Caixa.addProduto(produto);
                        System.out.println(produto + "Adicionado com sucesso!");
                    
                        break;
                    case 3:
                        System.out.println("ABRIR PEDIDO");
                        if(Caixa.garcons.isEmpty()){
                            System.out.println("Nenhum garçom cadastrado!");
                            break;
                        }
                        Interface.imprimirGarcons();
                        System.out.println("Digite a matrícula do garçom: ");
                        matricula = teclado.nextInt();
                        garcom = Caixa.procuraGarcom(matricula);
                        if(garcom != null) {
                            pedido = new Pedido(garcom);
                            Caixa.addPedido(pedido);
                            System.out.println(pedido + "Pedido aberto com sucesso!");
                        } else {
                            System.out.println("Garçom não encontrado!");
                        }
                        break;
                    case 4:
                        System.out.println("ADICIONAR PRODUTO");
                        if(Caixa.pedidos.isEmpty()) {
                            System.out.println("Nenhum pedido aberto!");
                            break;
                        }
                        if(Caixa.produtos.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado!");
                            break;
                        }
                        Interface.imprimirPedidos();
                        System.out.println("Digite o codigo do pedido: ");
                        cod = teclado.nextInt();
                        pedido = Caixa.procuraPedido(cod);
                        if(pedido != null) {
                            sn = 's';
                            while(sn != 'n' && sn != 'N'){
                                System.out.println(pedido);
                                System.out.println("ITENS DO PEDIDO");
                                Interface.imprimirItensPedido(pedido);
                                System.out.println("Deseja adicionar um produto?(s/n) ");
                                sn = teclado.next().charAt(0);
                                switch(sn){
                                    case 's':
                                    case 'S':
                                        Interface.imprimirProdutos();
                                        System.out.println("Digite o codigo do produto: ");
                                        cod = teclado.nextInt();
                                        produto = Caixa.procuraProduto(cod);
                                        if(produto != null) {
                                            System.out.println("Digite a quantidade desejada: ");
                                            qtd = teclado.nextInt();
                                            if(qtd > 0) {
                                                item = new Item(produto, qtd);
                                                pedido.addItem(item);
                                                System.out.println(item + "Adicionado com sucesso!");
                                            } else {
                                                System.out.println("Quantidade inválida!");
                                            }
                                        } else {
                                            System.out.println("Produto não encontrado!");
                                        }
                                        break;
                                    case 'n':
                                    case 'N':
                                        break;
                                    default:
                                        System.out.println("opcao invalida!");
                                        break;
                                }   
                            }
                        } else {
                            System.out.println("Pedido não encontrado!");
                        }
                        break;
                    case 5:
                        System.out.println("FECHAR PEDIDO");
                        if(Caixa.pedidos.isEmpty()) {
                            System.out.println("Nenhum pedido aberto!");
                            break;
                        }
                        Interface.imprimirPedidos();
                        System.out.println("Digite o codigo do pedido: ");
                        cod = teclado.nextInt();
                        pedido = Caixa.procuraPedido(cod);
                        if(pedido != null) {
                            Interface.imprimirNotaPedido(pedido);
                            System.out.println("Confirma pagamento?(s/n)");
                            sn = teclado.next().charAt(0);
                            switch(sn){
                                case 's':
                                case 'S':
                                    Caixa.recebePagamento(pedido.fecharPedido());
                                    Caixa.removePedido(pedido);
                                    System.out.println("Pedido fechado com sucesso!");
                                    break;
                                case 'n':
                                case 'N':
                                    System.out.println("O pedido não foi fechado!");
                                    break;
                                default:
                                    System.out.println("Opcao invalida!");
                                    break;
                            }
                            
                        } else {
                            System.out.println("Pedido não encontrado!");
                        }
                        break;
                    case 6:
                        System.out.println("O caixa tem " + String.format("R$%.2f", Caixa.getTotalCaixa()) + " no total");
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        break;

                }
                
            } catch (Exception e) {
                
                System.out.println("Entrada inválida");
                teclado.nextLine();
    
            }
            
        }
        
    }
    
}
