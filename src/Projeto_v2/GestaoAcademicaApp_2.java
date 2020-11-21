/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_v2;

import Projeto_v1.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoAcademicaApp_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Centro_Universitario Senac = new Centro_Universitario("Senac");
        Senac.carregarDadosArquivo("disciplinas-abadbdceeb.txt", "estudantes-abadbdceeb.txt", "matriculas-abadbdceeb.txt");
        int opcao = 0;
        String codigo;
        long id;

        while (opcao != 5) {

            System.out.println("*******BEM VINDO AO APP DE GESTÃO ACADEMICA*******");
            System.out.println("ESCOLHA UMA OPÇÃO:");
            System.out.println("1)LISTAR NOME E NÚMERO DE TODOS OS ESTUDANTES");
            System.out.println("2)LISTAR O CÓDIGO DE TODAS AS DISCIPLINAS");
            System.out.println("3)LISTAR TODAS AS INFORMAÇÕES DOS ESTUDANTES MATRICULADOS EM UMA DETERMINADA DISCIPLINA");
            System.out.println("4)LISTAR TODAS AS INFORMAÇÕES DAS DISCIPLINAS EM QUE UM DETERMINADO ESTUDANTE ESTÁ MATRICULADO");
            System.out.println("5)SAIR");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("LISTA DE ESTUDANTES: ");                    
                    System.out.println(getNomeNumero2(Senac));
                    break;
                case 2:
                    System.out.println("LISTA DE CÓDIGOS DAS DISCIPLINAS: ");                    
                    System.out.println(getCodigoDisciplina2(Senac));
                    break;
                case 3:
                    System.out.println("DIGITE O CÓDIGO DA DISCIPLINA: ");
                    codigo = sc.next();
                    System.out.println("LISTA DE MATRICULADOS NA DISCIPLINA: ");                    
                    System.out.println(getEstudantesPorDisciplina(codigo, Senac));
                    System.out.println("NÚMERO TOTAL DE ALUNOS MATRICULADOS NA DISCIPLINA: ");                    
                    System.out.println(getNumeroAlunos(codigo, Senac));
                    break;
                case 4:
                    System.out.println("DIGITE O NÚMERO DO ESTUDANTE: ");
                    id = sc.nextLong();
                    System.out.println("LISTA DE INFORMAÇÕES DAS DISCIPLINAS QUE O ALUNO ESTÁ MATRICULADO: ");
                    //System.out.println(Senac.getCodigoCredito(id));
                    System.out.println(getDisciplinasPorEstudante(id, Senac));
                    System.out.println("TOTAL DE CRÉDITOS DAS MATRÍCULAS DO ALUNO: ");                    
                    System.out.println(getTotalCreditosAluno(id, Senac));
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }
        }
    }

    public static ArrayList getNomeNumero2(Centro_Universitario centro) {

        ArrayList nomeNumero = new ArrayList();

        for (Estudante e : centro.getEstudantes()) {

            nomeNumero.add("\nEstudante {id = " + e.getId() + " Nome = " + e.getNome() + "}");

        }
        return nomeNumero;
    }

    public static ArrayList getCodigoDisciplina2(Centro_Universitario centro) {

        ArrayList codDisciplina = new ArrayList();

        for (Disciplina d : centro.getDisciplinas()) {

            codDisciplina.add("\n{Código da disciplina: " + d.getCodigo() + "}");
        }
        return codDisciplina;
    }

    public static List getEstudantesPorDisciplina(String codigo, Centro_Universitario centro) {

        List estudantes = new ArrayList();
        for (Disciplina d : centro.getDisciplinas()) {
            if (codigo.equals(d.getCodigo())) {
                estudantes = d.getEstudantesMatriculados();
            }
        }
        return estudantes;
    }

    public static int getNumeroAlunos(String codigo, Centro_Universitario centro) {

        List<Estudante> estudantes = getEstudantesPorDisciplina(codigo, centro);
        int numAlunos = estudantes.size();
        return numAlunos;
    }

    public static List getDisciplinasPorEstudante(long id, Centro_Universitario centro) {

        List Disciplinas = new ArrayList();
        for (Estudante e : centro.getEstudantes()) {
            if (id == e.getId()) {
                Disciplinas = e.getDisciplinasMatriculadas();
            }
        }
        return Disciplinas;
    }

    public static int getTotalCreditosAluno(long id, Centro_Universitario centro) {

        List<Disciplina> disciplinas = getDisciplinasPorEstudante(id, centro);
        int creditos = 0;
        for (Disciplina d : disciplinas) {
            creditos += d.getCreditos();
        }

        return creditos;
    }
}
