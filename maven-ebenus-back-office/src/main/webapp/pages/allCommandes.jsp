<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 09/04/2019
  Time: 15:35
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
                    Commandes
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Commandes
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <div class="row">

            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Panneau des transactions</h3>
                    </div>
                    <div class="panel-body order">
                        <div class="row">
                            <div class="well well-sm col-md-6">
                                <form action="#" method="get">
                                    <div class="input-group">
                                        <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                                        <input class="form-control" id="system-search" name="q" placeholder="Rechercher une Commande" required>
                                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                        </span>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-6">
                                <!-- Select Basic -->

                            </div>
                        </div>
                        <div class="table-responsive row">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Commande</th>
                                    <th>Date création commande </th>
                                    <th>Date modification commande </th>
                                    <th>Identifiant</th>
                                    <th>statut</th>
                                    <th>Total (Euro)</th>
                                    <th>Voir</th>
                                    <th>Supprimer</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${commandes}" var="cmd">
                                <tr>
                                    <td>${cmd.getIdCommande()}</td>
                                    <td>${cmd.getDateCommande()}</td>
                                    <td>${cmd.getDateModification()}</td>
                                    <td>${userdao.findUtilisateurById(cmd.getIdUtilisateur()).getIdentifiant()}</td>
                                    <td>${cmd.getStatut()}</td>
                                    <td>${cmd.getTotalCommande()}€ </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/detailCommande?id=${cmd.getIdCommande()}">Detail Commande</a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/delCommande?id=${cmd.getIdCommande()}"><button class="no-style-btn">
                                            <i class="fa fa-trash-o"></i>
                                        </button></a>
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
        <!-- /.row -->
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
<script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
