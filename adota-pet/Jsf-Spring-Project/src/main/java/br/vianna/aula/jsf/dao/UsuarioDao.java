/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.DTO.UsuarioLogDTO;
import br.vianna.aula.jsf.model.Usuario;
import br.vianna.aula.jsf.util.Utils;
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
public class UsuarioDao {

    @Autowired
    private EntityManager conexao;

    @Transactional
    public Usuario save(Usuario u) {

        conexao.persist(u);

        return u;
    }

    public UsuarioLogDTO existeUser(String login, String senha) {
        String str = "";
        
        try {

            Query q = conexao.createQuery("SELECT new br.vianna.aula.jsf.model.DTO.UsuarioLogDTO(u.id,u.tipoUsuario,u.nome,u.email) "
                    + "FROM Usuario u "
                    + "WHERE u.login = :login AND u.senha = :senha");

            q.setParameter("login", login);
            q.setParameter("senha", Utils.md5(senha));

            return (UsuarioLogDTO) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

}
