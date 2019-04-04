<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>

        <!-- Section -->
        <section>
            <div class="content">
                
                <div class="shopping-cart">

                <h1>Panier</h1>
                    <div class="column-labels">
                        <label class="product-image">Image</label>
                        <label class="product-details">Produit</label>
                        <label class="product-price">Prix</label>
                        <label class="product-removal">Supprimer</label>
                        <label class="product-line-price">Total</label>
                    </div>
                <!-- ////////////////////////////////////////////  Row   /////////////////////////////////////// -->
                    <c:forEach items="${produits}" var="prd">

                        <div class="product">
                            <div class="product-image">
                                <a href="detail-produit-1.html">
                                    <img src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg">
                                </a>
                            </div>
                            <div class="product-details">
                                <h2 class="product-title">
                                    <a href="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}">
                                            ${prd.getNom()}
                                    </a>
                                </h2>
                                <a href="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}">
                                    <div class="product-description">
                                        <ul>
                                            <li>Référence : ${prd.getReference()}</li>
                                            <li>Description : ${prd.getDescription()}</li>
                                            <li>Prix : ${prd.getPrix()}€</li>
                                            <li>Stock : ${prd.getStock()}</li>
                                        </ul>
                                    </div>
                                </a>
                            </div>
                            <div class="product-price">${prd.getPrix()}€</div>
                            <div class="product-removal">
                                <a href="${pageContext.request.contextPath}/delArtCo?id=${prd.getIdProduit()}">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </div>
                            <div class="product-line-price">${prd.getPrix()}€</div>
                        </div>

                    </c:forEach>
                        <div class="totals">

                            <div class="totals-item totals-item-total">
                                <label>Total</label>
                                <div class="totals-value" id="cart-total">${total}€</div>
                            </div>
                        </div>

                        <form action="confirmation.html" method="post">
                            <button type="submit" class="checkout">Valider</button>
                        </form>
                    </div>
                </div>
        </section>

<%@ include file="./footer.jsp" %>
