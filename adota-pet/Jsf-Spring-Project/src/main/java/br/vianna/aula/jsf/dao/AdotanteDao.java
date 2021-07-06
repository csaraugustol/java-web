/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.Adotante;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cesar
 */
@Component
public class AdotanteDao {
    
    
    @Autowired
    private EntityManager conexao;

    @Transactional
    public Adotante save(Adotante a) {

        conexao.persist(a);

        return a;
    }
    
}
