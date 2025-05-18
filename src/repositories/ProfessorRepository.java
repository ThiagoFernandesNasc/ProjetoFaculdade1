package repositorios;

import entidades.Professor;
import interfaces.IProfessorRepositorio;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositorio implements IProfessorRepositorio {

    private Node head;

    private class Node {
        Professor professor;
        Node next;

        Node(Professor professor) {
            this.professor = professor;
        }
    }

    @Override
    public void salvar(Professor professor) {
        Node novo = new Node(professor);
        novo.next = head;
        head = novo;
    }

    @Override
    public void remover(int id) {
        Node atual = head, anterior = null;
        while (atual != null) {
            if (atual.professor.getId() == id) {
                if (anterior == null) head = atual.next;
                else anterior.next = atual.next;
                return;
            }
            anterior = atual;
            atual = atual.next;
        }
    }

    @Override
    public void alterar(Professor professor) {
        Node atual = head;
        while (atual != null) {
            if (atual.professor.getId() == professor.getId()) {
                atual.professor = professor;
                return;
            }
            atual = atual.next;
        }
    }

    @Override
    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        Node atual = head;
        while (atual != null) {
            lista.add(atual.professor);
            atual = atual.next;
        }
        return lista;
    }
}
