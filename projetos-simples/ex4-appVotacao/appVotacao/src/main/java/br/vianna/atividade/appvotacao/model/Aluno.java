/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appvotacao.model;

/**
 *
 * @author cesar
 */
public class Aluno {
    String nome;
    int qtdVotos = 0;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVotos() {
        return qtdVotos;
    }

    public void setQtdVotos(int qtdVotos) {
        this.qtdVotos = qtdVotos;
    }
    
    
    
}
