/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appaposentadoria.pessoa;

/**
 *
 * @author cesar
 */
public class Pessoa {

    String nome;
    int idade, temporabalho;

    public Pessoa() {
        
    }

    public Pessoa(String nome, int idade, int temporabalho) {
        this.nome = nome;
        this.idade = idade;
        this.temporabalho = temporabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTemporabalho() {
        return temporabalho;
    }

    public void setTemporabalho(int temporabalho) {
        this.temporabalho = temporabalho;
    }

    public String toString() {
        String resposta = "";

//        if (getIdade() >= 65 || getTemporabalho() >= 30) {
//            resposta = "Requerer aposentadoria";
//        } else if (getIdade() >= 60 && getTemporabalho() >= 25) {
//            resposta = "Requerer aposentadoria";
//        } else {
//            resposta = "Não requerer";
//        }
        if (getIdade() >= 65) {
            resposta = "Requerer aposentadoria";
        } else {
            if (getTemporabalho() >= 30) {
                resposta = "Requerer aposentadoria";
            } else if (getIdade() >= 60 && getTemporabalho() >= 25) {
                resposta = "Requerer aposentadoria";
            } else {
                resposta = "Não requerer";
            }
        }

        return resposta;
    }

}
