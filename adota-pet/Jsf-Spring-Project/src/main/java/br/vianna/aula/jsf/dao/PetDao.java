/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.Adotante;
import br.vianna.aula.jsf.model.DTO.ListaPetDTO;
import br.vianna.aula.jsf.model.pet.Gato;
import br.vianna.aula.jsf.model.pet.Pet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cesar
 */
@Component
public class PetDao {
     private String str = "br.vianna.aula.jsf.model.DTO.";
    
    @Autowired
    private EntityManager conexao;

    @Transactional
    public Pet save(Pet p) {

        conexao.persist(p);

        return p;
    }

    public ArrayList<ListaPetDTO> getAllPets() {
       
        
        Query q = conexao.createQuery("select new "+str
                + "ListaPetDTO(p.idPet, p.nome, '-', a.nome, p.sexo, p.ehDomesticado) from Pet p "
                        + "left join p.adotante a");
        
        return (ArrayList<ListaPetDTO>) q.getResultList();
    }
    
}
