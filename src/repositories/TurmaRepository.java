package repositories;

import interfaces.repositories.ITurmaRepository;
import entities.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository implements ITurmaRepository {
    private List<Turma> turmas = new ArrayList<>();

    @Override
    public void salvar(Turma turma) {
        turmas.add(turma);
    }

    @Override
    public void remover(int id) {
        turmas.removeIf(t -> t.getId() == id);
    }

    @Override
    public void alterar(Turma turma) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getId() == turma.getId()) {
                turmas.set(i, turma);
                break;
            }
        }
    }

    @Override
    public List<Turma> listarTodos() {
        return new ArrayList<>(turmas);
    }

    @Override
    public Turma buscarPorId(int id) {
        return turmas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}