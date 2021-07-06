/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.pet;

import br.vianna.aula.jsf.model.Adotante;
import br.vianna.aula.jsf.model.ENUM.EPelagem;
import br.vianna.aula.jsf.model.ENUM.ERacaGato;
import br.vianna.aula.jsf.model.ENUM.ESexo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cesar
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_pet")
public class Gato extends Pet {

    @NotNull
    @Enumerated(EnumType.STRING)
    private EPelagem tipoPelagem;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ERacaGato racaGato;

    public Gato() {
    }

    public Gato(EPelagem tipoPelagem, ERacaGato racaGato, int idPet, String nome, Date dataNascimento, ESexo sexo, boolean ehDomesticado, boolean ehVacinado, boolean ehCastrado, Adotante adotante) {
        super(idPet, nome, dataNascimento, sexo, ehDomesticado, ehVacinado, ehCastrado, adotante);
        this.tipoPelagem = tipoPelagem;
        this.racaGato = racaGato;
    }

    public EPelagem getTipoPelagem() {
        return tipoPelagem;
    }

    public void setTipoPelagem(EPelagem tipoPelagem) {
        this.tipoPelagem = tipoPelagem;
    }

    public ERacaGato getRacaGato() {
        return racaGato;
    }

    public void setRacaGato(ERacaGato racaGato) {
        this.racaGato = racaGato;
    }

}
