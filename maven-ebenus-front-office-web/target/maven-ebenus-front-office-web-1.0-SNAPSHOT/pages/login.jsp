<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./base.jsp" %>

        <!-- Section -->
        <section>
            <div class="content">
                <div class="account-login">
    <div class="page-title">
        <h1>Identifiez vous ou créez un compte</h1>
    </div>
            <form action="${pageContext.request.contextPath}/login" method="post" id="login-form">
    	<input name="form_key" type="hidden" value="HAtrCPk787XUz3um">
        <div class="row">
            
            <div class="col-md-5 registered-users">
                <div>
                    <h2>CONNECTEZ-VOUS</h2>
                    <p>On se connait déjà ?</p>
                    <p>Connectez-vous avec votre <strong>adresse e-mail</strong> et votre <strong>mot de passe</strong> pour accéder à votre espace client.</p>
                    <c:if test="${param.error != null}">
                        <div style="margin: 20px 0; color: #ff0000"><%= request.getParameter("error") %></div>
                    </c:if>
                    <ul class="form-list">
                        <li>
                            <label for="__email" class="required">Email<em>*</em></label>
                            <div class="input-box">
                                <input type="text" name="__email" value="" id="__email" class="input-text" title="Email">
                            </div>
                        </li>
                        <li>
                            <label for="pass" class="required">Mot de passe<em>*</em></label>
                            <div class="input-box">
                                <input type="password" name="password" class="input-text" id="pass" title="Password">
                            </div>
                        </li>
                       </ul>
                    <p class="required-msg">* champs obligatoires</p>
                </div>
            </div>

            <div class="offset-md-2">
                
            </div>

            <div class="col-md-5 new-users">
                <div>
                    <h2>NOUVEAU CLIENT ?</h2>
                    <p>C’est votre première visite ?</p>
                    <p>Pour commander et accéder à nos différents services, nous vous convions à créer un compte client. C’est simple, rapide et il vous apportera de nombreux avantages.</p>
                </div>

            </div>
            
        </div>
        <div class="row actions">
           
            <div class="col-md-5 registered-users">
                <div class="buttons-set_">
                    <%--<a href="mot-de-passe-oublie.html" class="f-left">Mot de passe oublié ?</a>--%>
                     <!-- <form action="index.jsp" method="get">
                        <button type="submit" title="Connexion" class="button" >Connexion</button>
                    </form> -->
                        <button type="submit"> Connexion</button>
                </div>
            </div>
            <div class="offset-md-2"></div>
             <div class="col-md-5 new-users">
                <div class="buttons-set">
                     <!-- <form action="creer-compte-client.jsp" method="get">
                        <button type="submit" title="Create an Account" class="button" >Créer le compte</button>
                    </form> -->
                    <a title="Create an Account" href="creer-compte-client.jsp" role="button">Créer le compte</a>
                </div>
            </div>
        </div>
       </form>

</div> 
            </div>
        </section>

        <!-- Footer -->
<%@ include file="./footer.jsp" %>
