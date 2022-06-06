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
        <h1 class="hide" id="duyNhat">${id}</h1>
<!--        <h2 id="duyNhat2">${userIDGioHang}</h2>-->
        <div class="container mb-4">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"> </th>
                                    <th scope="col">Sản phẩm</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col" class="text-center">Số lượng</th>
                                    <th scope="col" class="text-right">Tổng</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody id="danhSachItemGioHang">
                                <!--Danh sách item giỏ hàng-->


                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col mb-2">
                    <div class="row">
                        <div class="col-sm-12  col-md-6">
                            <!--<button class="btn btn-block btn-light">Continue Shopping</button>-->
                            <a href="home" class="btn btn-block btn-light">Back</a>
                        </div>
                        <div class="col-sm-12 col-md-6 text-right">
                            <!--<button class="btn btn-lg btn-block btn-success text-uppercase">Mua hàng</button>-->
                            <a class="btn btn-lg btn-block btn-success text-uppercase" href="checkout" class="btn btn-block btn-light"">Checkout</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- JS -->
        <script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/giohang3.js"></script>
        <!--<script src="js/luuTruGiohang.js"></script>-->
    </body>
</html>