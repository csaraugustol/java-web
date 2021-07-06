/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.model;

/**
 *
 * @author cesar
 */
public class Pessoa {

    String cpf, sexo, olhos, cabelos;
    int idade;
    double altura;

    public Pessoa() {
    }

    public Pessoa(String cpf, String sexo, String olhos, String cabelos, int idade, double altura) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.olhos = olhos;
        this.cabelos = cabelos;
        this.idade = idade;
        this.altura = altura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getCabelos() {
        return cabelos;
    }

    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double teste() {

        return getAltura() * getIdade();
    }

   

}
