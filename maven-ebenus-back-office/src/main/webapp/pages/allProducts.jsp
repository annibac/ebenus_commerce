<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 09/04/2019
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>

<div id="page-wrapper">
    <div class="container-fluid">
        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Produits
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Produits
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="well well-lg clearfix">
                <form action="ajouter-produit.html">
                    <button class="btn btn-default btn-lg pull-right">
                        Ajouter Produit
                    </button>
                </form>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-money"></i> Liste des Produits</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="well well-sm col-lg-6">
                            <form action="#" method="get">
                                <div class="input-group">
                                    <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                                    <input class="form-control" id="system-search" name="q" placeholder="Rechercher un produit" required>
                                    <span class="input-group-btn">
                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                        </span>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="table-responsive listProducts">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Image</th>
                                <th>Nom</th>
                                <th>Référence</th>
                                <th>Prix</th>
                                <th>Quantité</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${produits}" var="prd">
                            <tr>
                                <td>1</td>
                                <td><img class="admin__control-thumbnail" src="./assets/images\products/360365.350.350.jpg" alt="Lorem ipsum dolor."></td>
                                <td>${prd.getNom()}</td>
                                <td>${prd.getReference()}</td>
                                <td>${prd.getPrix()}€</td>
                                <td>${prd.getStock()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/editProduit?id=${prd.getIdProduit()}"><i class="fa fa-edit"></i></a>
                                    <a href="${pageContext.request.contextPath}/delProduit?id=${prd.getIdProduit()}"><i class="fa fa-trash-o"></i></a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

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
