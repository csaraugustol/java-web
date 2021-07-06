<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="br.vianna.aula.matadorweb.model.Usuario"%>
<%@page import="br.vianna.aula.matadorweb.model.Time"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h2 class="text-center">Times</h2>
</div>
<div class="container">
    <div class="col-12 text-center">
        <a class=" btn btn-primary" href="control?ac=telaCadTime" role="button">Cadastrar Time</a>
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
        <form action="control" method="POST" > 
            <input type="hidden" name="ac" value="times" />

            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="time">Nome do Time:</label> 
                        <input type="text" name="cpBuscaNome" class="form-control"
                               placeholder="Nome do time a ser pesquisado" value="<%= request.getAttribute("cpBuscaNome")%>"/>  

                    </div>

                    <c:if test="${sessionScope.u.eh_adm == 'SIM'}">                         
                        <div class="form-group">                 
                            <label for="Usuario">Usuários:</label> 

                            <select name="cpBuscaUsuario" class="form-control">  

                                <option value="-1">Todos Usuários</option>

                                <c:forEach var="u" items="${requestScope.users}">
                                    <option value="${u.idusuario}">${u.nome}</option>                                   
                                </c:forEach>                               

                            </select>


                        </div>
                    </c:if>
                </div>


                <div class="col"> 

                    <div class="form-group">                 
                        <label for="time">Data Fundação:</label> <br>
                        De: <input value="<%= request.getAttribute("cpdata1")%>" type="date" name="cpdata1" class="form-control"/>  
                        Até <input value="<%= request.getAttribute("cpdata2")%>" type="date" name="cpdata2" class="form-control"/>  

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
            <tr>
                <th scope="col">Nome</th>
                <th scope="col">Data Fundação</th>
                   <c:if test="${sessionScope.u.eh_adm == 'SIM'}">                         
                    <th scope="col">Nome Usuário</th>
                    </c:if>
                <th scope="col">Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${requestScope.times.size() == 0}">
                <tr>
                    <td class="text-center" colspan="3"> Não há Times Cadastrados</td>
                </tr> 
            </c:if>

            <c:forEach var="t" items="${requestScope.times}">

                <tr>
                    <td>${t.nome}</td>
                    <td> <fmt:formatDate value="${t.dataFundacao}" pattern="dd/MM/yyyy" /> </td>

               <c:if test="${sessionScope.u.eh_adm == 'SIM'}">   
                        <td scope="col">${t.usuario.nome}</td>
                    </c:if>

                    <td>
                        <a href="control?ac=editTime&id=${t.idtime}"><span><i class="fa fa-edit"></i></span></a>

                        <a class="btnExcluir" href="#" data-toggle="modal" data-target="#alertaModal"
                           data-time="${t.nome}" data-id="${t.idtime}"><span><i class="fa fa-trash"></i></span>

                        </a>

                    </td>
                </tr>

            </c:forEach>   


        </tbody>

    </table>
    <div class="form-group">               
        <button class="btn btn-primary"><a class="text-light text-decoration-none" href="control?ac=times">Nova Pesquisa</a></button>
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
                    Confirma a exclusão do time <span id="nomeTime" class="font-weight-bold">xpto</span>?
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
        $("#nomeTime").html($(e.currentTarget).data("time"));

        $("#btnExcTime").data("id", $(e.currentTarget).data("id"));

    });

    $("#btnExcTime").on("click", function (e) {
        //console.log( $(e.currentTarget).data("id"));
        window.location = "control?ac=exluirTime&id=" + $(e.currentTarget).data("id");
    });

</script>

