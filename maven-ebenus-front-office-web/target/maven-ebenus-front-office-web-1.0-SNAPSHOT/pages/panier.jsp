<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./base.jsp" %>

<body>
    <div class="outer">
        <div class="header-outer" id="header-outer">
	<!-- Header -->
	<header id="header"  class="header">
		<div class="header">
			<a href="index.html" title="Ebenus Commerce" class="logo"> 
				<img src="./assets/images/logo/logo.png" alt="Ebenus Commerce"> 
			</a>
		    <ul class="main-menu">
		    	<li><a href="index.html">Accueil</a></li>
		    	<li><a href="products.html">Produits</a></li>
		    	<li><a href="qui-sommes-nous.html">Qui sommes-nous</a></li>
		    	<li><a href="contact.html">Contactez-nous</a></li>
		    	<li class="last">
		    		<a href="#" class="account-link">Mon Compte</a>
					<ul class="sub-menu">
						<li><a href="informations-personnelle.html">Mon Compte</a></li>
						<li class="guest">
							<a href="login.html">Login</a>
						</li>
						<li class="logged">
							<a href="informations-personnelle.html"><strong>Mr John Doe</strong></a>
						</li>
						<li><a href="panier.html">Panier</a></li>
						<li><a href="creer-compte-client.html">Créer Compte</a></li>
						</ul>
						</li>
						<li class="header-icon-cart">
                    <a class="menu-cart-icon" href="panier.html"><i class="icon-cart"></i></a>
                </li>
						</ul>
                    <div class="phone-block">
                        <i class="icon-phone"></i>
                        Appelez nous<br>
                        <b>+33 5678 890</b>
                    </div>

                    <div class="search-area">
                        <a href="javascript:void(0)" class="search-icon">
                            <!-- <i class="fa fa-search"></i> -->
                            <i class="icon-search"></i>
                        </a>
                        <form id="search_mini_form" action="" method="get">
                            <div class="form-search">
                                <input id="search" placeholder="Rechercher un produit" type="text" name="q" class="input-text" autocomplete="off">
                                <button type="submit" title="Search" class="button"><i class="icon-search"></i></button>
                            </div>
                        </form>
                    </div>
                </div>
            </header>
        </div>

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
                              <a href="detail-produit-1.html">
                                      ${prd.getNom()}
                              </a>
                            </h2>
                            <a href="detail-produit-1.html">
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
                        <div class="product-quantity">
                            <div class="product-removal">
                              <button class="remove-product">
                                <i class="fa fa-trash-o"></i>
                              </button>
                            </div>
                            <div class="product-line-price">${prd.getPrix()}€</div>
                          </div>

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
                    </c:forEach>

                </div>
        </section>

<%@ include file="./footer.jsp" %>
