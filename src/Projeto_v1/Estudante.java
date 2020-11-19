package Projeto_v1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Estudante {

    private long id;
    private String nome;
    private String email;
    private List<Matricula> matricula;

    //contrutor
    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Matricula> getMatriculas() {
        return matricula;
    }

    public void setMatricula(ArrayList<Matricula> matricula) {
        this.matricula = matricula;
    }

    public void addMatricula(Matricula m) {
        matricula.add(m);
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        List<Disciplina> dis = new ArrayList<>();

        for (Matricula d : matricula) {
            if (d.getEstudante().id == this.id) {
                dis.add(d.getDisciplina());
            }
        }
        return dis;
    }

    @Override
    public String toString() {
        return "Estudante{" + "id=" + id + ", nome=" + nome + ", email=" + email + '}';
    }

}
