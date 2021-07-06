<%-- 
    Document   : index
    Created on : 13 de mar. de 2021, 23:54:25
    Author     : cesar
--%>

<%@page import="br.vianna.atividade.model.Pesquisa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="icon" href="img/icone.png"/>

        <title>Pesquisa</title>
    </head>
    <body class="bg-info" style="font-size: 1.2em; background-image: url('img/logo1.jpg');  background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">


        <div class="container w-50 mt-3 col-md-6">

            <div class="card">
                <div class="card-header bg-warning text-center">
                    <h3>FORMULÁRIO ENTREVISTADOS</h3>
                </div>
                <div class="card-body bg-success text-center text-light font-weight-bold">

                    <form method="POST" action="resultado">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="cpCpf">CPF</label><br>
                                <input class="form-control text-center" name="cpCpf" id="cpCpf" type="text" placeholder="Somente números" required>
                            </div> 

                            <div class="form-group col-md-4">
                                <label for="cpIdade">Idade</label><br>
                                <input class="form-control text-center" name="cpIdade" id="cpIdade" type="text" placeholder="Idade" required>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="cpAltura">Altura</label><br>
                                <input class="form-control text-center" name="cpAltura" id="cpAltura" type="text" placeholder="Altura(0.00)" required>
                            </div>
                        </div>

                        <div class="row">

                            <div class="form-group col-md-4">
                                <label for="cpSexo">Sexo</label><br>
                                <select name="cpSexo" id="cpSexo" required>
                                    <option ></option>
                                    <option >Masculino</option>
                                    <option >Feminino</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="cpOlhos">Olhos</label><br>
                                <select name="cpOlhos" id="cpOlhos" required>
                                    <option ></option>
                                    <option >Azuis</option>
                                    <option >Castanhos</option>
                                    <option >Verdes</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="cpCabelos">Cabelos</label><br>
                                <select name="cpCabelos" id="cpCabelos" required>
                                    <option ></option>
                                    <option >Castanhos</option>
                                    <option >Louros</option>
                                    <option >Pretos</option>
                                </select>
                            </div>

                            <div class="row col-12 mt-3">

                                <div class="form-group col-md-4">
                                    <input class="btn btn-danger btn-outline-warning text-center text-light col-md-8" type="submit" value="Enviar" name="btnEnviar" id="btnEnviar" style="cursor: pointer" >
                                </div>
                                <div class="form-group col-md-4">
                                    <input class="btn btn-danger btn-outline-warning text-center text-light col-md-8" value="Limpar" name="btnLimpar" id="btnLimpar" style="cursor: pointer" o8" onclick="limparCampos()">
                                </div>
                                <div class="form-group col-md-4">
                                    <div ><p>Entrevistados: <%
                                        Pesquisa p = (Pesquisa) session.getAttribute("pesq");
                                        if (p != null) {
                                            out.print(p.getPessoa().size());
                                        } else {
                                            out.print("0");
                                        }
                                            %></p>
                                    </div>
                                </div>

                            </div>

                    </form>

                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        <script>
                                        function limparCampos() {
                                            $("#cpCpf").val(''),
                                                    $("#cpIdade").val(''),
                                                    $("#cpAltura").val(''),
                                                    $("#cpSexo").val(''),
                                                    $("#cpOlhos").val(''),
                                                    $("#cpCabelos").val('')

                                        }
        </script>
    </body>
</html>


