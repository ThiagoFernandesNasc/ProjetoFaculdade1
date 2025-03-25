package services;

import interfaces.repositories.IProfessorRepository;
import interfaces.services.IProfessorService;
import entities.Professor;
import java.util.List;

public class ProfessorService implements IProfessorService {
    private final IProfessorRepository repository;

    public ProfessorService(IProfessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void contratarProfessor(Professor professor) {
        if (repository.buscarPorCpf(professor.getCpf()) != null) {
            throw new IllegalArgumentException("Professor já cadastrado com este CPF");
        }
        repository.salvar(professor);
    }

    @Override
    public Professor buscarProfessorPorCpf(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    @Override
    public void atualizarProfessor(Professor professor) {
        if (repository.buscarPorCpf(professor.getCpf()) == null) {
            throw new IllegalArgumentException("Professor não encontrado");
        }
        repository.alterar(professor);
    }

    @Override
    public void demitirProfessor(String cpf) {
        repository.remover(cpf);
    }

    @Override
    public List<Professor> listarTodosProfessores() {
        return repository.listarTodos();
    }

    public IProfessorRepository getRepository() {
        return null;
    }
}