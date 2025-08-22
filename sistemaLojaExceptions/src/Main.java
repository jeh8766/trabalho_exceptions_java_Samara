import java.util.Scanner;

public class Main {
     public static void main(String[] args) {

            Sistema sistema = new Sistema();
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("Digite a opção desejada:");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Listar");
                System.out.println("3 - Buscar");
                System.out.println("4 - Remover");
                System.out.println("5 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        sistema.cadastrar(scanner);
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
                        System.out.println("Opção inválida!");
                        break;
                }

            } while (opcao != 5);

            System.out.println("Saindo do Sistema!");
        }
    }
