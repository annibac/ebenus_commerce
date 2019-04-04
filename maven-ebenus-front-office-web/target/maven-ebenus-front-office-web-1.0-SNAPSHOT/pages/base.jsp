<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 03/04/2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ebenus</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/logo/favicon.png">
    <!-- CSS files -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/master.css" >

</head>

<body>
<div class="outer">
    <div class="header-outer" id="header-outer">
        <!-- Header -->
        <header id="header"  class="header">
            <div class="header">
                <a href="${pageContext.request.contextPath}/index" title="Ebenus Commerce" class="logo">
                    <img src="./assets/images/logo/logo.png" alt="Ebenus Commerce">
                </a>
                <ul class="main-menu">
                    <li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
                    <li><a href="${pageContext.request.contextPath}/products">Produits</a></li>
                    <li><a href="#">Qui sommes-nous</a></li>
                    <li><a href="#">Contactez-nous</a></li>
                    <li class="last">
                        <a href="#" class="account-link">Mon Compte</a>
                        <ul class="sub-menu">
                            <li><a href="informations-personnelle.html">Mon Compte</a></li>

                            <li class="logged">
                                <c:choose>
                                    <c:when test="${userLogged != null}">
                                    <a href="informations-personnelle.html"><strong>${userLogged.getCivilite()}
                                        ${userLogged.getNom()}</strong></a>
                                    </c:when>
                                        <c:otherwise>
                                            <strong>Guest</strong>
                                        </c:otherwise>
                                </c:choose>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/panier">Panier</a></li>
                        </ul>
                    </li>
                    <li class="header-icon-cart">
                        <a class="menu-cart-icon" href="${pageContext.request.contextPath}/panier"><i class="icon-cart"></i></a>
                    </li>
                </ul>
                <div class="phone-block">
                    <i class="icon-phone"></i>
                    Appelez nous<br>
                    <b>+33 5678 890</b>
                </div>

                <div class="search-area">
                    <a href="javascript:void(0)" class="search-icon">
                        <!-- <i class="fa fa-search"></i> -->
                        <i class="icon-search"></i>
                    </a>
                    <form id="search_mini_form" action="" method="get">
                        <div class="form-search">
                            <input id="search" placeholder="Rechercher un produit" type="text" name="q" class="input-text" autocomplete="off">
                            <button type="submit" title="Search" class="button"><i class="icon-search"></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </header>
    </div>