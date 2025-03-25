package interfaces.services;

import entities.Turma;
import java.util.List;

public interface ITurmaService {
    void criarTurma(Turma turma);
    Turma buscarTurmaPorId(int id);
    void atualizarTurma(Turma turma);
    void encerrarTurma(int id);
    List<Turma> listarTodasTurmas();
    boolean matricularAluno(int idTurma, String cpfAluno);
}