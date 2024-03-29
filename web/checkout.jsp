<%-- 
    Document   : checkout
    Created on : Jun 3, 2022, 6:36:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
  <title>Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="css/payment.css">
  <style>
      .hide {
                display: none;
            }
  </style>
</head>
<body>
    <jsp:include page="Menu.jsp"></jsp:include>
  <main class="page payment-page">
    <section class="payment-form dark">
      <div class="container">
        <div class="block-heading">
          <h2>Payment</h2>         
        </div>
        <form action="luuThanhToan" method="post">
          <h1 id="duyNhat" class="hide">${id}</h1>
        
        
        <input class="hide" id="chuaDuLieuIdSanPham" name="danhSachIDItem" type="text">
        <input class="hide" id="chuaDuLieuSoLuongItem" name="danhSachSoluongItem" type="text">
       
        
          <div class="products" id="danhSachItem">
              
          </div>
            
          <div class="card-details">
            <h3 class="title">Credit Card Details</h3>
            <div class="row">
              <div class="form-group col-sm-7">
                <label for="card-holder">Tên</label>
                <input id="user-name" onchange="checkName()" type="text" name="fullName" value="${userInfo.fullName}" class="form-control" placeholder="Nhập tên" aria-label="Card Holder" aria-describedby="basic-addon1">
              </div>
              <div class="form-group col-sm-7">
                <label for="card-holder">Địa chỉ</label>
                <input id="card-holder2" type="text" class="form-control" name="diaChi" value="${userInfo.address}" placeholder="Nhập địa chỉ" aria-label="Card Holder" aria-describedby="basic-addon1">
              </div>
              <div class="form-group col-sm-8">
                <label for="card-number">Số điện thoại</label>
                <input id="sdt" onchange="checkSDT()" type="text" name="sdt" value="${userInfo.mobile}" class="form-control" placeholder="Nhập số điện thoại" aria-label="Card Holder" aria-describedby="basic-addon1">
              </div>
              <div class="form-group col-sm-12">
                <button type="submit" class="btn btn-primary btn-block" onclick="xoaItem()">Thanh toán</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </section>
  </main>
  
</body>
<%--<jsp:include page="Footer.jsp"></jsp:include>--%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!--<script src="js/giohang.js"></script>-->
<script src="js/checkout.js"></script>
<script src="js/XuLyFormCheckout.js"></script>
</body>
</html>