
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid corpo">
    <div class="row justify-content-md-center h-100 p-5">
        <div class="card fat">
            <div class="card-body" style="background-color: #1E94D2; color: #fff">
                <h4 class="card-title text-center">Dados Cadastrais</h4>

                <c:if test="${requestScope.error != null}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        ${requestScope.error}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <c:if test="${requestScope.Salvo != null}">
                    <div class="alert alert-sucess alert-dismissible fade show" role="alert">
                        ${requestScope.Salvo}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <form method="POST" class="my-login-validation"
                      action="control?ac=salvarPerfil">
                    <div class="form-group">
                        <label for="nome">Nome Usuário</label>
                        <input id="nome" type="text" class="form-control" name="cpNome"
                               value="${sessionScope.u.nome}" autofocus="">
                    </div>

                    <div class="form-group">
                        <label for="login">Login Usuário</label>
                        <input id="login" type="text" class="form-control" name="cpLoginUsuario"
                               value="${sessionScope.u.login}" autofocus="">
                    </div>

                    <div class="form-group">
                        <label for="Senha">Senha</label>
                        <input id="Senha" type="password" class="form-control" name="cpSenha"
                               value="" autofocus="">
                    </div>

                    <div class="form-group">
                        <label for="Confirmar">Confirmar Senha</label>
                        <input id="Confirmar" type="password" class="form-control" name="cpSenhaConfir"
                               value="" autofocus="">
                    </div>
                   
                    <div class="form-group m-0">
                        <button id="btnAlterar" type="submit" class="btn btn-warning btn-block">
                            Alterar
                        </button>
                    </div>
                    <div class="mt-4 text-center">
                        <a class="text-light" href="control?ac=home">Voltar</a>
                    </div>


                </form>
            </div>
        </div>
    </div>
</div>
</form>