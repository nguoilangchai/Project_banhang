<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Test User Info</title>
        <meta charset="utf-8">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-7 ">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>User Profile</h4>
                        </div>
                        <div class="panel-body">
                            <div class="box box-info">
                                <div class="box-body">
                                    <div class="col-sm-6">                 
                                            <div align="center"> <img alt=""                                                              
                                                                      src="${userInfo.image}"
                                                                      id="profile-image1" class="img-circle img-responsive">
                                            </div>
                                        <br>
                                    </div>
                                    <div class="col-sm-6">
                                        <h6>Username: ${sessionScope.acc.getUser()}</h6>
                                        <h6>Password: ${sessionScope.acc.getPass()}</h6>
                                    </div>
                                    <div class="clearfix"></div>
                                    <hr style="margin:5px 0 5px 0;">

                                    <form action="updateInfo" method="post" class="form-signup">

                                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                                            Fill full the information</h1>
                                        <h5>UserID : ${sessionScope.acc.getId()}</h5>
                                        <input name="fullname" type="text" id="user-name" class="form-control"
                                               value="${userInfo.fullName}" placeholder="Input full name" required="" autofocus="">
                                        <input name="address" type="text" id="user-pass" class="form-control"
                                               value="${userInfo.address}" placeholder="Input address" required autofocus="">
                                        <input name="mobile" type="text" id="user-repeatpass" class="form-control"
                                               value="${userInfo.mobile}" placeholder="Input mobile" required autofocus="">
                                        <input name="linkImage" type="text" id="user-repeatpass" class="form-control"
                                               value="${userInfo.image}" placeholder="Input link image" required autofocus="">

                                        <button class="btn btn-primary btn-block" type="submit"><i
                                                class="fas fa-user-plus"></i> Save</button>

                                        <br>
                                        <a href="showInfo">Back</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </body>
                    </html>
