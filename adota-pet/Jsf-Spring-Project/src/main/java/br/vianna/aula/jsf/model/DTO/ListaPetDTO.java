/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.DTO;

import br.vianna.aula.jsf.model.ENUM.ESexo;

/**
 *
 * @author cesar
 */
public class ListaPetDTO {
    private int id;
    private String nome, tipo, nomeAdotante;
    private ESexo sexo;
    private boolean ehDomesticado;
    
  
    
    public ListaPetDTO() {
    }

    public ListaPetDTO(int id, String nome, String tipo, String nomeAdotante, ESexo sexo, boolean ehDomesticado) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nomeAdotante = nomeAdotante;
        this.sexo = sexo;
        this.ehDomesticado = ehDomesticado;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ESexo getSexo() {
        return sexo;
    }

    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }

 
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEhDomesticado() {
        return ehDomesticado;
    }

    public void setEhDomesticado(boolean ehDomesticado) {
        this.ehDomesticado = ehDomesticado;
    }

    public String getNomeAdotante() {
        return nomeAdotante;
    }

    public void setNomeAdotante(String nomeAdotante) {
        this.nomeAdotante = nomeAdotante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}