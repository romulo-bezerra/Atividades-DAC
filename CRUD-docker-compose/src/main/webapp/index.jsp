<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>index</title>
    </head>
    <body>
        
        <div class="container" id="divLog">

            <h1>Albuns</h1>

            <table class="table">
                <thead class="thead-inverse">
                    <tr>
                        <th>ID</th>
                        <th>Banda</th>
                        <th>Estilo</th>
                        <th>Lançamento</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td><a name="banda" href="Album.jsp" class="btn" role="button">Romulo</a></td>
                        <td>Otto</td>
                        <td>@mdo</td>
                        <td>
                            <div class="form-group" id="divBtLogin">
                                <form method="post" action="FrontControl">
                                    <input type="hidden" name="identificador" value="UpdateAlbum">
                                    <input type="submit" name="update" value="Update" class="btn" role="button">
                                </form>
                                <form method="post" action="FrontControl">
                                    <input type="hidden" name="identificador" value="DeleteAlbum">
                                    <input type="submit" name="delete" value="Delete" class="btn" role="button">
                                </form>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <a name="banda" href="cadastroAlbum.jsp" class="btn" role="button">Add Album ...</a>
        
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>
