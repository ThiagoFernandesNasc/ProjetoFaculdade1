package repositories;

import interfaces.repositories.IAlunoRepository;
import entities.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository implements IAlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void remover(String cpf) {
        alunos.removeIf(a -> a.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCpf().equals(aluno.getCpf())) {
                alunos.set(i, aluno);
                break;
            }
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }

    @Override
    public Aluno buscarPorCpf(String cpf) {
        return alunos.stream()
                .filter(a -> a.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}