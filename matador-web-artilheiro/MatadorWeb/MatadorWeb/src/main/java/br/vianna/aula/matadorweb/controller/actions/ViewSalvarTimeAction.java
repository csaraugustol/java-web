/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.matadorweb.controller.actions;

import br.vianna.aula.matadorweb.controller.commander.GenericCommander;
import br.vianna.aula.matadorweb.model.Time;
import br.vianna.aula.matadorweb.model.Usuario;
import br.vianna.aula.matadorweb.model.dao.TimeDao;
import br.vianna.aula.matadorweb.model.dao.UsuarioDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ViewSalvarTimeAction extends GenericCommander {

    public ViewSalvarTimeAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Time t = new Time();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String msg;

            date = formatter.parse(request.getParameter("cpDataFund"));

            if (request.getParameter("cpId").equals("")) {

                String nome = request.getParameter("cpNome");
                Usuario u = (Usuario) request.getSession().getAttribute("u");

                t.setNome(nome);

                t.setDataFundacao(date);

                t.setUsuario(u);
                msg = "Time cadastrado.";

                if (TimeDao.existeNome(t)) {

                    request.setAttribute("msgErro", "Time já cadastrado");

                    t.setNome("");
                    request.setAttribute("t", t);

                    new ViewTelaCadTimeAction(isLogado).executa(request, response);
                     return;
                }

            } else {
                t = TimeDao.BuscaPorId(Integer.parseInt(request.getParameter("cpId")));

                t.setNome(request.getParameter("cpNome"));
                t.setDataFundacao(date);
                
                msg = "Alteção realizada com sucesso.";

            }

            TimeDao.getConexao().getTransaction().begin();
            TimeDao.getConexao().persist(t);
            TimeDao.getConexao().getTransaction().commit();

            request.setAttribute("msg", msg);

            new ViewTimesAction(isLogado).executa(request, response);

        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }

    }

}
