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

                                    <form action="updatePass" method="post" class="form-signup">

                                        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                                            Enter your new password</h1>
                                        <h5>UserID : ${sessionScope.acc.getId()}</h5>
                                        <input name="newPass" type="text" id="user-name" class="form-control"
                                               value="${sessionScope.acc.getPass()}" placeholder="Enter your new password" required="" autofocus="">
                                        <button class="btn btn-primary btn-block" type="submit"><i
                                                class="fas fa-user-plus"></i> Save</button>

                                        <br>
                                        <a href="updatePass">Back</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </body>
                    </html>
