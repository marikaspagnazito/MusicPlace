<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,it.model.*,it.control.*" %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"	src="scripts/AccessoControl.js?4"></script>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Registrazione</title>
<style>
body {
	padding-top: 65px;
}
</style>
</head>
<body>

	<%@include file="../fragments/navbar.jsp"%>



	<form action="RegistrazioneControl" method="post" 
	 onsubmit="event.preventDefault(); registrazioneControl(this)"
	 onchange="validationchange();" novalidate>
	   <input type="hidden" name="action" value="registrazione"> 
	 
		<div class="container-xxl py-4 h-100">
			<section class="vh-100 gradient-custom">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card bg-dark text-white card-registration"
							style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div class="mb-md-5 mt-md-4 pb-5">
									<div class="row ">
										<h3 class="login-heading mb-4">Inserisci i tuoi dati ed
											entra a far parte della famiglia MusicPlace!</h3>
										<br>

										<div class="col-md-4">
											<label for="nome">Nome</label> <input
												type="text" class="form-control " id="nome" name="nome" min="1" max="13" placeholder="Mario" required>
												<div class="invalid-feedback" id="errorid">inserisci un nome valido</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div>

										<div class="col-md-4">
											<label for="cognome">Cognome</label> <input
												type="text" class="form-control" placeholder="Rossi" name="cognome" id="cognome" required>
												<div class="invalid-feedback" id="errorid">inserisci un cognome valido</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div>

										<div class="col-md-4">
											<label for="data_nascita" >Data di nascita</label>
											<input type="date" class="form-control" id="datan" name="data_nascita" min="1920-01-01" max="2007-12-31" required>
											<div class="invalid-feedback" id="errorid">selezionare una data</div>
										</div> <br> <br> <br> <br>

										<div class="col-9">
											<label for="indirizzo">Indirizzo</label> <input
												type="text" class="form-control" name="indirizzo" id="indirizzo"
												placeholder="1234 Main St" required>
												<div class="invalid-feedback" id="errorid">inserire un indirizzo valido</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div>

										<div class="col-3">
											<label for="civico">Civico </label> <input
												type="text" class="form-control" name="civico" id="civico" maxlength="3"
												placeholder="44" required>
												<div class="invalid-feedback" id="errorcivico">Il civico può contenere solo numeri</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div><br> <br> <br> <br>

										<div class="col-md-6">
											<label for="citta" >Città</label> <input
												type="text" class="form-control" placeholder="Milano" name="citta" id="city" required>
												<div class="invalid-feedback" id="errorid">inserire una città valida</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div>


										<div class="col-md-3">
											<label for="provincia">Provincia</label>
											<select class="form-control" name="provincia" id="provincia" required>
											    <option value="Select"> Select</option>
												<option value="AG">AG</option>
												<option value="AL">AL</option>
												<option value="AN">AN</option>
												<option value="AO">AO</option>
												<option value="AQ">AQ</option>
												<option value="AR">AR</option>
												<option value="AP">AP</option>
												<option value="AT">AT</option>
												<option value="AV">AV</option>
												<option value="BA">BA</option>
												<option value="BT">BT</option>
												<option value="BL">BL</option>
												<option value="BN">BN</option>
												<option value="BG">BG</option>
												<option value="BI">BI</option>
												<option value="BO">BO</option>
												<option value="BZ">BZ</option>
												<option value="BS">BS</option>
												<option value="BR">BR</option>
												<option value="CA">CA</option>
												<option value="CL">CL</option>
												<option value="CB">CB</option>
												<option value="CI">CI</option>
												<option value="CE">CE</option>
												<option value="CT">CT</option>
												<option value="CZ">CZ</option>
												<option value="CH">CH</option>
												<option value="CO">CO</option>
												<option value="CS">CS</option>
												<option value="CR">CR</option>
												<option value="KR">KR</option>
												<option value="CN">CN</option>
												<option value="EN">EN</option>
												<option value="FM">FM</option>
												<option value="FE">FE</option>
												<option value="FI">FI</option>
												<option value="FG">FG</option>
												<option value="FC">FC</option>
												<option value="FR">FR</option>
												<option value="GE">GE</option>
												<option value="GO">GO</option>
												<option value="GR">GR</option>
												<option value="IM">IM</option>
												<option value="IS">IS</option>
												<option value="SP">SP</option>
												<option value="LT">LT</option>
												<option value="LE">LE</option>
												<option value="LC">LC</option>
												<option value="LI">LI</option>
												<option value="LO">LO</option>
												<option value="LU">LU</option>
												<option value="MC">MC</option>
												<option value="MN">MN</option>
												<option value="MS">MS</option>
												<option value="MT">MT</option>
												<option value="VS">VS</option>
												<option value="ME">ME</option>
												<option value="MI">MI</option>
												<option value="MO">MO</option>
												<option value="MB">MB</option>
												<option value="NA">NA</option>
												<option value="NO">NO</option>
												<option value="NU">NU</option>
												<option value="OG">OG</option>
												<option value="OT">OT</option>
												<option value="OR">OR</option>
												<option value="PD">PD</option>
												<option value="PA">PA</option>
												<option value="PR">PR</option>
												<option value="PV">PV</option>
												<option value="PG">PG</option>
												<option value="PU">PU</option>
												<option value="PE">PE</option>
												<option value="PC">PC</option>
												<option value="PI">PI</option>
												<option value="PT">PT</option>
												<option value="PN">PN</option>
												<option value="PZ">PZ</option>
												<option value="PO">PO</option>
												<option value="RG">RG</option>
												<option value="RA">RA</option>
												<option value="RC">RC</option>
												<option value="RE">RE</option>
												<option value="RI">RI</option>
												<option value="RN">RN</option>
												<option value="RM">RM</option>
												<option value="RO">RO</option>
												<option value="SA">SA</option>
												<option value="SS">SS</option>
												<option value="SV">SV</option>
												<option value="SI">SI</option>
												<option value="SR">SR</option>
												<option value="SO">SO</option>
												<option value="TA">TA</option>
												<option value="TE">TE</option>
												<option value="TR">TR</option>
												<option value="TO">TO</option>
												<option value="TP">TP</option>
												<option value="TN">TN</option>
												<option value="TV">TV</option>
												<option value="TS">TS</option>
												<option value="UD">UD</option>
												<option value="VA">VA</option>
												<option value="VE">VE</option>
												<option value="VB">VB</option>
												<option value="VC">VC</option>
												<option value="VR">VR</option>
												<option value="VV">VV</option>
												<option value="VI">VI</option>
												<option value="VT">VT</option>
											</select>	                    
										</div>

										<div class="col-md-3">
											<label for="cap" >CAP</label> <input
												type="text" class="form-control" id="cap" name="cap" maxlength="5" placeholder="00000" 
												 required>
												<div class="invalid-feedback" id="errorcap">Il CAP deve avere almeno 5 numeri</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
										</div>
										<br> <br> <br> <br>

										<div class="col-md-7">
											<label for="inputEmail" >Email</label> <input
												type="email" class="form-control" placeholder="----@gmail.com"  id="email" name="email" required>
												<div class="invalid-feedback" id="errorid">il formato non è giusto</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>    
										</div>
										
										<div class="col-md-5">
											<label for="contatto" class="form-label">Numero telefono</label> <input
												type="text" placeholder="(XXX)-XXX-XXXX" class="form-control" id="telefono" name="contatto" required>
												<div class="invalid-feedback" id="errorid">il formato non è giusto</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>                       
										</div> <br> <br> <br> <br>

                                          <hr>
										<div class="col-12" >
											<label for="user" >Username</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="text" class="form-control" name="user" id="user"
													aria-describedby="inputGroupPrepend" required>
												<div class="invalid-feedback" id="errorus">il formato non è giusto</div>
						                        <div class="valid-feedback" id="errorName">Corretto</div>
						                        
											</div>
											<br>


										</div>
										<div class="col-12">
											<label for="password" >Password</label>
											<input type="password" class="form-control" name="pass" id="password" required>
											<div class="invalid-feedback" id="errorpas">la password deve almeno 6 caratteri </div>
						                     <div class="valid-feedback" id="errorName">Corretto</div>
										</div>
										<br> <br> <br> <br>

					

										
										<br> <br>

										<div class="col-12">
											<button class="btn btn-primary" type="submit">Registrati
											</button>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>

			</section>
		</div>
	</form>


	<div id="footer">
		<%@include file="../fragments/footer.jsp"%>
	</div>

		
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
</body>
</html>