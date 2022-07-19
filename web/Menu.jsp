<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Mobile</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                
                <c:if test="${sessionScope.acc.getIsAdmin() == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerAccount">Manager Account</a>
                    </li>
                </c:if>
                    
                <c:if test="${sessionScope.acc.getIsSell() == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manageProduct">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managerSale">Manager Sale</a>
                    </li>
                </c:if>
                    
                <%--</c:if>--%>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="showInfo">Hello ${sessionScope.acc.getUser()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                    <a class="nav-link" href="Login.jsp">Login</a>
                </li>
                </c:if>
                
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value = "${tempTxt}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="menuToCart2?id=${sessionScope.acc.id}">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <!--<span class="badge badge-light">3</span>-->
                </a>
            </form>
                    
        </div>
    </div>
</nav>
<section style="margin-bottom: 0px" class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Cửa hàng điện thoại chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu</p>
    </div>
</section>
                    
<!--<script>
    function run(t){
        alert(t);   
    }
</script>-->
<!--<script src="js/giohang3.js"></script>-->

<!--end of menu-->
