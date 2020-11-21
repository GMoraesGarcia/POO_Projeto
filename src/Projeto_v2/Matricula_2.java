package Projeto_v2;



/**
 *
 * @author Matheus
 */
public class Matricula_2 {

    private Estudante_2 estudante;
    private Disciplina_2 disciplina;

    public Matricula_2(Estudante_2 estudante, Disciplina_2 disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    public Estudante_2 getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante_2 estudante) {
        this.estudante = estudante;
    }

    public Disciplina_2 getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina_2 disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Matricula{" + "estudante=" + estudante + ", disciplina=" + disciplina + '}';
    }

}
