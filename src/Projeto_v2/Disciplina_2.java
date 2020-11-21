package Projeto_v2;


import java.util.ArrayList;
import java.util.List;

/**
 *
* @author Matheus
 */
public class Disciplina_2 {

    private String codigo;
    private int creditos;
    private List<Matricula_2> matricula;

    //construtor
    public Disciplina_2(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.matricula = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Matricula_2> getMatriculas() {
        return matricula;
    }

    public void setMatriculas(ArrayList<Matricula_2> matriculas) {
        this.matricula = matriculas;
    }

    public void addMatricula(Matricula_2 m) {
        matricula.add(m);
    }

    public List<Estudante_2> getEstudantesMatriculados() {
        List<Estudante_2> est = new ArrayList<>();

        for (Matricula_2 d : matricula) {
            if (d.getDisciplina().codigo == this.codigo) {
                est.add(d.getEstudante());
            }
        }
        return est;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", creditos=" + creditos + '}';
    }

}
