<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Cadastro Banda</title>
    </head>
    <body>

        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class="col-md-12 text-center">
                    <h1>Cadastro Banda</h1>
                </div>
            </div>
            
            <form action="FrontControl" method="post">
                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="nome" class="form-control" placeholder="Nome da Banda" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-home"></i></span>
                        <input type="text" name="local" class="form-control" placeholder="Local de Origem" aria-describedby="basic-addon1" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-home"></i></span>
                        <input type="text" name="integrantes" class="form-control" placeholder="Integrantes" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group" id="divBtLogin">
                    <input type="hidden" name="identificador" value="cadastroBanda"> 
                    <input type="submit" name="cadastrar" class="btn btn-danger btn-md btn-block" role="button" value="Cadastrar">
                </div>
            </form>
            
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>