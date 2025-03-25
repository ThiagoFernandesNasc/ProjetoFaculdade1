package entities;

import java.time.LocalDate;
import java.util.List;

public class Professor extends Pessoa {
    private String formacao;
    private List<String> especialidades;
    private LocalDate dataContratacao;

    public Professor() {
    }

    public Professor(String nome, String cpf, String telefone, String email,
                     String formacao, List<String> especialidades, LocalDate dataContratacao) {
        super(nome, cpf, telefone, email);
        this.formacao = formacao;
        this.especialidades = especialidades;
        this.dataContratacao = dataContratacao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Professor: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Formação: " + formacao);
        System.out.println("Especialidades: " + String.join(", ", especialidades));
    }

    // Getters e Setters específicos
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}