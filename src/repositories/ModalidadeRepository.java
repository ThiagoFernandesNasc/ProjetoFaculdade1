package repositories;

import interfaces.repositories.IModalidadeRepository;
import entities.Modalidade;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeRepository implements IModalidadeRepository {
    private List<Modalidade> modalidades = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void salvar(Modalidade modalidade) {
        modalidade.setId(proximoId++);
        modalidades.add(modalidade);
    }

    @Override
    public void remover(int id) {
        modalidades.removeIf(m -> m.getId() == id);
    }

    @Override
    public void alterar(Modalidade modalidade) {
        for (int i = 0; i < modalidades.size(); i++) {
            if (modalidades.get(i).getId() == modalidade.getId()) {
                modalidades.set(i, modalidade);
                break;
            }
        }
    }

    @Override
    public List<Modalidade> listarTodos() {
        return new ArrayList<>(modalidades);
    }

    @Override
    public Modalidade buscarPorId(int id) {
        return modalidades.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
}