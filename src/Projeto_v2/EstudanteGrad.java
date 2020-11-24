/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_v2;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public class EstudanteGrad extends Estudante {

    private int horasAtividade;

    public EstudanteGrad(long id, String nome, String email, int horasAtividade) {
        super(id, nome, email);
        this.horasAtividade = horasAtividade;
    }

    public int getHorasAtividade() {
        return horasAtividade;
    }

    public void setHorasAtividade(int horasAtividade) {
        this.horasAtividade = horasAtividade;
    }

    @Override
    public int getTotalCreditos() {
        List<Disciplina> dis = super.getDisciplinasMatriculadas();
        int somaCreditosDisciplina = 0;
        int resultado = horasAtividade;
        for (Disciplina d : dis) {
            somaCreditosDisciplina += d.getCreditos();
        }
        resultado += somaCreditosDisciplina;
        return resultado;
    }

    @Override
    public String toString() {
        return "\n" + " Estudante de Graduação{" + "id= " + id + ", nome= " + nome + ", email= " + email + " , Horas Complementares = " + horasAtividade
                + " Total de Créditos = " + getTotalCreditos() + '}';
    }

}
