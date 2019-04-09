<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
    <title>Ebenus Admin</title>
    <!-- Custom Fonts -->
    <!-- <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="./assets/css/master.css">

</head>
<body>
<div id="wrapper">

    <div class="modal-container">
        <div class="modal" id="myModal">
            <div class="modal-header">
                <p> <img src="../images/logo.png" alt=""> </p>
                <h3>Bienvenue, Merci de s'identifier</h3>
            </div>
            <form class="form-vertical row no-gutters" action="${pageContext.request.contextPath}/login" method="post">
                <div class="modal-body">
                    <fieldset>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-12 control-label" for="__email">Nom d'utilisateur</label>
                            <div class="col-md-12">
                                <input id="__email" name="__email" type="text" placeholder="Adresse Email" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-12 control-label" for="password">Mot de passe</label>
                            <div class="col-md-12">
                                <input id="password" name="password" type="password" placeholder="Mot de passe" class="form-control input-md" required="">
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit"> Connexion</button>
                </div>
            </form>

        </div>
    </div>



    <script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
    <script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
