
<%@page import="br.vianna.aula.matadorweb.model.Time"%>
<%@page import="br.vianna.aula.matadorweb.controller.actions.ViewHomeLogadoAction"%>
<%@page import="br.vianna.aula.matadorweb.model.Usuario"%>

                <div class="container-fluid corpo">
                    <div class="row justify-content-md-center h-100 p-5">
                        <div class="card-wrapper">
                            <%                                 Time t = (Time) (request.getAttribute("t") == null ? new Time() : request.getAttribute("t"));

                                 if (request.getAttribute("msgErro") != null) {%>
                            <div class="alert-danger text-center">

                                <%= request.getAttribute("msgErro")%>

                            </div>
                            <%}%>
                            <div class="card fat">
                                <div class="card-body" style="background-color: #1E94D2; color: #fff">
                                    <h4 class="card-title text-center">${requestScope.titulo}</h4>


                                    <form method="POST" class="my-login-validation"
                                          action="control?ac=cadTimes">
                                        <input type="hidden" name="cpId" value="${requestScope.time.idtime}"/>
                                        <div class="form-group">
                                            <label for="nome">Nome</label>
                                            <input id="nome" type="text" class="form-control" name="cpNome"
                                                   value="${requestScope.time.nome}" required="" autofocus="" placeholder="Nome time">
                                              
                                        </div>

                                        <div class="form-group">
                                            <label for="dataFund">Data Fundação</label>
                                            <input id="dataFund" type="date" class="form-control" name="cpDataFund"
                                                   value="${requestScope.time.dataAmericana()}" required="" autofocus="">
                                                                                        </div>

                                        <div class="form-group m-0">
                                            <button id="btnCadastrar" type="submit" class="btn btn-warning btn-block">
                                                ${requestScope.botao}
                                            </button>
                                        </div>
                                        <div class="mt-4 text-center">
                                            <a class="text-light" href="control?ac=times">Voltar</a>
                                        </div>


                                    </form>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>

