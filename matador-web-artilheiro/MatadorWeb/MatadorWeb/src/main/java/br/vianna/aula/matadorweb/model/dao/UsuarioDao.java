/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model.dao;

import br.vianna.aula.matadorweb.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author cesar
 */
public class UsuarioDao extends DaoBase {

    public static boolean existeLogin(Usuario u) {
        Query q = getConexao().createQuery("select count(u) from Usuario u where u.login = :log");
    
        q.setParameter("log", u.getLogin());
        
        return (long)q.getSingleResult() >= 1;
    }

 
    public static List<Usuario> buscaNomesUsuarios() {
        Query q = getConexao().createNamedQuery("Usuario.findAll");
        
        
       // 
       // q.setParameter("user", q);
        
         return (List<Usuario>) q.getResultList();         
    }


    public Usuario verifyUser(String login, String senha) throws SQLException {

        Query q = getConexao().createNamedQuery("Usuario.findByLoginAndSenha");

        q.setParameter("login", login);
        q.setParameter("senha", senha);

        try {
            return (Usuario) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            //Repassa Excessão
            throw new SQLException("Foi encontrado dois ou mais usuários identicos. Contate o suporte.");
           // return (Usuario) q.getSingleResult().get(0);
        } catch (NoResultException e) {
            return null;
        }

    }
    
    public Usuario CadastraUser(String nome, String email, String senha) throws SQLException {

        Query q = getConexao().createNamedQuery("Usuario.findAll");
        
        q.setParameter("nome", nome);
        q.setParameter("email", email);
        q.setParameter("senha", senha);

        try {
            return (Usuario) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            //Repassa Excessão
            throw new SQLException("Cadastro não realizado.");
           // return (Usuario) q.getSingleResult().get(0);
        } catch (NoResultException e) {
            return null;
        }

    }
}
