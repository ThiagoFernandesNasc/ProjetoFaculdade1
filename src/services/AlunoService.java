package services;

import interfaces.repositories.IAlunoRepository;
import interfaces.services.IAlunoService;
import entities.Aluno;
import java.util.List;

public class AlunoService implements IAlunoService {
    private final IAlunoRepository repository;

    public AlunoService(IAlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarAluno(Aluno aluno) {
        if (repository.buscarPorCpf(aluno.getCpf()) != null) {
            throw new IllegalArgumentException("Aluno já cadastrado com este CPF");
        }
        repository.salvar(aluno);
    }

    @Override
    public Aluno buscarAlunoPorCpf(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    @Override
    public void atualizarAluno() {
        if (repository.buscarPorCpf(aluno.getCpf()) == null) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
        repository.alterar(aluno);
    }

    @Override
    public void removerAluno(String cpf) {
        repository.remover(cpf);
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        return repository.listarTodos();
    }

    public IAlunoRepository getRepository() {
        return null;
    }

    public void cadastrar(Aluno aluno) {

    }

    public void atualizarAluno() {
    }
}