<%@page import="br.vianna.atividade.appvotacao.model.Turma"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : index
    Created on : 21 de mar. de 2021, 20:08:44
    Author     : cesar
--%>

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
                    <h3 class="">CADASTRADOS</h3>
                </div>

                <div class="card-body bg-primary text-center text-light font-weight-bold">

                        
                        <table class="table table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">NOME</th>
                                </tr>
                            </thead>
                            <tbody>

                        <%
                            Turma t = (Turma) request.getAttribute("turma");

                            for (int i = 0; i < t.getAlunos().size(); i++) {%>

                                                      <tr>
                                    <td><%= t.getAlunos().get(i).getNome()%></td>             
                                </tr>

                                <%}%>

                            </tbody>
                        </table>
                                
                                
                            <div class="form-group mt-5">
                                <input class="btn btn-success btn-outline-danger text-center text-light col-md-8" type="submit" value="Cadastrar novo aluno" name="btnCadastrar" id="btnCadastrar" style="cursor: pointer" onclick="voltar()">
                            </div>
                                <div class="form-group mt-5">
                                <input class="btn btn-success btn-outline-danger text-center text-light col-md-8" type="submit" value="Iniciar votação" name="btnIniVot" id="btnIniVot" style="cursor: pointer" >
                            </div>

                </div>
            </div>
                                
                        


            <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

            <script>
               
                    
                    $('#btnCadastrar').on("click", function  voltar()
            {
                window.location.href = "/appVotacao/index.jsp";
            });
            
            
            $('#btnIniVot').on("click", function  ()
            {
                window.location.href = "/appVotacao/votacao.jsp";
            });
                
            </script>
    </body>
</html>

