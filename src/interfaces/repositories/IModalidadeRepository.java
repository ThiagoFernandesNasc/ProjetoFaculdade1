package interfaces.repositories;

import entities.Modalidade;
import java.util.List;

public interface IModalidadeRepository {
    void salvar(Modalidade modalidade);
    void remover(int id);
    void alterar(Modalidade modalidade);
    List<Modalidade> listarTodos();
    Modalidade buscarPorId(int id);
}