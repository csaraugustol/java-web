<%-- 
    Document   : votacao
    Created on : 21 de mar. de 2021, 22:01:11
    Author     : cesar
--%>

<%@page import="br.vianna.atividade.appvotacao.model.Turma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="icon" href="img/icon.png"/>

        <title>VOTAÇÃO</title>
    </head>
    <body class="bg-info" style="font-size: 1.2em; background-image: url('img/fundo.jpg');  background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">


        <div class="container w-25 mt-3">

            <div class="card">

                <div class="card-header bg-danger text-center">
                    <h3 class="">VOTAÇÃO</h3>
                </div>

                <div class="card-body bg-primary text-center text-light font-weight-bold">
                    <form method="POST" action="ganhador">

                        <div class="form-group">
                            <label for="cpNomeVotante">Nome Votante</label><br>
                            <select id="cpNomeVotante" name="cpNomeVotante" required>
                                <option></option>     
                                <%
                                    // Turma t = (Turma) request.getAttribute("turma");

                                    Turma t = (Turma) session.getAttribute("turma");

                                    for (int i = 0; i < t.getAlunos().size(); i++) {%>


                                <option value="<%= t.getAlunos().get(i).getNome()%>" id="<%= t.getAlunos().get(i).getNome()%>" ><%= t.getAlunos().get(i).getNome()%></option>             


                                <%}%>

                            </select>
                        </div>


                        <div class="form-group">
                            <label for="cpNomeCandidato">Nome candidato a ser votado</label><br>
                            <select id="cpNomeCandidato" name="cpNomeCandidato" required>
                                <option></option>     
                                <%

                                    for (int i = 0; i < t.getAlunos().size(); i++) {%>


                                <option value="<%= t.getAlunos().get(i).getNome()%>"><%= t.getAlunos().get(i).getNome()%></option>             


                                <%}%>

                            </select>
                        </div>

                        <div class="form-group mt-5">
                            <input class="btn btn-success btn-outline-danger text-center text-light col-md-8" value="Gravar Voto" name="btnGravarVoto" id="btnGravarVoto" style="cursor: pointer" onclick="verificaIgualdade();">
                        </div>



                    </form>
                </div>
                <div class="form-group mt-2">
                    <input class="btn btn-success btn-outline-danger text-center text-light col-12" value="Resultado" name="btnResultado" id="btnResultado" style="cursor: pointer">
                </div>


            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        <script>
                                function verificaIgualdade() {
                                    if ($("#cpNomeVotante").val() == $("#cpNomeCandidato").val()) {

                                        alert("Você não pode votar em si mesmo. Selecione outro candidato.");
                                        console.log("Você não pode votar em si mesmo. Selecione outro candidato.");
                                    } else {

                                        alert("Voto gravado com sucesso!");


                                    }


                                }

                                function limparCampos() {
                                    document.getElementById("cpNomeVotante").value = "";
                                    document.getElementById("cpNomeCandidato").value = "";


                                }

                                $("#btnGravarVoto").on("click", function () {

                                    console.log("Clique feito!");
                                    console.log(document.getElementById("cpNomeVotante").value);
                                    console.log(document.getElementById("cpNomeCandidato").value);


                                    $.ajax({
                                        url: "/appVotacao/ganhador",
                                        type: 'POST',
                                        data: {
                                            cpNomeVotante: $("#cpNomeVotante").val(),
                                            cpNomeCandidato: $("#cpNomeCandidato").val()

                                        },
                                        error: function () {
                                            console.log("Erro");
                                        },
                                        success: function (data, textStatus, jqXHR) {
                                            console.log("werwer: " + data);

                                        },

                                    });
                                    desabilitaOption();
                                    limparCampos();
                                });

                                $('#btnResultado').on("click", function ()
                                {
                                    window.location.href = "/appVotacao/ganhador.jsp";
                                });
//
//                                $("#btnGravarVoto").click(function (event) {
//                                  let nome = $("#cpNomeVotante").val();
//                                  
//                                });

                                function desabilitaOption() {

                                    var id = $('#cpNomeVotante').children(":selected").attr("id");
                                    $("#" + id).prop('disabled', true);

                                }
        </script>
    </body>
</html>
