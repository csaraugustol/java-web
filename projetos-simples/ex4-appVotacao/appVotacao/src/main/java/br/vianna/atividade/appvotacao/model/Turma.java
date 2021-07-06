/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appvotacao.model;

import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Turma {

    private ArrayList<Aluno> alunos;
    private ArrayList<Votacao> votos;

    public Turma() {
        alunos = new ArrayList<Aluno>();
        votos = new ArrayList<Votacao>();
    }

    public void addAluno(Aluno a) {
        alunos.add(a);
    }

    public void removeAluno(Aluno a) {
        alunos.remove(a);
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void addVoto(Votacao v) {
        votos.add(v);
    }

    public void removeNomeVotante(Aluno a) {
        votos.remove(a);
    }

    public ArrayList<Votacao> getVotos() {
        return this.votos;
    }

    public int retornaVotos() {
        int votos = 0;
        for (int i = 0; i < getVotos().size(); i++) {
            votos = getVotos().get(i).quantidadeVotos;
        }

        return votos;
    }

    public void insereQuantidadeVotos() {

        for (int i = 0; i < getAlunos().size(); i++) {
            String nome1 = getAlunos().get(i).getNome(),
                    nome2 = getVotos().get(i).getNomeCandidato();
            if (nome1.endsWith(nome2)) {
                System.out.println("Deu Certo");
            }
        }

    }

    public void Votos() {

        int recebeVotos = 0;

        for (int i = 0; i < getAlunos().size(); i++) {
            String nome = getAlunos().get(i).getNome();
            if (getAlunos().get(i).getNome().equalsIgnoreCase(nome)) {

                getAlunos().get(i).setQtdVotos(getVotos().get(i).getQuantidadeVotos() + 1);
            }
        }

    }

}
