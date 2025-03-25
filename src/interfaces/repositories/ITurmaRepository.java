package interfaces.repositories;

import entities.Turma;
import java.util.List;

public interface ITurmaRepository {
    void salvar(Turma turma);
    void remover(int id);
    void alterar(Turma turma);
    List<Turma> listarTodos();
    Turma buscarPorId(int id);
}