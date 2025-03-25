package interfaces.services;

import entities.Modalidade;
import java.util.List;

public interface IModalidadeService {
    void cadastrarModalidade(Modalidade modalidade);
    Modalidade buscarModalidadePorId(int id);
    void atualizarModalidade(Modalidade modalidade);
    void removerModalidade(int id);
    List<Modalidade> listarTodasModalidades();
}