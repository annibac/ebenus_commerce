<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 09/04/2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>


<div id="page-wrapper">
    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Nouveau Rôle
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Nouveau Rôle
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/editRole?id=${role.getIdRole()}">
            <div class="row">
                <div class="well well-lg clearfix text-right">
                    <a href="${pageContext.request.contextPath}/roles" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                    <button type="submit" class="btn btn-default btn-lg pull-right">
                        Enregistrer
                    </button>
                </div>
            </div>

            <div class="row">
                <fieldset>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Identifiant</label>
                        <div class="col-md-9">
                            <input id="identifiant" name="identifiant" value="${role.getIdentifiant()}" type="text" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" >Description</label>
                        <div class="col-md-9">
                  <textarea rows="7" class="form-control input-md" name="description" id="description">${role.getDescription()}
                  </textarea>
                        </div>
                    </div>

                    <!-- /.row -->
                    <div class="row">
                        <div class="well well-lg clearfix text-right">
                            <a href="${pageContext.request.contextPath}/roles" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                            <button type="submit" class="btn btn-default btn-lg pull-right">
                                Enregistrer
                            </button>
                        </div>
                    </div>
                </fieldset>
            </div>
        </form>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
<script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
