
<%@ include file="./base.jsp" %>

        <!-- Section -->
        <section>
            <div class="content">
                <div class="account-create">
	<h1>Créer un compte</h1>
	<div class=" common-form-controls">
		<form id="form-validate" method="post" action="#" class="validate row no-gutters common-form-controls">
			<fieldset class="col-md-6">
				<h2>Informations personnelles</h2>
				<label for="firstname">Prénom</label>
				<input name="firstname" id="firstname" type="text">
				<label for="lastname">Nom</label>
				<input name="lastname" id="lastname" type="text">
				<label for="pseudo">Identifiant</label>
				<input name="email" id="email" type="email">
				<label for="password">Mot de passe</label>
				<input name="password" id="password" type="password">
				<label for="password">Confimer mot de psse</label>
				<input name="password" id="password-C" type="password">   
			      
				<label>Civilité</label>
				<div class="gender">
					<input type="radio" id="male" name="sex" checked="checked"/>
					<label for="male">
					  <i class="fa fa-male" aria-hidden="true"></i>
					</label>
					<input type="radio" id="female" name="sex"/>
					<label for="female">
					  <i class="fa fa-female" aria-hidden="true"></i>
					</label>
				</div>
				<div class="input-wrapper">
            <label style="display: block;"> Date de naissance<em>*</em></label>
            <input  autocomplete="off" id="dteNaiss" name="dteNaiss" style="width:auto;" data-toggle="datepicker" type="text" value="" name="naissance">
        </div>

			</fieldset>
			
			<fieldset class="col-md-6">
				<h2>Adresse</h2>
				<div class="radio-box">
						<span>Ceci est mon :</span>
						<form action="#">
						  <p>
						    <input class="chb1" type="checkbox" id="shippingAdress" name="shippingAdress" checked>
						    <label for="shippingAdress">Adresse de livraison</label>
						  </p>
						  <p>
						    <input class="chb2" type="checkbox" id="billAdress" name="billAdress">
						    <label for="billAdress">Adresse de facturation</label>
						  </p>
						  <p>
						    <input class="chb1 chb2" type="checkbox" id="BillShip" name="BillShip">
						    <label for="BillShip">Adresse de livraison et de facturation</label>
						  </p>
						</form>
					</div>

				<div class="adress-box-shipping">
					<h2>Adresse de livraison</h2>
					<label for="street-ship">Rue</label>
					<input name="street-ship" id="street-ship" type="text">
					<label for="postalcodeShip">Code Postale</label>
					<input name="postalcodeShip" id="postalcodeShip" type="text">
					<label for="cityShip">Ville</label>
					<input name="cityShip" id="cityShip" type="text">
					<label for="countryShip">Pays</label>
					<input name="countryShip" id="countryShip" type="text">
				</div>
				<div class="adress-box-billing">
					<h2>Adresse de facturation</h2>
					<label for="streetBill">Rue</label>
					<input name="streetBill" id="streetBill" type="text">
					<label for="postalcodeBill">Code Postale</label>
					<input name="postalcodeBill" id="postalcodeBill" type="text">
					<label for="cityBill">Ville</label>
					<input name="cityBill" id="cityBill" type="text">
					<label for="countryBill">Pays</label>
					<input name="countryBill" id="countryBill" type="text">
				</div>

				<div class="adress-box-shipBill">
					<h2>Adresse de livraison et de factuartion</h2>
					<label for="street-BillShip">Rue</label>
					<input name="street-BillShip" id="street-BillShip" type="text">
					<label for="postalcodeBillShip">Code Postale</label>
					<input name="postalcodeBillShip" id="postalcodeBillShip" type="text">
					<label for="cityBillShip">Ville</label>
					<input name="cityBillShip" id="cityBillShip" type="text">
					<label for="countryBillShip">Pays</label>
					<input name="countryBillShip" id="countryBillShip" type="text">
				</div>
			</fieldset>
				<div class="actions">
				<button type="submit">S'enregistrer</button>
				</div>
		</form>
	</div>
</div> 
            </div>
        </section>

<%@ include file="./footer.jsp" %>

