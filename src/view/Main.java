package view;

import entities.*;
import repositories.*;
import services.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AlunoService alunoService = new AlunoService(new AlunoRepository());
    private static final ProfessorService professorService = new ProfessorService(new ProfessorRepository());
    private static final ModalidadeService modalidadeService = new ModalidadeService(new ModalidadeRepository());
    private static final TurmaService turmaService = new TurmaService(
            new TurmaRepository(),
            alunoService.getRepository(),
            professorService.getRepository(),
            modalidadeService.getRepository()
    );

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n=== ESCOLINHA DE ESPORTES ===");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Modalidades");
            System.out.println("4. Gerenciar Turmas");
            System.out.println("0. Sair");

            int opcao = lerInt("Escolha uma opção", 0, 4);

            switch (opcao) {
                case 1 -> gerenciarAlunos();
                case 2 -> gerenciarProfessores();
                case 3 -> gerenciarModalidades();
                case 4 -> gerenciarTurmas();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                    return;
                }
            }
        }
    }

    // Métodos para Gerenciamento de Alunos (já corretos)
    private static void gerenciarAlunos() {
        while (true) {
            System.out.println("\n=== GERENCIAMENTO DE ALUNOS ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Buscar Aluno");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Remover Aluno");
            System.out.println("5. Listar Alunos");
            System.out.println("0. Voltar");

            int opcao = lerInt("Escolha uma opção", 0, 5);
            if (opcao == 0) return;

            try {
                switch (opcao) {
                    case 1 -> cadastrarAluno();
                    case 2 -> buscarAluno();
                    case 3 -> atualizarAluno();
                    case 4 -> removerAluno();
                    case 5 -> listarAlunos();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- CADASTRAR ALUNO ---");
        Aluno aluno = new Aluno(
                lerString("Nome"),
                lerString("CPF"),
                lerString("Telefone"),
                lerString("Email"),
                lerData("Data de Nascimento (AAAA-MM-DD)"),
                lerString("Responsável"),
                lerString("Observações de Saúde") // Parâmetro faltante adicionado
        );
        alunoService.cadastrar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Métodos para Gerenciamento de Professores (implementados)
    private static void gerenciarProfessores() {
        while (true) {
            System.out.println("\n=== GERENCIAMENTO DE PROFESSORES ===");
            System.out.println("1. Contratar Professor");
            System.out.println("2. Buscar Professor");
            System.out.println("3. Atualizar Professor");
            System.out.println("4. Demitir Professor");
            System.out.println("5. Listar Professores");
            System.out.println("0. Voltar");

            int opcao = lerInt("Escolha uma opção", 0, 5);
            if (opcao == 0) return;

            try {
                switch (opcao) {
                    case 1 -> cadastrarProfessor();
                    case 2 -> buscarProfessor();
                    case 3 -> atualizarProfessor();
                    case 4 -> removerProfessor();
                    case 5 -> listarProfessores();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void buscarProfessor() {
        String cpf = lerString("Digite o CPF do professor");
        Professor professor = professorService.buscarPorCpf(cpf);
        if (professor != null) {
            System.out.println(professor);
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    private static void atualizarProfessor() {
        String cpf = lerString("Digite o CPF do professor");
        Professor professor = professorService.buscarPorCpf(cpf);
        if (professor == null) {
            System.out.println("Professor não encontrado!");
            return;
        }

        System.out.println("\n--- ATUALIZAR PROFESSOR ---");
        professor.setNome(lerString("Nome (" + professor.getNome() + ")"));
        professor.setTelefone(lerString("Telefone (" + professor.getTelefone() + ")"));
        professor.setEmail(lerString("Email (" + professor.getEmail() + ")"));
        professor.setFormacao(lerString("Formação (" + professor.getFormacao() + ")"));
        professor.setEspecialidades(Arrays.asList(lerString("Especialidades (" +
                String.join(",", professor.getEspecialidades()) + ")").split(",")));

        professorService.atualizar(professor);
        System.out.println("Professor atualizado com sucesso!");
    }

    private static void removerProfessor() {
        String cpf = lerString("Digite o CPF do professor");
        professorService.remover(cpf);
        System.out.println("Professor removido com sucesso!");
    }

    private static void listarProfessores() {
        System.out.println("\n--- LISTA DE PROFESSORES ---");
        professorService.listarTodos().forEach(System.out::println);
    }

    // Métodos para Gerenciamento de Modalidades (implementados)
    private static void gerenciarModalidades() {
        while (true) {
            System.out.println("\n=== GERENCIAMENTO DE MODALIDADES ===");
            System.out.println("1. Cadastrar Modalidade");
            System.out.println("2. Buscar Modalidade");
            System.out.println("3. Atualizar Modalidade");
            System.out.println("4. Remover Modalidade");
            System.out.println("5. Listar Modalidades");
            System.out.println("0. Voltar");

            int opcao = lerInt("Escolha uma opção", 0, 5);
            if (opcao == 0) return;

            try {
                switch (opcao) {
                    case 1 -> cadastrarModalidade();
                    case 2 -> buscarModalidade();
                    case 3 -> atualizarModalidade();
                    case 4 -> removerModalidade();
                    case 5 -> listarModalidades();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void buscarModalidade() {
        int id = lerInt("Digite o ID da modalidade");
        Modalidade modalidade = modalidadeService.buscarPorId(id);
        if (modalidade != null) {
            System.out.println(modalidade);
        } else {
            System.out.println("Modalidade não encontrada!");
        }
    }

    private static void atualizarModalidade() {
        int id = lerInt("Digite o ID da modalidade");
        Modalidade modalidade = modalidadeService.buscarPorId(id);
        if (modalidade == null) {
            System.out.println("Modalidade não encontrada!");
            return;
        }

        System.out.println("\n--- ATUALIZAR MODALIDADE ---");
        modalidade.setNome(lerString("Nome (" + modalidade.getNome() + ")"));
        modalidade.setDescricao(lerString("Descrição (" + modalidade.getDescricao() + ")"));
        modalidade.setIdadeMinima(lerInt("Idade Mínima (" + modalidade.getIdadeMinima() + ")"));
        modalidade.setIdadeMaxima(lerInt("Idade Máxima (" + modalidade.getIdadeMaxima() + ")"));

        modalidadeService.atualizar(modalidade);
        System.out.println("Modalidade atualizada com sucesso!");
    }

    private static void removerModalidade() {
        int id = lerInt("Digite o ID da modalidade");
        modalidadeService.remover(id);
        System.out.println("Modalidade removida com sucesso!");
    }

    private static void listarModalidades() {
        System.out.println("\n--- LISTA DE MODALIDADES ---");
        modalidadeService.listarTodos().forEach(System.out::println);
    }

    // Métodos para Gerenciamento de Turmas (implementados)
    private static void buscarTurma() {
        int id = lerInt("Digite o ID da turma");
        Turma turma = turmaService.buscarPorId(id);
        if (turma != null) {
            System.out.println(turma);
        } else {
            System.out.println("Turma não encontrada!");
        }
    }

    private static void atualizarTurma() {
        int id = lerInt("Digite o ID da turma");
        Turma turma = turmaService.buscarPorId(id);
        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.println("\n--- ATUALIZAR TURMA ---");
        turma.setModalidade(modalidadeService.buscarPorId(lerInt("ID da Modalidade (" + turma.getModalidade().getId() + ")")));
        turma.setProfessor(professorService.buscarPorCpf(lerString("CPF do Professor (" + turma.getProfessor().getCpf() + ")")));
        turma.setDiaSemana(DayOfWeek.of(lerInt("Dia da semana (1-7)", 1, 7)));
        turma.setHorario(LocalTime.of(lerInt("Hora", 0, 23), 0));
        turma.setCapacidadeMaxima(lerInt("Capacidade Máxima (" + turma.getCapacidadeMaxima() + ")"));

        turmaService.atualizar(turma);
        System.out.println("Turma atualizada com sucesso!");
    }

    private static void encerrarTurma() {
        int id = lerInt("Digite o ID da turma");
        turmaService.encerrar(id);
        System.out.println("Turma encerrada com sucesso!");
    }

    private static void listarTurmas() {
        System.out.println("\n--- LISTA DE TURMAS ---");
        turmaService.listarTodos().forEach(System.out::println);
    }

    // Métodos auxiliares (já corretos)
    private static String lerString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private static int lerInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    private static int lerInt(String prompt, int min, int max) {
        while (true) {
            int valor = lerInt(prompt + " (" + min + "-" + max + ")");
            if (valor >= min && valor <= max) {
                return valor;
            }
            System.out.println("Valor deve estar entre " + min + " e " + max);
        }
    }

    private static LocalDate lerData(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Use AAAA-MM-DD");
            }
        }
    }
}