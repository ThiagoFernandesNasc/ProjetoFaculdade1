package interfaces;

import entities.Aluno;
import java.util.List;

public interface IAlunoRepository {
    void salvar(Aluno aluno);
    void remover(String matricula);
    void alterar(Aluno aluno);
    List<Aluno> listar();
}
