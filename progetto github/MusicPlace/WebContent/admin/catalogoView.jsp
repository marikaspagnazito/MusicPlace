<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,it.model.*,it.control.*"%>
    
    
    
    <%
	Collection<AlbumBean> prodottiA = (Collection<AlbumBean>) request.getAttribute("album");
    Collection <ArtistaBean> artisti=(Collection <ArtistaBean>) request.getAttribute("artisti");
    
	if (prodottiA == null || artisti==null ) {
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath() + "/catalogo"));
		return;
	}
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>MusicPlace</title>
<div id="navbar">
			<%@include file="../fragments/navbarAdmin.jsp"%>
		    </div>
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}




</style>
<body>
          
	<h1  style="text-align:center; padding: 20px;">CATALOGO</h1>
	<hr>
	<h3>Album</h3>
	<div class="container">
	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div style="height: 600px;overflow: scroll;">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered ">
	<thead class="thead-dark">
		<tr> 
		    <th scope="col">ID</th>
		    <th scope="col">Copertina</th>
			<th scope="col">Titolo</th>
			<th scope="col">Artista</th>
			<th scope="col">Prezzo</th>
			<th scope="col">di cui IVA</th>
			<th scope="col"></th>
			<th scope="col"></th>
			</thead>
		<tbody>
		</tr>
		<%
		   
			if (prodottiA != null && prodottiA.size() != 0) {
				Iterator<?> it = prodottiA.iterator();
				while (it.hasNext()) {
					AlbumBean album = (AlbumBean) it.next();
		%>
		<tr>
			<th scope="row"><%=album.getID()%></th>
			<td><img alt="Not found" src="<%=album.getCopertina()%>" width="100" height="100"</td>
			<td><%=album.getTitolo()%></td>
			<td><%=album.getArtista()%></td>
			<td><%=album.getPrezzo()%></td>
			<td><%=album.getIVA()%></td>
			<td><a href="catalogo?action=delete&id=<%=album.getID()%>">Delete</a><br></td>
			<td><a href="catalogodett?id=<%=album.getID()%>">Details</a><br></td>
		</tr>
		<%
			}
			}
		%>
	
	</tbody>
	</table>
	</div></div> </div>
	
	
	</div> 
	<hr>
	
	<h3>Artisti</h3>
	<div class="container">
	<div class="row">
    <div class="col">
	
	<div class="table-responsive-xl" align="center" >
	<table style="width: 50%;" class="table table-hover table-bordered  table-condensed ">
	<thead class="thead-dark">
		<tr> 
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
		</thead>
		<tbody>
		</tr>
		<%
		   
			if (artisti != null && artisti.size() != 0) {
				Iterator<?> it = artisti.iterator();
				while (it.hasNext()) {
					ArtistaBean artista= (ArtistaBean) it.next();
					%>
		<tr>
			<th scope="row"><%=artista.getID()%></th>
			<td><%=artista.getNome()%></td>
		</tr>
	<%	
		}
		}
	
		%>
		
		</tbody>
		</table>    
		</div></div>
		
		<form action="catalogo" method="get"  onsubmit="event.preventDefault(); controlFormArtista(this)" 
     onchange="validInvalidfeedbackArtista();"  novalidate>
	    <input type="hidden" name="action" value="inserimentoArtista"> 
	    <fieldset>
			
	    <div class="shadow-lg p-3 mb-5 bg-white rounded" id="shadowInsert">
				<div class="form-row">
					<legend align="center">
				<h6>Inserisci Artista</h6>
			</legend>
					<div class="col-md-6 mb-3">
					<label for="IdAlbum">Nome</label>  <input type="text"
							class="form-control" id="nome" name="nome" 
							min=1 max="18" placeholder="Nome Artista" required>
						<div class="invalid-feedback" id="errorid"> il nome deve avere almeno un carattere </div>
						<div class="valid-feedback" id="errorName">Corretto</div>
	                </div>
	                
	                <div class="col-md-6 mb-3">
						<label for="foto">URL foto</label> <input type="text"
							class="form-control" id="foto" name="foto" min="1" maxlength="200"
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
	   
		
		</div></div>
		</div>
		
		
		<hr>
	        <div id="dettagli">
			<%@include file="insertAlbum.jsp"%>
		    </div>
		    
		     <div id="modifica">
			<%@include file="ModificaAlbum.jsp"%>
		    </div>
		    
		    	<div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>
		    
		    
<script type="text/javascript" src="scripts/ControlForm.js?5"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>