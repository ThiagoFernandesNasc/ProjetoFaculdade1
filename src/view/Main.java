package view;

import entidades.Professor;
import interfaces.IProfessorRepositorio;
import interfaces.IProfessorServico;
import repositorios.ProfessorRepositorio;
import servicos.ProfessorServico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IProfessorRepositorio repositorio = new ProfessorRepositorio();
        IProfessorServico servico = new ProfessorServico(repositorio);

        while (true) {
            System.out.println("\n===== MENU PROFESSORES =====");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Buscar Professor por ID");
            System.out.println("3. Atualizar Professor");
            System.out.println("4. Remover Professor");
            System.out.println("5. Listar Professores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplina = sc.nextLine();
                    servico.cadastrar(new Professor(id, nome, disciplina));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    Professor p = servico.buscarPorId(id);
                    System.out.println(p != null ? p : "Professor não encontrado.");
                }
                case 3 -> {
                    System.out.print("ID do professor a atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Nova disciplina: ");
                    String disciplina = sc.nextLine();
                    servico.atualizar(new Professor(id, nome, disciplina));
                }
                case 4 -> {
                    System.out.print("ID do professor a remover: ");
                    int id = sc.nextInt();
                    servico.remover(id);
                }
                case 5 -> {
                    for (Professor p : repositorio.listar()) {
                        System.out.println(p);
                    }
                }
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
