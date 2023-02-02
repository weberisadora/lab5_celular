package ui;

import negocio.Celular;
import negocio.Chamada;
import negocio.Contato;

import java.util.List;
import java.util.Scanner;

public class CelularUI {
    Celular celular;
    Scanner scanner;
    private int opcao;

    public CelularUI() {
        celular = new Celular();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        do {
            System.out.println("Menu");
            exibeOpcoes();
            solicitaOpcao();
            validaOpcao();
            scanner.nextLine();
            verificaOpcao();
        } while (opcao < 6);
    }

    public void exibeOpcoes() {
        System.out.println("[1] Cadastrar contato\n" +
                "[2] Remover contato\n" +
                "[3] Cadastrar chamada não atendida\n" +
                "[4] Mostrar lista de chamadas não atendidas\n" +
                "[5] Excluir todas as chamadas não atendidas\n" +
                "[6] Sair");
    }

    public void solicitaOpcao() {
        System.out.println("O que você deseja fazer?\nDigite o número correspondente à operação desejada:");
        opcao = scanner.nextInt();
    }

    public void validaOpcao() {
        while (opcao < 1 || opcao > 6) {
            System.out.println("Opção inválida");
            solicitaOpcao();
        }
    }

    public void verificaOpcao() {
        switch (opcao) {
            case 1:
                cadastraContato();
                break;

            case 2:
                removeContato();
                break;

            case 3:
                cadastraChamada();
                break;

            case 4:
                exibeChamadas();
                break;

            case 5:
                celular.excluiTodasAsChamadasNaoAtendidas();
                break;

            case 6:
                break;
        }
    }

    private void cadastraContato() {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();
        celular.cadastraContato(new Contato(nome, telefone));
    }

    private void removeContato() {
        System.out.println("Digite o telefone do contato que deseja remover:");
        String telefone = scanner.nextLine();

        List<Contato> contatos = celular.getContatos();

        for (Contato contato : contatos) {
            if (telefone.equals(contato.getTelefone())) {
                celular.removeContato(contato);
                System.out.println("Contato removido com sucesso!");
                break;
            }

            System.out.println("Contato não encontrado");
        }
    }

    private void cadastraChamada() {
        System.out.println("Digite o número da chamada que deseja cadastrar:");
        String numero = scanner.nextLine();
        celular.cadastraChamada(new Chamada(numero));
        System.out.println("Chamada cadastrada com sucesso!");
    }

    private void exibeChamadas() {
        if (!celular.getChamadas().isEmpty()) {
            String telefoneChamada;
            Contato contato;
            List<Chamada> chamadas = celular.getChamadas();

            System.out.println("Chamadas não atendidas:");

            for (Chamada chamada : chamadas) {
                telefoneChamada = chamada.getTelefone();
                contato = celular.getContatoByNumber(telefoneChamada);

                if (contato != null)
                    System.out.println("Nome: " + contato.getNome() + " | Telefone: " + contato.getTelefone());
                else
                    System.out.println(telefoneChamada);
            }
        } else
            System.out.println("A lista de chamadas não atendidas está vazia.");
    }
}
