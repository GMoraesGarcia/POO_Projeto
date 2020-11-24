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

    private final Centro_Universitario centro_universitario;
    private final String nomeCentro_UniversitarioEsperado;
    private List<Disciplina> disciplinasArray;
    private List<Estudante> estudantesArray;
    private List<Estudante> matriculasPorEstudante;
    private List<Matricula> matriculasPorDisciplina;
    private List<Matricula> matriculasArray;

    public Centro_UniversitarioTest_2() throws FileNotFoundException {
        nomeCentro_UniversitarioEsperado = "Centro_Universitario SENAC";
        centro_universitario = new Centro_Universitario(nomeCentro_UniversitarioEsperado);
        centro_universitario.carregarDadosArquivo("disciplinas.txt", "estudantes.txt",
                "matriculas.txt");
    }

    public Estudante findEstudanteById(int id, List<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (id == estudante.getId()) {
                return estudante; //estudante encontrado
            }
        }
        return null; //estudante não encontrado
    }

    public Disciplina findDisciplinaByCodigo(String codigo, List<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
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
        List<Estudante> estudantes = centro_universitario.getEstudantes();
        int numeroEsperado = centro_universitario.getEstudantes().size();
        int numeroObtido = estudantes.size();
        Assert.assertEquals(numeroEsperado, numeroObtido);
        for (Estudante estudanteArray : estudantesArray) {
            int id = (int) estudanteArray.getId();
            String nomeEsperado = estudanteArray.getNome();
            String emailEsperado = estudanteArray.getEmail();
            Estudante estudanteEncontrado = findEstudanteById(id, estudantes);
            assertNotNull(estudanteEncontrado);
            assertEquals(nomeEsperado, estudanteEncontrado.getNome());
            assertEquals(emailEsperado, estudanteEncontrado.getEmail());
        }
    }

    @Test
    public void testDisciplinas() {
        disciplinasArray = centro_universitario.getDisciplinas();
        List<Disciplina> disciplinas = centro_universitario.getDisciplinas();
        int numeroEsperado = centro_universitario.getDisciplinas().size();
        int numeroObtido = disciplinas.size();
        assertEquals(numeroEsperado, numeroObtido);
        for (Disciplina disciplinaArray : disciplinasArray) {
            String codigo = disciplinaArray.getCodigo();
            int creditos = disciplinaArray.getCreditos();
            Disciplina disciplinaEncontrada = findDisciplinaByCodigo(codigo, disciplinas);
            assertNotNull(disciplinaEncontrada);
            assertEquals(creditos, disciplinaEncontrada.getCreditos());
        }
    }

    @Test
    public void testMatriculas() {

        List<Estudante> estudantes = centro_universitario.getEstudantes();
        List<Disciplina> disciplinas = centro_universitario.getDisciplinas();
        List<Matricula> matriculas = null;
        estudantesArray = centro_universitario.getEstudantes();
        for (Estudante est : estudantes) {

            matriculasArray = est.getMatriculas();
        }
        for (Disciplina dis : disciplinas) {
            matriculasPorEstudante = dis.getEstudantesMatriculados();
        }

        int cont = 0;
        for (Matricula matriculaArray : matriculasArray) {
            int idEstudante = (int) matriculasArray.get(cont).getEstudante().getId();
            String codigoDisciplina = matriculaArray.getDisciplina().getCodigo();
            Estudante estudante = findEstudanteById(idEstudante, estudantes);
            Disciplina disciplina = findDisciplinaByCodigo(codigoDisciplina, disciplinas);

            Matricula matriculaEncontradaInEstudante = null;
            matriculas = estudante.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInEstudante = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInEstudante);

            Matricula matriculaEncontradaInDisciplina = null;
            matriculas = disciplina.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInDisciplina = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInDisciplina);
            cont++;
        }
    }

    // testar se é aluno de graduação e pos
    @Test
    public void testEstudante() {
        List<Estudante> estudantes = centro_universitario.getEstudantes();        
        Estudante estudanteTesteG = estudantes.get(0);
        Estudante estudanteTesteP = estudantes.get(4);
        assertTrue(estudanteTesteG instanceof EstudanteGrad);
        assertTrue(estudanteTesteP instanceof EstudantePos);
    }
}
