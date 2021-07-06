/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roda.testes.banco;

import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import static br.vianna.aula.matadorweb.model.dao.DaoBase.getConexao;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author cesar
 */
public class TestaBanco {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("matadorPU");

        EntityManager em = emf.createEntityManager();

        System.out.println("Conectou ");

//        Usuario u = new Usuario(1, "Cesar", "Cesar", "Cesar");
//        
//        em.getTransaction().begin();
//        
//        em.persist(u);
//        
//        em.getTransaction().commit();
//        Query q = em.createNamedQuery("Usuario.findAll");
//
//        List<Usuario> lista = (List<Usuario>) q.getResultList();
//        for (Usuario usuario : lista) {
//            System.out.println("1 --> " + usuario.getNome());
//        }

//        Query q1 = em.createQuery("SELECT u FROM Usuario u");
//
//        List<Usuario> lista1 = (List<Usuario>) q.getResultList();
//        for (Usuario usuario : lista1) {
//            System.out.println("2 --> " + usuario.getNome());
//        }
//    Time t = new Time();
//    
//    t.setNome("Chelsea");
//            em.getTransaction().begin();
//        
//        em.persist(t);
//        
//        em.getTransaction().commit();
  Query q = getConexao().createQuery("select t from Time t Where t.usuario.idusuario = 1996  ");

        
                List<Time> lista = (List<Time>) q.getResultList();
        for (Time t : lista) {
            System.out.println("1 --> " + t.getNome());
        }

    }

}
