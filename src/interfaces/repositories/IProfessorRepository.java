package interfaces.repositories;

import entities.Professor;
import java.util.List;

public interface IProfessorRepository {
    void salvar(Professor professor);
    void remover(String cpf);
    void alterar(Professor professor);
    List<Professor> listarTodos();
    Professor buscarPorCpf(String cpf);
}