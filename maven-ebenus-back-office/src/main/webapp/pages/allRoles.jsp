<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 08/04/2019
  Time: 23:38
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
                    Rôles
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Rôles
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="well well-lg clearfix">
                <form action="ajouter-role.html">
                    <button class="btn btn-default btn-lg pull-right">
                        Ajouter un Rôle
                    </button>
                </form>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-users"></i> Liste des Rôles</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${param.error != null}">
                        <div style="margin: 20px 0; color: #ff0000"><%= request.getParameter("error") %></div>
                    </c:if>
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>IdRole</th>
                                <th>Identifiant</th>
                                <th>Description</th>
                                <th>Editer</th>
                                <th>Supprimer</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${roles}" var="role">
                            <tr>
                                <td>${role.getIdRole()}</td>
                                <td>${role.getIdentifiant()}</td>
                                <td>${role.getDescription()}</td>
                                <td><a href="${pageContext.request.contextPath}/editRole?id=${role.getIdRole()}"><i class="fa fa-edit"></i></a></td>
                                <td><a href="${pageContext.request.contextPath}/delRole?id=${role.getIdRole()}"><i class="fa fa-trash-o"></i></a></td>
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
