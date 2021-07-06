<%-- 
    Document   : resultado.jsp
    Created on : 13 de mar. de 2021, 20:20:17
    Author     : cesar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.vianna.atividade.model.Pesquisa"%>
<%@page import="br.vianna.atividade.model.Pessoa"%>
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
                    <h3>RESULTADO ENTREVISTADOS</h3>
                </div>
                <div class="card-body bg-warning text-center text-light font-weight-bold">

                    <%
//                        

                        //  Pessoa p = (Pessoa)session.getAttribute("pessoa"); 
                        Pesquisa p = (Pesquisa) session.getAttribute("pesq");


                    %>


                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">DESCRIÇÃO</th>
                                <th scope="col">DADOS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Quantidade entrevistados</th>
                                <td><%= p.getPessoa().size()%></td>             
                            </tr>
                            <tr>
                                <th scope="row">Maior altura</th>
                                <td><%= p.maiorAltura()%></td>             
                            </tr>
                            <tr>
                                <th scope="row">Menor altura</th>
                                <td><%= p.menorAltura()%></td>             
                            </tr>
                            <tr>
                                <th scope="row">Média altura mulheres</th>
                                <td>
                                    <%
                                        if (p.mediaAlturaMulheres() != 0.00) {
                                            out.print(p.mediaAlturaMulheres());
                                        } else {
                                            out.print("0.00");
                                        }
                                    %>
                                </td>             
                            </tr>
                            <tr>
                                <th scope="row">Quantidade homens</th>
                                <td>
                                    <%
                                        if (p.quantidadeHomens() != 0) {
                                            out.print(p.quantidadeHomens());
                                        } else {
                                            out.print("0");
                                        }
                                    %>
                                </td>             
                            </tr>
                            <tr>
                                <th scope="row">Porcentagem homens</th>
                                <td>
                                    <%
                                        if (p.porcentagemHomens() != 0) {
                                            out.print(p.porcentagemHomens());
                                        } else {
                                            out.print("0.00");

                                        }
                                    %>
                                </td>             
                            </tr>
                            <tr>
                                <th scope="row">Porcentagem mulheres</th>
                                <td>
                                    <%
                                        if (p.porcentagemMulheres() != 0) {
                                            out.print(p.porcentagemMulheres());
                                        } else {
                                            out.print("0.00");;
                                        }
                                    %>
                                </td>             
                            </tr>
                            <tr>
                                <th scope="row">Mulheres entre 18 e 35 anos, louras e olhos verdes</th>
                                <td>
                                   <%= p.resultadoFiltragem()%>
                                </td>             
                            </tr>
                        </tbody>
                    </table>





                </div>
                <div class="card-header bg-warning text-center">
                    <div class="form-group">
                        <input class="btn btn-danger btn-outline-success text-center text-light col-md-12" value="Novo Cadastro" type="submit" name="btnNovoCadastro" id="btnNovoCadastro" style="cursor: pointer" ">
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

        <script>

            $('#btnNovoCadastro').on("click", function ()
            {
                window.location.href = "/appPesquisa/index.jsp";
            });

        </script>
    </body>
</html>

