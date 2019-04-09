<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 09/04/2019
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %><div id="page-wrapper">
    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Editer Produit
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Editer Produit
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="well well-lg clearfix text-right">
                <a href="produits.html" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                <button type="submit" class="btn btn-default btn-lg pull-right">
                    Enregistrer
                </button>
            </div>
        </div>

        <div class="row">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/editProduit?id=${prd.getIdProduit()}" >
                <fieldset>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Référence</label>
                        <div class="col-md-9">
                            <input id="ref" value="EDF564EDDEF5" name="ref" type="text" placeholder="" class="form-control input-md" required="">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Intitulé Produit</label>
                        <div class="col-md-9">
                            <input id="nom" value="BEKO Réfrigérateur 2 portes RED45DXP, 400L, Froid No Frost" name="nom" type="text" placeholder="" class="form-control input-md" required="">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Prix</label>
                        <div class="col-md-6">
                            <input id="prix" value="598" name="prix" type="number" placeholder="" class="form-control input-md" required="">
                        </div>
                        <div class="col-md-3">
                            <input id="devise" value="€" name="devise" class="form-control input-md" readonly/>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Stock</label>
                        <div class="col-md-9">
                            <input id="stock" value="20" name="stock" type="number" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>

                    <!-- Textarea -->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="desc">Description</label>
                        <div class="col-md-9">
                  <textarea class="form-control" id="desc" name="desc" rows="6">
                      ${prd.getDescription()}
                  </textarea>
                        </div>
                    </div>
                </fieldset>
                <button type="submit" class="btn btn-default btn-lg pull-right">
                    Enregistrer
                </button>
            </form>
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

