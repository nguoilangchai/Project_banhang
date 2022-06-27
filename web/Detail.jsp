<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <style>
            .hide {
                display: none;
            }
            
            
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
<!--            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>-->
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row" style="margin-top:20px">
                        
                            <div class="col-6 col-md-6 col-lg-4">
                                <div class="card">
                                    <h1 class="hide">${detail.id}</h1>
                                    <h2 class="hide">${sessionScope.acc.getId()}</h2>
                                    <img class="card-img-top" src="${detail.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?tempPid=${detail.id}" title="View Product"><h4>${o.name}</h4> </a></h4>
                                        <p class="card-text show_txt">${detail.title}</p>
                                        
                                    
                                </div>
                                        
                            </div>
                                        <c:if test="${sessionScope.acc == null}">
                                        <a href="Login.jsp">
                                            <button style="width:100%; margin-top: 10px" class="btn btn-success btn-block" id="add-to-cart"">Add to cart</button>
                                        </a>
                                    </c:if>
                                 </div>
                                             <div class="col-6 col-md-6 col-lg-4">
                                
                                        <dt >Description</dt>
                                        <p id="mo-ta" style="margin-top:10px">
                                                    ${detail.description}
                                                </p>
                                        <div class="row">
                                            <p>
                                                <span style="margin-left:80px" class="btn btn-danger">${detail.price}</span>
                                            </p>
                                            <h3>$</h3>

                                        </div>
                                            
                                    </div>
                                            

                                    <c:if test="${sessionScope.acc != null}">
                                        <button style="width:66%;margin-top: 10px" class="btn btn-success btn-block" id="add-to-cart"">Add to cart</button>
                                    </c:if>
                                    <!--<button class="btn btn-success btn-block" id="add-to-cart"">Add to cart</button>-->
                                    
                                    
                                </div>
                            </div>
                        
                    </div>
                </div>

            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="js/luuTruGiohang.js"></script>
        <!--<script src="js/luuTruGiohang2.js"></script>-->
    </body>
</html>


