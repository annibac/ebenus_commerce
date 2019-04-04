<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./pages/base.jsp" %>


    <!-- Section -->
    <section>
        <div class="content">
            <div id="slider" class="owl-carousel owl-theme">
                <div class="item">
                    <a href="#"><img src="./assets/images/slider/ebenus-matelas_2.jpg"/></a>
                </div>

                <div class="item">
                    <a href="#"><img src="./assets/images/slider/ebenus-matelas_1.jpg"/></a>
                </div>

            </div>
            <div class="products-container">
                <h1>Les produits les plus achetés</h1>
                <div class="row no-gutters products-box">

                    <div class="products col-md-12">

                        <ul class="row no-gutters justify-content-between">
                            <c:forEach items="${produits}" begin="0" end="9" var="prd">
                            <li class="col-sm-6 col-md-3 col-lg-2">
                                <div class="image-wrapper">
                                    <img src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg" alt="">
                                </div>
                                <div class="product-info">
                                    <h2 class="product-name">
                                        <a href="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}" class="add-to-cart-btn">
                                                ${prd.getNom()}
                                        </a>
                                    </h2>
                                    <div class="price-box">
                                        <span class="regular-price">${prd.getPrix()}€</span>
                                    </div>
                                </div>
                            </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%@ include file="./pages/footer.jsp" %>

