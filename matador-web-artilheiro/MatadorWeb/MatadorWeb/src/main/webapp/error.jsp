<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml" >
    <head>
        <title>Matador Web 1.0</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/favicon.ico"  />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic.min.css" integrity="sha512-LeCmts7kEi09nKc+DwGJqDV+dNQi/W8/qb0oUSsBLzTYiBwxj0KBlAow2//jV7jwEHwSCPShRN2+IWwWcn1x7Q==" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/layout.css" />
        <!--===============================================================================================-->

    </head>
    <body>

        <header>
            <nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="btn btn-dark navbar-toggle pull-left menu-toggle"  data-target="#side-bar">
                            <i class="oi oi-menu"></i>
                        </button>
                        <a class="navbar-brand " href="#">Matador web</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="layout-main"> 

            

            <section class="row container-fluid"  >
                <div class="col-12">
                    
                    <%
                    
                    String error =(String) request.getAttribute("error");
                                
                    %>
                    <h1>Erro no sistema</h1>
                    <h2><%= error %></h2>
                    
                    
                </div>
                    
            </section>

        </div>
        <footer class="layout-footer">
            <div class="container">
                <span class="footer-copy">&copy; 2021 Matador Web. Todos os direitos reservados.</span>
            </div>
        </footer> 

        <!-- Bootstrap core JavaScript
                ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!--===============================================================================================-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


        <script type="text/javascript">

    

        </script>
    </body>
</html>
