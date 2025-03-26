package repositories;

import interfaces.IAlunoRepository;
import entities.Aluno;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AlunoRepository implements IAlunoRepository {
    private Stack<Aluno> pilhaAlunos = new Stack<>();

    @Override
    public void salvar(Aluno aluno) {
        pilhaAlunos.push(aluno);
    }

    @Override
    public void remover(String matricula) {
        pilhaAlunos.removeIf(a -> a.getMatricula().equals(matricula));
    }

    @Override
    public void alterar(Aluno aluno) {
        for (Aluno a : pilhaAlunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                a.setNome(aluno.getNome());
                a.setModalidade(aluno.getModalidade());
                break;
            }
        }
    }

    @Override
    public List<Aluno> listar() {
        return new ArrayList<>(pilhaAlunos);
    }
}
