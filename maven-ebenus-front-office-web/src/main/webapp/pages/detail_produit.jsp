<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 03/04/2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>


<body>
<div class="outer">
    <div class="header-outer" id="header-outer">
        <!-- Header -->
        <header id="header"  class="header">
            <div class="header">
                <a href="index.html" title="Ebenus Commerce" class="logo">
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
                            <li class="guest">
                                <a href="login.html">Login</a>
                            </li>
                            <li class="logged">
                                <a href="informations-personnelle.html"><strong>${userLogged.getCivilite()}
                                    ${userLogged.getNom()}</strong></a>
                            </li>
                            <li><a href="panier.html">Panier</a></li>
                            <li><a href="creer-compte-client.html">Créer Compte</a></li>
                        </ul>
                    </li>
                    <li class="header-icon-cart">
                        <a class="menu-cart-icon" href="panier.html"><i class="icon-cart"></i></a>
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

    <!-- Section -->
    <section>
        <div class="content">


            <div class="product-view " >
                <div class="row no-gutters">
                    <div class="product-img-box col-md-7 ">
                        <ul>
                            <li>
                                <img class="detail-img" src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg" alt="" />
                            </li>

                        </ul>

                    </div>

                    <div class="product-shop col-md-5">
                        <div class="product-name">
                            <h1>${prd.getNom()}</h1>
                        </div>
                        <div class="short-description">
                            <div class="std">
                                <ul>
                                    <li>Référence : ${prd.getReference()}</li>
                                    <li>Description : ${prd.getDescription()}</li>
                                    <li>Prix : ${prd.getPrix()}€</li>
                                    <li>Stock : ${prd.getStock()}</li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-info">
                            <div>
                                <div class="price-box">
                <span class="regular-price" id="product-price-101">
                    <span class="price">${prd.getPrix()}€</span>
                </span>
                                </div>
                                <p class="reference-product">Ref : <strong>${prd.getReference()}</strong></p>
                                <div class="availability hors-stock">Availability: <span>${prd.getStock()}</span>
                                </div>
                            </div>
                        </div>

                        <div class="add-to-box">
                            <div class="add-to-cart">
                                <form action="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}" method="post" >
                                <input type="hidden" name="name" id="name" value="${prd.getReference()}">
                                <button type="submit" title="Add to Cart" class="button btn-cart">
                                    <i class="icon-cart"></i>Ajouter au panier
                                </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>


<%@ include file="./footer.jsp" %>
