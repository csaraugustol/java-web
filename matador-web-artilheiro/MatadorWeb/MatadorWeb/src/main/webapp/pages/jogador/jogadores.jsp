<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="br.vianna.aula.matadorweb.model.Usuario"%>
<%@page import="br.vianna.aula.matadorweb.model.Time"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h2 class="text-center">Jogadores</h2>
</div>
<div class="container">
    <div class="col-12 text-center">
        <a class=" btn btn-primary" href="control?ac=telaCadJogad" role="button">Cadastrar Jogador</a>
    </div>
    <div class="col-6">
        <% if (request.getAttribute("msg") != null) {%>
        <div class="alert-success text-center">

            <%= request.getAttribute("msg")%>

        </div>
        <%}%>
    </div>
</div>

<div class="container">
    <%
        Usuario u = (Usuario) session.getAttribute("user");
    %>

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control?ac=jogadores" method="POST" > 


            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="time">Nome do Jogador</label> 
                        <input type="text" name="cpBuscaNome" class="form-control"
                               placeholder="Nome do jogador a ser pesquisado" value="${requestScope.cpBuscaNome}"/>  

                    </div>

                    <c:if test="${sessionScope.u.eh_adm == 'SIM'}">                         
                        <div class="form-group">                 
                            <label for="time">Times:</label> 

                            <select name="cpBuscaTimes" class="form-control">  
                             <option value="-1">Todos Times</option>
                                        <c:forEach var="t" items="${requestScope.times}">
                                            <option value="${t.idtime}"
                                            <c:if test="${t.idtime == requestScope.cpBuscaTimes}">
                                                select
                                            </c:if>

                                            >${t.nome}</option>                                   
                                </c:forEach>                               

                            </select>


                        </div>
                    </c:if>
                </div>


                <div class="col"> 

                    <div class="form-group">                 
                        <label for="gols">Faixa de gols:</label> <br>
                        De: <input value="${requestScope.g1}" type="text" name="qtdGols1" class="form-control" placeholder="Mínímo gols"/>  
                        Até <input value="${requestScope.g2}" type="text" name="qtdGols2" class="form-control" placeholder="Maxímo gols"/>  

                    </div>
                </div>
            </div>


            <div class="form-group">               
                <button type="submit" class="btn btn-primary" >Pesquisar</button>
            </div>


        </form>

    </fieldset>

    <table class="table table-hover">
        <thead>
            <tr class="text-center">
                <th scope="col">Nome</th>
                <th scope="col">Time</th>
                <th scope="col">Gols</th>
                <th scope="col">Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${requestScope.jogadores.size() == 0}">
                <tr>
                    <td class="text-center" colspan="3"> Não há jogadores cadastrados</td>
                </tr> 
            </c:if>

            <c:forEach var="j" items="${requestScope.jogadores}">

                <tr class="text-center">
                    <td>${j.nome}</td>
                    <td>${j.time.nome}</td>
                    <td>${j.numeroGols}</td>

                    <td>
                        <a href="control?ac=editJogador&id=${j.idJogador}"><span><i class="fa fa-edit"></i></span></a>

                        <a class="btnExcluir" href="#" data-toggle="modal" data-target="#alertaModal"
                           data-jogador="${j.nome}" data-id="${j.idJogador}"><span><i class="fa fa-trash"></i></span>

                        </a>

                    </td>
                </tr>

            </c:forEach>   


        </tbody>

    </table>
    <div class="form-group">               
        <button class="btn btn-primary"><a class="text-light text-decoration-none" href="control?ac=jogadores">Nova Pesquisa</a></button>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="alertaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-warning">
                    <h5 class="modal-title" id="exampleModalLabel">Deseja confirmar a exclusão?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Confirma a exclusão do jogador <span id="nomeJog" class="font-weight-bold"></span>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                    <button id="btnExcTime" type="button" class="btn btn-danger">Sim</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script>

    $(".btnExcluir").on("click", function (e) {
        //console.log($(e.currentTarget).data("time"));
        $("#nomeJog").html($(e.currentTarget).data("jogador"));

        $("#btnExcTime").data("id", $(e.currentTarget).data("id"));

    });

    $("#btnExcTime").on("click", function (e) {
        //console.log( $(e.currentTarget).data("id"));
        window.location = "control?ac=excluirJogador&id=" + $(e.currentTarget).data("id");
    });

</script>