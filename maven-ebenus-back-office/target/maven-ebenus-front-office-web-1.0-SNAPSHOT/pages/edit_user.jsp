<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 08/04/2019
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>

<div id="page-wrapper">
    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Editer Utilisateurr
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-edit"></i> Editer Utilisateur
                    </li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/editUser?id=${user.getIdUtilisateur()}" class="validate">
            <div class="row">
                <div class="well well-lg clearfix text-right">
                    <a href="${pageContext.request.contextPath}/users" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                    <button type="submit" class="btn btn-default btn-lg pull-right">
                        Enregistrer
                    </button>
                </div>
            </div>

            <div class="row">
                <fieldset>


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="firstName">Prénom</label>
                        <div class="col-md-9">
                            <input id="firstName" value="${user.getPrenom()}" name="firstName" type="text" placeholder="" class="form-control input-md" >
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="secondName">Nom</label>
                        <div class="col-md-9">
                            <input id="secondName" value="${user.getNom()}" name="secondName" type="text" placeholder="" class="form-control input-md" >
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Rôle</label>
                        <div class="col-md-9">
                            <div class="sel-container">
                                <div class="sel">
                                    <select name="select-rol" id="select-rol">
                                    <c:forEach items="${allRoles}" var="role">

                                        <option value="${role.getIdentifiant()}" <c:if test="${role.getIdentifiant() == 'Administrateur'}"> disabled </c:if> > ${role.getIdentifiant()}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-md-3 control-label civility">Civilité</label>
                        <div class="gender col-md-9">
                            <input type="radio" id="male" name="userSex" <c:if test="${user.getCivilite() == 'Mr'}"> checked="checked" </c:if> readonly />
                            <label for="male">
                                <i class="fa fa-male" aria-hidden="true"></i>
                            </label>
                            <input type="radio" id="female" name="userSex" <c:if test="${user.getCivilite() == 'Mme'}"> checked="checked" </c:if> readonly />
                            <label for="female">
                                <i class="fa fa-female" aria-hidden="true"></i>
                            </label>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="adresseEmail">Identifiant</label>
                        <div class="col-md-9">
                            <input id="adresseEmail" value="${user.getIdentifiant()}" name="adressEmail" type="email" placeholder="" class="form-control input-md" readonly >

                        </div>
                    </div>

                    <!-- Birth day-->
                    <%--<div class="form-group">--%>
                        <%--<label class="col-md-3 control-label"> Date de naissance</label>--%>
                        <%--<div class="birth-day col-md-9">--%>
                            <%--<div class="input-wrapper">--%>
                                <%--<input  autocomplete="off" id="dteNaiss" name="dteNaiss" style="width:auto;" data-toggle="datepicker" type="text" value="" name="naissance" class="form-control input-md">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="passUser">Mot de passe</label>
                        <div class="col-md-9">
                            <input id="passUser" value="${user.getMotPasse()}" name="passUser" type="password" placeholder="" class="form-control input-md" >

                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="passUserBis">Confirmer Mot de passe</label>
                        <div class="col-md-9">
                            <input id="passUserBis" value="${user.getMotPasse()}" name="passUserBis" type="password" placeholder="" class="form-control input-md" >

                        </div>
                    </div>



                    <!--
      /*=====================================
      =            Adress System            =
      =====================================*/
       -->


                    <div class="row">
                        <div class="userAdress">

                            <div class="form-group">
                                <div class="col-md-3"></div>
                                <h2 class="col-md-9">Adresse de facturation</h2>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="street-Bill">Rue</label>

                                <div class="col-md-9">
                                    <input class="form-control" value="${userMainAddr.getRue()}" name="street-Bill" id="street-Bill" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="postalcodeBill">Code Postale</label>

                                <div class="col-md-9">
                                    <input class="form-control" value="${userMainAddr.getCodePostal()}" name="postalcodeBill" id="postalcodeBill" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="cityBill">Ville</label>
                                <div class="col-md-9">
                                    <input class="form-control" value="${userMainAddr.getVille()}" name="cityBill" id="cityBill" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="countryBill">Pays</label>
                                <div class="col-md-9">
                                    <input value="${userMainAddr.getPays()}" class="form-control" name="countryBill" id="countryBill" type="text">
                                </div>
                            </div>



                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-md-3"></div>--%>
                        <%--<h2 class="col-md-9">Adresse(s) de livraison</h2>--%>
                    <%--</div>--%>
                    <%--<div class="row EditAdsressForm hide">--%>


                        <%--<div class="form-group">--%>
                            <%--<label class="col-md-3 control-label" for="street-ship">Rue</label>--%>

                            <%--<div class="col-md-9">--%>
                                <%--<input class="form-control" value="${userMainAddr.getRue()}" name="street-ship" id="street-ship" type="text">--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label class="col-md-3 control-label" for="postalcodeShip">Code Postale</label>--%>

                            <%--<div class="col-md-9">--%>
                                <%--<input class="form-control" value="${userMainAddr.getCodePostal()}" name="postalcodeShip" id="postalcodeShip" type="text">--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label class="col-md-3 control-label" for="cityShip">Ville</label>--%>
                            <%--<div class="col-md-9">--%>
                                <%--<input class="form-control" value="${userMainAddr.getVille()}" name="cityShip" id="cityShip" type="text">--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label class="col-md-3 control-label" for="countryShip">Pays</label>--%>
                            <%--<div class="col-md-9">--%>
                                <%--<input value="${userMainAddr.getPays()}" class="form-control" name="countryShip" id="countryShip" type="text">--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<label class="col-md-3 control-label" for="user-state-pr">Adresse Principale</label>--%>
                            <%--<div class="col-md-9">--%>
                                <%--<input type="checkbox"  name="checkboxes-pr" id="user-state-pr">--%>
                                <%--<label for="user-state-pr"></label>--%>
                            <%--</div>--%>
                        <%--</div>--%>



                    <%--</div>--%>

                    <div class="row">

                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>Adresse</th>
                                    <%--<th>Editer</th>--%>
                                    <th>Supprimer</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userAllAddr}" var="addr">

                                <tr>
                                    <td>${addr.getRue()}, ${addr.getCodePostal()}, ${addr.getVille()}, ${addr.getPays()}</td>
                                    <%--<td> <a class="editAdressLink" href="${pageContext.request.contextPath}/editAddr?id=${addr.getIdAdresse()}"><i class="fa fa-edit"></i></a> </td>--%>
                                    <td> <a class="trashAdressLink" href="${pageContext.request.contextPath}/delAddr?id=${addr.getIdAdresse()}"><i class="fa fa-trash"></i></a> </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!-- /.row -->
                    <div class="row">
                        <div class="well well-lg clearfix text-right">
                            <a href="${pageContext.request.contextPath}/users" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
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
