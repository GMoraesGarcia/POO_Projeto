package Projeto_v2;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class Centro_UniversitarioTest_2 {

    private final Centro_Universitario_2 centro_universitario;
    private final String nomeCentro_UniversitarioEsperado;
    private List<Disciplina_2> disciplinasArray;
    private List<Estudante_2> estudantesArray;
    private List<Matricula_2> matriculasPorEstudante;
    private List<Matricula_2> matriculasPorDisciplina;
    private String[][] matriculasArray;

    public Centro_UniversitarioTest_2() throws FileNotFoundException {
        nomeCentro_UniversitarioEsperado = "Centro_Universitario SENAC";
        centro_universitario = new Centro_Universitario_2(nomeCentro_UniversitarioEsperado);
        centro_universitario.carregarDadosArquivo("disciplinas.txt", "estudantes.txt",
                "matriculas.txt");
    }

    public Estudante_2 findEstudanteById(int id, List<Estudante_2> estudantes) {
        for (Estudante_2 estudante : estudantes) {
            if (id == estudante.getId()) {
                return estudante; //estudante encontrado
            }
        }
        return null; //estudante não encontrado
    }

    public Disciplina_2 findDisciplinaByCodigo(String codigo, List<Disciplina_2> disciplinas) {
        for (Disciplina_2 disciplina : disciplinas) {
            if (codigo.equals(disciplina.getCodigo())) {
                return disciplina;//disciplina encontrada
            }
        }
        return null;//disciplina não encontrada
    }

    @Test
    public void testNomeCentro_Universitario() {
        String nomeObtido = centro_universitario.getNome();
        assertEquals(nomeCentro_UniversitarioEsperado, nomeObtido);
    }

    @Test
    public void testEstudantes() {
        estudantesArray = centro_universitario.getEstudantes();
        List<Estudante_2> estudantes = centro_universitario.getEstudantes();
        int numeroEsperado = centro_universitario.getEstudantes().size();
        int numeroObtido = estudantes.size();
        Assert.assertEquals(numeroEsperado, numeroObtido);
        for (Estudante_2 estudanteArray : estudantesArray) {
            int id = (int) estudanteArray.getId();
            String nomeEsperado = estudanteArray.getNome();
            String emailEsperado = estudanteArray.getEmail();
            Estudante_2 estudanteEncontrado = findEstudanteById(id, estudantes);
            assertNotNull(estudanteEncontrado);
            assertEquals(nomeEsperado, estudanteEncontrado.getNome());
            assertEquals(emailEsperado, estudanteEncontrado.getEmail());
        }
    }

    @Test
    public void testDisciplinas() {
        disciplinasArray = centro_universitario.getDisciplinas();
        List<Disciplina_2> disciplinas = centro_universitario.getDisciplinas();
        int numeroEsperado = centro_universitario.getDisciplinas().size();
        int numeroObtido = disciplinas.size();
        assertEquals(numeroEsperado, numeroObtido);
        for (Disciplina_2 disciplinaArray : disciplinasArray) {
            String codigo = disciplinaArray.getCodigo();
            int creditos = disciplinaArray.getCreditos();
            Disciplina_2 disciplinaEncontrada = findDisciplinaByCodigo(codigo, disciplinas);
            assertNotNull(disciplinaEncontrada);
            assertEquals(creditos, disciplinaEncontrada.getCreditos());
        }
    }

    @Test
    public void testMatriculas() {

        List<Estudante_2> estudantes = centro_universitario.getEstudantes();
        List<Disciplina_2> disciplinas = centro_universitario.getDisciplinas();
        List<Matricula_2> matriculas = null;
        estudantesArray = centro_universitario.getEstudantes();
        for (Estudante_2 est : estudantes) {
            matriculasPorEstudante = est.getMatriculas();
        }

        for (int i = 0; i < estudantesArray.size(); i++) {
            Estudante_2 estudanteArray = estudantesArray.get(i);
            int id = (int) estudanteArray.getId();
            Estudante_2 estudante = findEstudanteById(id, estudantes);
            assertEquals(matriculasPorEstudante.get(i), estudante.getMatriculas().size());
        }

        for (int i = 0; i < disciplinasArray.size(); i++) {
            Disciplina_2 disciplinaArray = disciplinasArray.get(i);
            String codigo = disciplinaArray.getCodigo();
            Disciplina_2 disciplina = findDisciplinaByCodigo(codigo, disciplinas);
            assertEquals(matriculasPorDisciplina.get(i), disciplina.getMatriculas().size());
        }

        for (String[] matriculaArray : matriculasArray) {
            int idEstudante = Integer.parseInt(matriculaArray[0]);
            String codigoDisciplina = matriculaArray[1];
            Estudante_2 estudante = findEstudanteById(idEstudante, estudantes);
            Disciplina_2 disciplina = findDisciplinaByCodigo(codigoDisciplina, disciplinas);

            Matricula_2 matriculaEncontradaInEstudante = null;
            matriculas = estudante.getMatriculas();
            for (Matricula_2 matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInEstudante = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInEstudante);

            Matricula_2 matriculaEncontradaInDisciplina = null;
            matriculas = disciplina.getMatriculas();
            for (Matricula_2 matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInDisciplina = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInDisciplina);
        }
    }
}
