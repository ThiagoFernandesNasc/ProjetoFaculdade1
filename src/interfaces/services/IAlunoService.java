package interfaces.services;

import entities.Aluno;
import java.util.List;

public interface IAlunoService {
    void cadastrarAluno(Aluno aluno);
    Aluno buscarAlunoPorCpf(String cpf);
    void atualizarAluno();
    void removerAluno(String cpf);
    List<Aluno> listarTodosAlunos();
}