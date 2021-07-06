
<%@page import="br.vianna.aula.matadorweb.model.Jogador"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.vianna.aula.matadorweb.model.Time"%>
<%@page import="br.vianna.aula.matadorweb.controller.actions.ViewHomeLogadoAction"%>
<%@page import="br.vianna.aula.matadorweb.model.Usuario"%>

<div class="container-fluid corpo">
    <div class="row justify-content-md-center h-100 p-5">
        <div class="card-wrapper">
            <%                                 Jogador j = (Jogador) (request.getAttribute("j") == null ? new Jogador() : request.getAttribute("j"));

                                 if (request.getAttribute("msgErro") != null) {%>
            <div class="alert-danger text-center">

                <%= request.getAttribute("msgErro")%>

            </div>
            <%}%>

            <div class="card fat">
                <div class="card-body" style="background-color: #1E94D2; color: #fff">
                    <h4 class="card-title text-center">${requestScope.titulo}</h4>


                    <form method="POST" class="my-login-validation"
                          action="control?ac=cadJogad">
                        <input type="hidden" name="cpId" value="${requestScope.jog.idJogador}"/>
                        <div class="form-group">
                            <label for="nome">Nome Jogador</label>
                            <input id="nome" type="text" class="form-control" name="cpNomeJog"
                                   value="${requestScope.jog.nome}" required="" autofocus="" placeholder="Nome Jogador">
                        </div>
                        <div class="form-group">
                            <label for="qtdGols">Quantidade de Gols</label>
                            <input id="qtdGols" type="text" class="form-control" name="qtdGols"
                                   value="${requestScope.jog.numeroGols}" required="" autofocus="" placeholder="Quantidade de Gols">
                        </div>
                        <div class="form-group">
                            <select name="cpListaTimes" class="form-control">  

                                <c:forEach var="t" items="${requestScope.times}">
                                    <option value="${t.idtime}">${t.nome}</option>                                   
                                </c:forEach>                               

                            </select>
                        </div>

                        <div class="form-group m-0">
                            <button id="btnCadastrar" type="submit" class="btn btn-warning btn-block">
                                ${requestScope.botao}
                            </button>
                        </div>
                        <div class="mt-4 text-center">
                            <a class="text-light" href="control?ac=jogadores">Voltar</a>
                        </div>


                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

