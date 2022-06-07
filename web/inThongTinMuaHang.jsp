<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <!-- Site meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Shopping cart</title>
        <!-- CSS -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <style>
            * {
                box-sizing: border-box;
                padding: 0;
                margin: 0;
            }

            img {
                width: 60px;
                height: 60px;
            }


            .hide {
                display: none;
            }


        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1 style="text-align: center">Mua hàng thành công !</h1>
        <h5>
            <a style="margin-left: 50%" href="home">Back</a>
        </h5>

        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- JS -->
        <script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
