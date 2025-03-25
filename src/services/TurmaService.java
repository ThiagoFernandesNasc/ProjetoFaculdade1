package services;

import interfaces.repositories.ITurmaRepository;
import interfaces.repositories.IAlunoRepository;
import interfaces.repositories.IProfessorRepository;
import interfaces.repositories.IModalidadeRepository;
import interfaces.services.ITurmaService;
import entities.Turma;
import entities.Aluno;
import java.util.List;

public class TurmaService implements ITurmaService {
    private final ITurmaRepository turmaRepository;
    private final IAlunoRepository alunoRepository;
    private final IProfessorRepository professorRepository;
    private final IModalidadeRepository modalidadeRepository;

    public TurmaService(ITurmaRepository turmaRepository,
                        IAlunoRepository alunoRepository,
                        IProfessorRepository professorRepository,
                        IModalidadeRepository modalidadeRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.modalidadeRepository = modalidadeRepository;
    }

    @Override
    public void criarTurma(Turma turma) {
        if (turmaRepository.buscarPorId(turma.getId()) != null) {
            throw new IllegalArgumentException("Turma com este ID já existe");
        }
        if (professorRepository.buscarPorCpf(turma.getProfessor().getCpf()) == null) {
            throw new IllegalArgumentException("Professor não encontrado");
        }
        if (modalidadeRepository.buscarPorId(turma.getModalidade().getId()) == null) {
            throw new IllegalArgumentException("Modalidade não encontrada");
        }
        turmaRepository.salvar(turma);
    }

    @Override
    public Turma buscarTurmaPorId(int id) {
        return turmaRepository.buscarPorId(id);
    }

    @Override
    public void atualizarTurma(Turma turma) {
        turmaRepository.alterar(turma);
    }

    @Override
    public void encerrarTurma(int id) {
        turmaRepository.remover(id);
    }

    @Override
    public List<Turma> listarTodasTurmas() {
        return turmaRepository.listarTodos();
    }

    @Override
    public boolean matricularAluno(int idTurma, String cpfAluno) {
        Turma turma = turmaRepository.buscarPorId(idTurma);
        Aluno aluno = alunoRepository.buscarPorCpf(cpfAluno);

        if (turma == null || aluno == null) {
            return false;
        }

        return turma.adicionarAluno(aluno);
    }
}