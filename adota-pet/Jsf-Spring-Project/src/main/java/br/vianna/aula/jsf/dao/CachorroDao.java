/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.DTO.ListaPetDTO;
import br.vianna.aula.jsf.model.pet.Cachorro;
import br.vianna.aula.jsf.model.pet.Pet;
import java.util.ArrayList;
import java.util.Collection;
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
public class CachorroDao {

    private String str = "br.vianna.aula.jsf.model.DTO.";

    @Autowired
    private EntityManager conexao;

    @Transactional
    public Cachorro save(Cachorro c) {

        if (c.getIdPet() > 0) {
            conexao.merge(c);
        } else {
            conexao.persist(c);
        }

        return c;
    }

//    public Collection<? extends ListaPetDTO> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    public ArrayList<ListaPetDTO> getAllPets() {

        Query q = conexao.createQuery("select new " + str
                + "ListaPetDTO(p.idPet, p.nome, 'Cachorro', a.nome, p.sexo, p.ehDomesticado) from Cachorro p "
                + "left join p.adotante a");

        return (ArrayList<ListaPetDTO>) q.getResultList();
    }

    public Cachorro getAnimal(int id) {
        return conexao.find(Cachorro.class, id);
    }

    @Transactional
    public Cachorro excluir(int id) {
        Cachorro c = getAnimal(id);

        conexao.remove(c);

        return c;
    }

}
