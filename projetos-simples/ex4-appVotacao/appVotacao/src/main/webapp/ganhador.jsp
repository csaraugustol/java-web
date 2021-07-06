<%-- 
    Document   : index
    Created on : 21 de mar. de 2021, 20:08:44
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


        <div class="container w-50 mt-3 col-md-6">

            <div class="card">
                <div class="card-header bg-secondary text-center">
                    <h3>GANHADOR</h3>
                </div>
                <div class="card-body bg-danger text-center text-light font-weight-bold">
                    <%
                                    // Turma t = (Turma) request.getAttribute("turma");

                                    Turma t = (Turma) session.getAttribute("turma");
                                   // Turma t1 = (Turma) request.getAttribute("turma");

                                    for (int i = 0; i < t.getVotos().size(); i++) {%>


                                    Nome Vontante: <%= t.getVotos().get(i).getNomeVotante()%><br>
                                    Nome Candidato: <%= t.getVotos().get(i).getNomeCandidato() %><br>    
                                 
                              
                                    


                                <%}%> 

                </div>
            </div>


            <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

            <script>
            
            </script>
    </body>
</html>
