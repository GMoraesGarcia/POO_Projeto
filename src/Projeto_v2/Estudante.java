package Projeto_v2;



import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public abstract class  Estudante {

    protected long id;
    protected String nome;
    protected String email;
    protected List<Matricula> matricula;

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
    //metodo abstrato para apresentar as horas complementares dos alunos
    public abstract int getTotalCreditos();

   

}
