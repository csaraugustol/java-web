/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.model.dao;

import br.vianna.aula.matadorweb.model.Jogador;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import static br.vianna.aula.matadorweb.model.dao.DaoBase.getConexao;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author cesar
 */
public class JogadorDao extends DaoBase {

    public static boolean existeNome(String nome) {
        Query q = getConexao().createQuery("select count(j.nome) from Jogador j where j.nome = :nome");

        q.setParameter("nome", nome);

        return (long) q.getSingleResult() >= 1;
    }
    
    public static boolean existeNome(String nome, int idTime) {
        Query q = getConexao().createQuery("select count(j.nome) from Jogador j where j.nome = :nome and j.time.idtime = :idTime");
        
        q.setParameter("nome", nome);
        q.setParameter("idTime", idTime);
        
        return (long) q.getSingleResult() >= 1;
    }

    public static List<Jogador> buscaJogadores() {
        Query q = getConexao().createNamedQuery("Jogador.findAll");

        return q.getResultList();
    }

//    public static List<Jogador> buscarJogadorFiltro(String nomeBusca, int qtdGols1, int qtdGols2, Time time) {
//
//        Query q = getConexao().createQuery("select j from Jogador j Where j.nome like :nomeBusca "
//                + " and (j.numeroGols >= :qtdGols1 and j.numeroGols <= :qtdGols2 ) and j.time = :time");
//
//        q.setParameter("nome", "%" + nomeBusca + "%");
//        q.setParameter("qtdGols1", qtdGols1);
//        q.setParameter("qtdGols2", qtdGols2);
//        q.setParameter("time", time.getIdtime());
//
//        return q.getResultList();
//    }
    
      public static List<Jogador> buscarJogadorFiltroNomeGols(String nomeBusca, int qtdGols1, int qtdGols2, Time t) {
          

        Query q = getConexao().createQuery("select j from Jogador j Where j.nome like :nomeBusca "
                + "and (j.numeroGols >= :qtdGols1 and j.numeroGols <= :qtdGols2 ) and (j.time.idtime = :idtime or -1 = :idtime )");

        q.setParameter("nomeBusca", "%" + nomeBusca + "%");
        q.setParameter("qtdGols1", qtdGols1);
        q.setParameter("qtdGols2", qtdGols2);
        q.setParameter("idtime", t.getIdtime());
        

        return q.getResultList();
    }

    
    public static List<Jogador> buscarJogadornome(String nomeBusca) {
         Query q = getConexao().createQuery("select j from Jogador j where j.nome like :nomeBusca");
         
         q.setParameter("nomeBusca", "%" + nomeBusca + "%");

        return q.getResultList();
    }

    public static Jogador BuscaPorId(int id) {
        Query q = getConexao().createNamedQuery("Jogador.findByIdJogador");
        
        q.setParameter("idJogador", id);
        
         try {
            return (Jogador) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean existeNome(Jogador j) {
       Query q = getConexao().createQuery("select count(j) from Jogador j where j.nome = :nome and j.time.idtime = :id");
        
        q.setParameter("nome", j.getNome());
        q.setParameter("id", j.getTime().getIdtime());
        
         return (long)q.getSingleResult() >= 1; 
    }

    public static List<Jogador> buscaJogadores(Usuario u) {
        Query q = getConexao().createQuery("select j from Jogador j where j.time.usuario.idusuario = :id");
         
         q.setParameter("id", u.getIdusuario());

        return q.getResultList();
    }

    
}
