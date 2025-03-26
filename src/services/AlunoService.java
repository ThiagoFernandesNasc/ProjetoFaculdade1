package services;

import interfaces.IAlunoService;
import interfaces.IAlunoRepository;
import entities.Aluno;

public class AlunoService implements IAlunoService {
    private IAlunoRepository repository;

    public AlunoService(IAlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Aluno aluno) {
        repository.salvar(aluno);
    }

    @Override
    public Aluno buscar(String matricula) {
        return repository.listar().stream()
            .filter(a -> a.getMatricula().equals(matricula))
            .findFirst()
            .orElse(null);
    }

    @Override
    public void atualizar(Aluno aluno) {
        repository.alterar(aluno);
    }

    @Override
    public void remover(String matricula) {
        repository.remover(matricula);
    }
}
