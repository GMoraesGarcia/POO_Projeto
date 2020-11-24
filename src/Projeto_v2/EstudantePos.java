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
public class EstudantePos extends Estudante{
    private String tema;
    private String orientador;
    
    public EstudantePos(long id, String nome, String email, String tema, String orientador) {
        super(id, nome, email);
        this.tema = tema;
        this.orientador = orientador;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    @Override
    public int getTotalCreditos() {
      int ac =0;
      List<Disciplina> dis = getDisciplinasMatriculadas();
      for(Disciplina d:dis){
          ac += d.getCreditos();
      }
      return ac;
    }
    
     @Override
    public String toString() {
        return "\n" + " Estudante pos-graduação{" + "id= " + id + ", nome= " + nome + ", email= " + email + " Tema= " + tema + " Orientador = " +orientador +
                " Total de Créditos= " + getTotalCreditos() +'}';
                            
    }
    
}
