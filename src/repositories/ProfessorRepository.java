package repositories;

import interfaces.repositories.IProfessorRepository;
import entities.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository implements IProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    @Override
    public void salvar(Professor professor) {
        professores.add(professor);
    }

    @Override
    public void remover(String cpf) {
        professores.removeIf(p -> p.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Professor professor) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getCpf().equals(professor.getCpf())) {
                professores.set(i, professor);
                break;
            }
        }
    }

    @Override
    public List<Professor> listarTodos() {
        return new ArrayList<>(professores);
    }

    @Override
    public Professor buscarPorCpf(String cpf) {
        return professores.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}