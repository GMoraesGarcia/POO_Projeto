package Projeto_v2;


import java.util.ArrayList;
import java.util.List;

/**
 *
* @author Matheus
 */
public class Disciplina {

    private String codigo;
    private int creditos;
    private List<Matricula> matricula;

    //construtor
    public Disciplina(String codigo, int creditos) {
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

    public List<Matricula> getMatriculas() {
        return matricula;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matricula = matriculas;
    }

    public void addMatricula(Matricula m) {
        matricula.add(m);
    }

    public List<Estudante> getEstudantesMatriculados() {
        List<Estudante> est = new ArrayList<>();

        for (Matricula d : matricula) {
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
