package Projeto_v2;



/**
 *
 * @author Matheus
 */
public class Matricula {

    private Estudante estudante;
    private Disciplina disciplina;

    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Matricula{" + "estudante=" + estudante + ", disciplina=" + disciplina + '}';
    }

}
