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
public class GatoDao {

    private String str = "br.vianna.aula.jsf.model.DTO.";

    @Autowired
    private EntityManager conexao;

    @Transactional
    public Gato save(Gato g) {

         if (g.getIdPet() > 0) {
            conexao.merge(g);
        } else {
            conexao.persist(g);
        }

        return g;
    }

//    public Collection<? extends ListaPetDTO> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public ArrayList<ListaPetDTO> getAllPets() {

        Query q = conexao.createQuery("select new " + str
                + "ListaPetDTO(p.idPet, p.nome, 'Gato', a.nome, p.sexo, p.ehDomesticado) from Gato p "
                + "left join p.adotante a");

        return (ArrayList<ListaPetDTO>) q.getResultList();
    }

    public Gato getAnimal(int id) {
        return conexao.find(Gato.class, id);
    }

    @Transactional
    public Pet excluir(int id) {
        Gato g = getAnimal(id);
        
        conexao.remove(g);
        
        return g;
    }


}
