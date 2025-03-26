package interfaces;

import entities.Aluno;

public interface IAlunoService {
    void cadastrar(Aluno aluno);
    Aluno buscar(String matricula);
    void atualizar(Aluno aluno);
    void remover(String matricula);
}
