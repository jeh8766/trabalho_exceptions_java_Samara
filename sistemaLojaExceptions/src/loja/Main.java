package loja;

import excecoes.OpcaoInvalidaException;
import excecoes.TipoInvalidoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            try {
                System.out.println("Digite a opção desejada:");
                System.out.println("1- Adicionar");
                System.out.println("2 - Listar");
                System.out.println("3 - Buscar");
                System.out.println("4 - Remover");
                System.out.println("5- Sair");
                if (!scanner.hasNextInt()){
                    scanner.nextLine();
                    throw new OpcaoInvalidaException("Entrada invalida, digite um número");
                }

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        try{
                            sistema.cadastrar(scanner);
                        } catch (TipoInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        sistema.listar();
                        break;
                    case 3:
                        sistema.buscar(scanner);
                        break;
                    case 4:
                        sistema.remover(scanner);
                        break;
                    case 5:
                        break;
                    default:
                        throw new OpcaoInvalidaException("Opção invalida, escolha entre 1 e 5");
                }

            } catch (OpcaoInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }while (opcao != 5);
        System.out.println("Voce saiu do sistema");
    }
}
