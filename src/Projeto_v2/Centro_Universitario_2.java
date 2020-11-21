/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_v2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Centro_Universitario_2 {

    private String nome;
    private List<Estudante_2> estudante;
    private List<Disciplina_2> disciplina;

    //construtor
    public Centro_Universitario_2(String nome) {
        this.nome = nome;
        this.estudante = new ArrayList();
        this.disciplina = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estudante_2> getEstudantes() {
        return estudante;
    }

    public void setEstudante(ArrayList<Estudante_2> estudante) {
        this.estudante = estudante;
    }

    public List<Disciplina_2> getDisciplinas() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina_2> disciplina) {
        this.disciplina = disciplina;
    }

    public void carregarDadosArquivo(String arqDisciplina, String arqEstudante, String arqMatricula) {

        try {
            BufferedReader r = new BufferedReader(new FileReader(arqEstudante));
            BufferedReader r2 = new BufferedReader(new FileReader(arqDisciplina));
            BufferedReader r3 = new BufferedReader(new FileReader(arqMatricula));

            Matricula_2 mat = null;

            String vEstudante[];
            String vDisciplina[];
            String vMatricula[];

            String linhaArqMat = " ";
            String linhaArqEst = " ";
            String linhaArqDis = " ";

            while (linhaArqEst != null) {

                linhaArqEst = r.readLine();

                if (linhaArqEst == null) {
                    break;
                }

                vEstudante = linhaArqEst.split(":");

                if (vEstudante.length == 5) {

                    Estudante_2 est = new EstudanteGrad(Integer.parseInt(vEstudante[0]),
                            vEstudante[1],
                            vEstudante[2],
                            Integer.parseInt(vEstudante[3]));
                    this.estudante.add(est);
                    
                }else{
                    
                    Estudante_2 est = new EstudantePos(Integer.parseInt(vEstudante[0]),
                            vEstudante[1],
                            vEstudante[2],
                            vEstudante[3],
                            vEstudante[4]);
                    this.estudante.add(est);
                    
                }
            }

            r.close();

            while (linhaArqDis != null) {

                linhaArqDis = r2.readLine();

                if (linhaArqDis == null) {
                    break;
                }
                vDisciplina = linhaArqDis.split(":");

                Disciplina_2 dis = new Disciplina_2(vDisciplina[0], Integer.parseInt(vDisciplina[1]));

                this.disciplina.add(dis);
            }
            r2.close();

            while (linhaArqMat != null) {

                linhaArqMat = r3.readLine();

                if (linhaArqMat == null) {
                    break;
                }

                vMatricula = linhaArqMat.split(":");

                for (int i = 0; i < estudante.size(); i++) {

                    long id = Integer.parseInt(vMatricula[0]);

                    if (id == estudante.get(i).getId()) {

                        for (int j = 0; j < disciplina.size(); j++) {

                            if (vMatricula[1].equals(disciplina.get(j).getCodigo())) {

                                mat = new Matricula_2(estudante.get(i), disciplina.get(j));

                                this.estudante.get(i).addMatricula(mat);
                                this.disciplina.get(j).addMatricula(mat);
                            }
                        }
                    }
                }
            }
            r3.close();

        } catch (IOException | NumberFormatException e) {
            System.exit(-1);
        }

    }

}
