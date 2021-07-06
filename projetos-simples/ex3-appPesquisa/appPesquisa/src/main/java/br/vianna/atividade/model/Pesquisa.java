/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.model;

import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Pesquisa {
    
   

    private ArrayList<Pessoa> pessoas;

    public Pesquisa() {
        pessoas = new ArrayList<Pessoa>();
    }

    public void addPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public ArrayList<Pessoa> getPessoa() {
        return this.pessoas;
    }

    public double maiorAltura() {
        double maiorAltura = 0;

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getAltura() > maiorAltura) {
                maiorAltura = pessoas.get(i).getAltura();
            }
        }

        return maiorAltura;
    }

    public double menorAltura() {
        double menorAltura = pessoas.get(0).getAltura();

        for (int i = 0; i < pessoas.size(); i++) {

            if (pessoas.get(i).getAltura() < menorAltura) {
                menorAltura = pessoas.get(i).getAltura();
            }
        }

        return menorAltura;
    }
    
    public double mediaAlturaMulheres() {
        double media = 0;

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);

            if (p.getSexo().equalsIgnoreCase("feminino")) {
                media += pessoas.get(i).getAltura();
            }
        }
        return media / quantidadeMulheres();
    }
    
     public int quantidadeMulheres() {
        int contMulheres = 0;

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);

            if (p.getSexo().equalsIgnoreCase("feminino")) {
                contMulheres++;
            }
        }
        return contMulheres;
    }

    public int quantidadeHomens() {
        int contHomens = 0;

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            if (p.getSexo().equalsIgnoreCase("masculino")) {
                contHomens++;
            }
        }
        return contHomens;
    }
    

    public double porcentagemHomens() {
        return (100 * quantidadeHomens()) / (quantidadeHomens() + quantidadeMulheres());
    }

    public double porcentagemMulheres() {

        return 100 - porcentagemHomens();
    }
    
    public int filtragemMulheres(){
        int contaFiltro = 0;
        
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            if (p.getSexo().equalsIgnoreCase("feminino") && p.getIdade() >=18 && 
                    p.getCabelos().equalsIgnoreCase("louros") && p.getOlhos().equalsIgnoreCase("verdes")) {
                contaFiltro++;
            }
        }
        
        return contaFiltro;
    }
    
    public double resultadoFiltragem(){
    return (filtragemMulheres() * 100) / getPessoa().size();
    }
     

}
