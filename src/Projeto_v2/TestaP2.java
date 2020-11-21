/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_v2;

/**
 *
 * @author Gabriel
 */
public class TestaP2 {
    public static void main(String[] args) {
        String arqDisciplina = "disciplinas.txt";
        String arqEstudante = "estudantes.txt";
        String arqMatricula = "matriculas.txt";
        
        Centro_Universitario_2 c = new Centro_Universitario_2("batman");
        c.carregarDadosArquivo(arqDisciplina, arqEstudante, arqMatricula);
        
        System.out.println(c.getEstudantes());
    }
    
}
