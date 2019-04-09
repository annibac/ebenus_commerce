<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 04/04/2019
  Time: 13:02
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
                    Utilisateurs
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Utilisateurs
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="well well-lg clearfix">
                <form action="ajouter-utilisateur.html">
                    <button class="btn btn-default btn-lg pull-right">
                        Ajouter Utilisateur
                    </button>
                </form>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="panel panel-default">
                <c:if test="${param.error != null}">
                    <div style="margin: 20px 0; color: #ff0000"><%= request.getParameter("error") %></div>
                </c:if>
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-users"></i> Liste des Utilisateurs</h3>
                </div>
                <div class="panel-body">
                    <div class="well well-sm">
                        <form action="#" method="get">
                            <div class="input-group">
                                <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                                <%--<input class="form-control" id="system-search" name="q" placeholder="Rechercher un utilisateur" required>--%>
                                <span class="input-group-btn">
                          <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                      </span>
                            </div>
                        </form>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Statut</th>
                                <th>Rôle</th>
                                <th>Identifiant</th>
                                <th>Date de création</th>
                                <th>Date de modification</th>
                                <th>Adresse de facturation</th>
                                <th>Editer</th>
                                <th>Supprimer</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user">

                            <tr>
                                <td>${user.getPrenom()} ${user.getNom()}</td>
                                <td>Active</td>
                                <td>${user.getRole().getIdentifiant()}</td>
                                <td>${user.getIdentifiant()}</td>
                                <td>${user.getDateCreation()}</td>
                                <td>${user.getDateModification()}</td>
                                <td>${address.findUserMainAdresse(user).getRue()}</td>
                                <td><a href="${pageContext.request.contextPath}/editUser?id=${user.getIdUtilisateur()}"><i class="fa fa-edit"></i></a></td>
                                <td><a href="${pageContext.request.contextPath}/delUser?id=${user.getIdUtilisateur()}"><i class="fa fa-trash-o"></i></a></td>
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