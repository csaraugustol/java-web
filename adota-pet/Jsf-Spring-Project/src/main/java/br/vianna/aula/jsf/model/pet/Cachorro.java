/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.pet;

import br.vianna.aula.jsf.model.Adotante;
import br.vianna.aula.jsf.model.ENUM.EPorteCachorro;
import br.vianna.aula.jsf.model.ENUM.ERacaCachorro;
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
public class Cachorro extends Pet {

    @NotNull
    @Enumerated(EnumType.STRING)
    private EPorteCachorro porte;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ERacaCachorro racaCachorro;

    public Cachorro() {
    }

    public Cachorro(EPorteCachorro porte, ERacaCachorro racaCachorro, int idPet, String nome, Date dataNascimento, ESexo sexo, boolean ehDomesticado, boolean ehVacinado, boolean ehCastrado, Adotante adotante) {
        super(idPet, nome, dataNascimento, sexo, ehDomesticado, ehVacinado, ehCastrado, adotante);
        this.porte = porte;
        this.racaCachorro = racaCachorro;
    }

    public Cachorro(EPorteCachorro porte, ERacaCachorro racaCachorro, int idPet, String nome, Date dataNascimento, ESexo sexo, boolean ehDomesticado, boolean ehVacinado, boolean ehCastrado) {
        super(idPet, nome, dataNascimento, sexo, ehDomesticado, ehVacinado, ehCastrado);
        this.porte = porte;
        this.racaCachorro = racaCachorro;
    }
    
    

    public EPorteCachorro getPorte() {
        return porte;
    }

    public void setPorte(EPorteCachorro porte) {
        this.porte = porte;
    }

    public ERacaCachorro getRacaCachorro() {
        return racaCachorro;
    }

    public void setRacaCachorro(ERacaCachorro racaCachorro) {
        this.racaCachorro = racaCachorro;
    }

}
