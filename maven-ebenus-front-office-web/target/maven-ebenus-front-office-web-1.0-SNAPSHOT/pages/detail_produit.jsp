<%--
  Created by IntelliJ IDEA.
  User: celine_nnbl
  Date: 03/04/2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>




    <!-- Section -->
    <section>
        <div class="content">


            <div class="product-view " >
                <div class="row no-gutters">
                    <div class="product-img-box col-md-7 ">
                        <ul>
                            <li>
                                <img class="detail-img" src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg" alt="" />
                            </li>

                        </ul>

                    </div>

                    <div class="product-shop col-md-5">
                        <div class="product-name">
                            <h1>${prd.getNom()}</h1>
                        </div>
                        <div class="short-description">
                            <div class="std">
                                <ul>
                                    <li>Référence : ${prd.getReference()}</li>
                                    <li>Description : ${prd.getDescription()}</li>
                                    <li>Prix : ${prd.getPrix()}€</li>
                                    <li>Stock : ${prd.getStock()}</li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-info">
                            <div>
                                <div class="price-box">
                <span class="regular-price" id="product-price-101">
                    <span class="price">${prd.getPrix()}€</span>
                </span>
                                </div>
                                <p class="reference-product">Ref : <strong>${prd.getReference()}</strong></p>
                                <div class="availability hors-stock">Availability: <span>${prd.getStock()}</span>
                                </div>
                            </div>
                        </div>

                        <div class="add-to-box">
                            <div class="add-to-cart">
                                <form action="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}" method="post" >
                                <input type="hidden" name="name" id="name" value="${prd.getReference()}">
                                <button type="submit" title="Add to Cart" class="button btn-cart">
                                    <i class="icon-cart"></i>Ajouter au panier
                                </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>


<%@ include file="./footer.jsp" %>
