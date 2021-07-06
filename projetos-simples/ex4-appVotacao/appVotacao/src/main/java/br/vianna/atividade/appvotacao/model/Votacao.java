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
public class Votacao {
    
    String nomeVotante, nomeCandidato;
    int quantidadeVotos = 0;

    public Votacao(String nomeVotante, String nomeCandidato) {
        this.nomeVotante = nomeVotante;
        this.nomeCandidato = nomeCandidato;
    }
    
    
   

    public Votacao() {
    }

    public String getNomeVotante() {
        return nomeVotante;
    }

    public void setNomeVotante(String nomeVotante) {
        this.nomeVotante = nomeVotante;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public int getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(int quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }
    
   
    
    
    
    
    
    
}
