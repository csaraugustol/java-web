/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model;

import br.vianna.aula.jsf.model.pet.Pet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cesar
 */
@Entity
public class Adotante {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_adotante", nullable = false)
    private int idAdotante;

    @NotNull
    private String nome;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    private double salario;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "adotante", fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Adotante() {
    }

    public Adotante(int idAdotante, String nome, Date dataNascimento, double salario) {
        this.idAdotante = idAdotante;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        pets = new ArrayList<>();
    }

    public int getIdAdotante() {
        return idAdotante;
    }

    public void setIdAdotante(int idAdotante) {
        this.idAdotante = idAdotante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet p) {
        this.pets.add(p);
    }

}
