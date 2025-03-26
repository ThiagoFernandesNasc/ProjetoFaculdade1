package entities;

public class Aluno {
    private String matricula;
    private String nome;
    private String modalidade;

    // Construtores
    public Aluno() {}
    public Aluno(String matricula, String nome, String modalidade) {
        this.matricula = matricula;
        this.nome = nome;
        this.modalidade = modalidade;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + ", modalidade=" + modalidade + "]";
    }
}
