<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,it.model.*,it.control.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
  crossorigin="anonymous">
  
<title>Insert title here</title>
</head>
<body>


<form action="catalogo" method="get" enctype="multipart/form-data"
      onsubmit="event.preventDefault(); controlAlbumForm(this)" 
    onchange="validInvalidfeedback();"  novalidate>
	    <input type="hidden" name="action" value="inserimentoAlbum"> 
	    <fieldset>
			<legend align="center">
				<h3>INSERISCI ALBUM</h3>
			</legend>
	    <div class="shadow-lg p-3 mb-5 bg-white rounded" id="shadowInsert">
				<div class="form-row">
					<div class="col-md-4 mb-3">
					<label for="IdAlbum">ID Album</label> <input type="text"
							class="form-control" id="IDAlbum" name="IdAlbum" min="5" maxlength="5"
							placeholder="37520" required>
						<div class="invalid-feedback" id="errorn">L'ID deve avere minimo 5 numeri</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
	                </div>
	                <div class="col-md-4 mb-3">
						<label for="titolo">Titolo</label> <input type="text"
							class="form-control" id="titolo" name="titolo" 
							min=1 max="18" placeholder="titolo canzone" required>
						<div class="invalid-feedback" id="errorid">Il titolo deve avere almeno un carattere</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
						
					</div>
					<div class="col-md-4 mb-3">
						<label for="casa_disc">Casa Discografica</label> <input type="text"
							class="form-control" id="casad" name="casa_disc" min="1"
							max="18" placeholder="Sony" required>
						<div class="invalid-feedback" id="errorid">La casa discografica deve avere almeno un carattere</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
					</div>
				</div>
				<div class="form-row">
	                 <div class="col-md-4 mb-3">
						<label for="prezzo">Prezzo</label> <input type="text"
							class="form-control" id="prezzo" name="prezzo" min="1" max="30"
							 placeholder="12" required>
						<div class="invalid-feedback" id="errorPrice">Il prezzo deve essere minimo 1 massimo 30</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
					</div>
					<div class="col-md-4 mb-3">
						<label for="anno">Anno di produzione</label> <input type="text"
							class="form-control" id="anno" name="anno" min="1900" max="2021"
							 placeholder="2020" required>
						<div class="invalid-feedback" id="errorPrice">Inserisci un anno compreso tra 1900 e 2021</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
					</div>

					<div class="col-md-4 mb-3">
					<label for="artista">ID Artista</label> <input type="text"
							class="form-control" id="IDArtista" name="artista" min="1" maxlength="200"
							placeholder="7" required>
						<div class="invalid-feedback" id="errorid">L'ID dell'artista deve essere un valore tra 1 e 200</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
	                </div>
				</div>
				<div class="form-row">
					<div class="col-md-4 mb-3">
					<label for="copertina">URL Copertina</label> <input type="text"
							class="form-control" id="copertina" name="copertina" min="1" maxlength="200"
							placeholder="7" required>
						<div class="invalid-feedback" id="errorid">Inserire un URL valido</div>
						<div class="valid-feedback" id="errorName">Corretto</div>
	                </div>
				</div>
				
				<div style="margin-top: 10px">
				    <button class="btn btn-warning" type="reset" id="reset">Reset</button>
				 <button class="btn btn-success" type="submit" id="inserisci">Insert</button>
				</div>
			</div>
</fieldset>
</form>
	   
	
	
<!-- SCRIPT BOOTSTRAP -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>