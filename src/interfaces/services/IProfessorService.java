package interfaces.services;

import entities.Professor;
import java.util.List;

public interface IProfessorService {
    void contratarProfessor(Professor professor);
    Professor buscarProfessorPorCpf(String cpf);
    void atualizarProfessor(Professor professor);
    void demitirProfessor(String cpf);
    List<Professor> listarTodosProfessores();
}