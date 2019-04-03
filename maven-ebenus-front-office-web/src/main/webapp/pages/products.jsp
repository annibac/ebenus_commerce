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
				<li><a href="${pageContext.request.contextPath}/index">Accueil</a></li>
				<li><a href="${pageContext.request.contextPath}/products">Produits</a></li>
				<li><a href="#">Qui sommes-nous</a></li>
				<li><a href="#">Contactez-nous</a></li>
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
                <div class="products-container">
	<h1>PRODUCTS</h1>
	<div class="row no-gutters products-box">
		<div class="side-bar col-md-3 col-sm-12">
			<dl class="filter-layers">
			
				<dt>Produit</dt>
				<dd>
					<div class="text-box">
					<input type="text" name="min" id="minPrice" class="priceTextBox minPrice" placeholder="Filtrer par produit" value="" /> 
					<input type="button" value="FILTER" name="go" class="go" />
					</div>
				</dd>

			</dl>
		</div>
		<div class="products col-md-9">
			<div class="row no-gutters sort-by align-items-center justify-content-end">
				<!-- <div class="col-sm-6 col-md-4 col-lg-3">
					<span>Trier par</span>
				</div> -->
				<div class="col-sm-12 col-md-4 col-lg-3">
					<div class="sel-container">
						<div class="sel">
						  <select name="select-adress" id="select-adress">
						    <option value="Trier Par" disabled>Trier Par</option>
						    <option value="Prix">Prix</option>
						    <option value="Nom">Nom</option>
						    <option value="Ascendant">Ascendant</option>
						    <option value="Descendant">Descendant</option>
						  </select>
						</div>
					</div>
				</div>
			</div>
		<ul class="row no-gutters justify-content-between">
			<c:forEach items="${produits}" var="prd">
			<li class="col-sm-6 col-md-4 col-lg-3">
					<div class="image-wrapper">
						<img src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg" alt="">
						<a href="${pageContext.request.contextPath}/product?id=${prd.getIdProduit()}" class="add-to-cart-btn">
							<button  class="addtocart" title="Add to Cart" >
								<i class="icon-cart"></i>
								<span>Ajouter au panier</span>
							</button>
						</a> 
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

<%@ include file="./footer.jsp" %>
