package view;

import services.AlunoService;
import repositories.AlunoRepository;
import entities.Aluno;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoRepository repository = new AlunoRepository();
        AlunoService service = new AlunoService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Buscar Aluno");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Remover Aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Modalidade: ");
                    String modalidade = scanner.nextLine();
                    service.cadastrar(new Aluno(matricula, nome, modalidade));
                    break;
                case 2:
                    System.out.print("Digite a matrícula: ");
                    Aluno aluno = service.buscar(scanner.nextLine());
                    System.out.println(aluno != null ? aluno : "Aluno não encontrado!");
                    break;
                case 3:
                    System.out.println("\nLista de Alunos:");
                    service.listar().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Matrícula para remover: ");
                    service.remover(scanner.nextLine());
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
