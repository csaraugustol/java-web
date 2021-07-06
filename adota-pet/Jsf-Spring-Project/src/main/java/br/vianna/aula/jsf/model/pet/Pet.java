/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.pet;

import br.vianna.aula.jsf.model.Adotante;
import br.vianna.aula.jsf.model.ENUM.ESexo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cesar
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pet", nullable = false)
    private int idPet;

    @NotNull
    private String nome;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ESexo sexo;

    private boolean ehDomesticado, ehVacinado, ehCastrado;

//    @JoinColumn(name = "id_adotante", nullable = false)
    @JoinColumn(name = "adotante", referencedColumnName = "id_adotante")
    @ManyToOne(optional = true)
    private Adotante adotante;

    public Pet() {
    }

    public Pet(int idPet, String nome, Date dataNascimento, ESexo sexo, boolean ehDomesticado, boolean ehVacinado, boolean ehCastrado, Adotante adotante) {
        this.idPet = idPet;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.ehDomesticado = ehDomesticado;
        this.ehVacinado = ehVacinado;
        this.ehCastrado = ehCastrado;
        this.adotante = adotante;
    }

    public Pet(int idPet, String nome, Date dataNascimento, ESexo sexo, boolean ehDomesticado, boolean ehVacinado, boolean ehCastrado) {
        this.idPet = idPet;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.ehDomesticado = ehDomesticado;
        this.ehVacinado = ehVacinado;
        this.ehCastrado = ehCastrado;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
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

    public ESexo getSexo() {
        return sexo;
    }

    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }

    public boolean isEhDomesticado() {
        return ehDomesticado;
    }

    public void setEhDomesticado(boolean ehDomesticado) {
        this.ehDomesticado = ehDomesticado;
    }

    public boolean isEhVacinado() {
        return ehVacinado;
    }

    public void setEhVacinado(boolean ehVacinado) {
        this.ehVacinado = ehVacinado;
    }

    public boolean isEhCastrado() {
        return ehCastrado;
    }

    public void setEhCastrado(boolean ehCastrado) {
        this.ehCastrado = ehCastrado;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

}
