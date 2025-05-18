package interfaces;

import entidades.Professor;
import java.util.List;

public interface IProfessorRepositorio {
    void salvar(Professor professor);
    void remover(int id);
    void alterar(Professor professor);
    List<Professor> listar();
}
