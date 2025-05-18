package interfaces;

import entidades.Professor;

public interface IProfessorServico {
    void cadastrar(Professor professor);
    Professor buscarPorId(int id);
    void atualizar(Professor professor);
    void remover(int id);
}
