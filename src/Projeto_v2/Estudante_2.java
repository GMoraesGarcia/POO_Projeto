package Projeto_v2;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public abstract class  Estudante_2 {

    private long id;
    private String nome;
    private String email;
    private List<Matricula_2> matricula;

    //contrutor
    public Estudante_2(long id, String nome, String email) {
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

    public List<Matricula_2> getMatriculas() {
        return matricula;
    }

    public void setMatricula(ArrayList<Matricula_2> matricula) {
        this.matricula = matricula;
    }

    public void addMatricula(Matricula_2 m) {
        matricula.add(m);
    }

    public List<Disciplina_2> getDisciplinasMatriculadas() {
        List<Disciplina_2> dis = new ArrayList<>();

        for (Matricula_2 d : matricula) {
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
