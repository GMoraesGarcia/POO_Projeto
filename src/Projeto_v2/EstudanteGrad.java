/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_v2;

import Projeto_v1.Centro_Universitario;

/**
 *
 * @author Gabriel
 */
public class EstudanteGrad extends Estudante_2{
    private int horasAtividade;
    
    public EstudanteGrad(long id, String nome, String email, int horasAtividade) {
        super(id, nome, email);
    }

    public int getHorasAtividade() {
        return horasAtividade;
    }

    public void setHorasAtividade(int horasAtividade) {
        this.horasAtividade = horasAtividade;
    }

    @Override
    public int getTotalCreditos(long id, Centro_Universitario centro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
