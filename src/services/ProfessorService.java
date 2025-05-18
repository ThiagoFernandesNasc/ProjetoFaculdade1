package servicos;

import entidades.Professor;
import interfaces.IProfessorRepositorio;
import interfaces.IProfessorServico;

public class ProfessorServico implements IProfessorServico {

    private IProfessorRepositorio repositorio;

    public ProfessorServico(IProfessorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Professor professor) {
        repositorio.salvar(professor);
    }

    @Override
    public Professor buscarPorId(int id) {
        for (Professor p : repositorio.listar()) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void atualizar(Professor professor) {
        repositorio.alterar(professor);
    }

    @Override
    public void remover(int id) {
        repositorio.remover(id);
    }
}
