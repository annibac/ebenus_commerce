<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 09/04/2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>

<div id="page-wrapper">
    <div class="container-fluid order-detail">
        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Détail Commande
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Détail commande
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Commande : ${cmd.getIdCommande()}</div>
                    <table class="table">
                        <!-- <div class="well well-sm">Commande : DFFDDF555645DF</div> -->
                        <tbody>
                        <tr>
                            <th>Date création commande</th>
                            <td>${cmd.getDateCommande()}</td>

                        </tr>
                        <tr>
                            <th>Date modification commande</th>
                            <td>${cmd.getDateModification()}</td>

                        </tr>
                        <tr>
                            <th>Statut du commande</th>
                            <td>${cmd.getStatut()}</td>

                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Informations compte</div>
                    <table class="table">
                        <!-- <div class="well well-sm">Commande : DFFDDF555645DF</div> -->
                        <tbody>
                        <tr>
                            <th>Client</th>
                            <td>${user.getCivilite()} ${user.getPrenom()} ${user.getNom()}</td>

                        </tr>
                        <tr>
                            <th>Identifiant</th>
                            <td>${user.getIdentifiant()}</td>

                        </tr>
                        <tr>
                            <th>Passer par</th>
                            <td>${user.getPrenom()} ${user.getNom()}</td>

                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Adresse de facturation</div>
                    <p>
                        ${addr.getRue()}, ${addr.getCodePostal()} ${addr.getVille()}, ${addr.getPays()}
                    </p>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Adresse de livraison</div>
                    <p>
                        ${addr.getRue()}, ${addr.getCodePostal()} ${addr.getVille()}, ${addr.getPays()}
                    </p>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Informations sur paiement</div>
                    <p>
                        chèque
                    </p>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Informations sur livraison</div>
                    <p>
                        Transport inclus
                    </p>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Produits commandés</div>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Produit</th>
                                <th>Référence</th>
                                <th>Prix</th>
                                <th>Quantité</th>
                                <th>Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${articles}" var="art">
                            <tr>
                                <td>Joust Duffle Bag</td>
                                <td>${artdao.findProduitById(art.getIdProduit()).getReference()}</td>
                                <td>${artdao.findProduitById(art.getIdProduit()).getPrix()}€</td>
                                <td>${art.getQuantite()}</td>
                                <td>${art.getTotalArticleCommande()}€</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
<script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
