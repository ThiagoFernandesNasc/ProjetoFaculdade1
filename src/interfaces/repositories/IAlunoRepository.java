package interfaces.repositories;

import entities.Aluno;
import java.util.List;

public interface IAlunoRepository {
    void salvar(Aluno aluno);
    void remover(String cpf);
    void alterar(Aluno aluno);
    List<Aluno> listarTodos();
    Aluno buscarPorCpf(String cpf);
}