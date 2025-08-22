package loja;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Produto> produtos;

    public Sistema() {
        this.produtos = new ArrayList<Produto>();
    }

    public void cadastrar(Scanner scanner) {
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade em estoque do produto: ");
        double qnt = scanner.nextDouble();

        if (preco < 0 || qnt < 0) {
            throw new IllegalArgumentException("");
        }

        System.out.println("Digite o tipo do produto");
        System.out.println("1- Móvel");
        System.out.println("2- Eletro");

        int opcaoTipo = scanner.nextInt();
        scanner.nextLine();

        if (opcaoTipo == 1) {
            cadastrarMovel(scanner, nome, preco, qnt);
        } else if (opcaoTipo == 2) {
            cadastrarEletro(scanner, nome, preco, qnt);
        } else {
            System.out.println("Opção Inválida!");
        }
    }

    private void cadastrarMovel(Scanner scanner, String nome, double preco, double quantidade) {
        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();
        Movel movel = new Movel(nome, preco, quantidade, categoria);
        produtos.add(movel);
        System.out.println("Móvel cadastrado com sucesso!");
    }

    private void cadastrarEletro(Scanner scanner, String nome, double preco, double quantidade) {
        System.out.println("Digite a voltagem:");
        int voltagem = scanner.nextInt();

        if (voltagem != 110 && voltagem != 220) {
            throw new IllegalArgumentException("Selecione uma voltagem compativel (110 ou 220)");
        }

        EletroDomestico eletro = new EletroDomestico(nome, preco, quantidade, voltagem);
        produtos.add(eletro);
        System.out.println("Eletrodoméstico cadastrado com sucesso!");
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public Produto buscar(Scanner scanner) {
        System.out.println("Digite o nome do produto procurado:");
        String nomeProduto = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                System.out.println("loja.Produto Encontrado");
                System.out.println(produto);
                return produto;
            }
        }

        throw new NoSuchElementException("loja.Produto não encontrado: " + nomeProduto);
    }

    public void remover(Scanner scanner) {
        try {
            Produto prod = buscar(scanner);
            produtos.remove(prod);
            System.out.println("loja.Produto removido com sucesso!");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}