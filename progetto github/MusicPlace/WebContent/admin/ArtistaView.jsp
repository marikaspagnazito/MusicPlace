<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,it.model.*,it.control.*"%>
    
    <%
    
    Collection <ArtistaBean> artisti=(Collection <ArtistaBean>) request.getAttribute("artisti");
    
	if (artisti == null ) {
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath() + "/adminArtistiControl"));
		return;
	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Catalogo</title>
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
</style>
<body>
	<h1>MusicPlace</h1>
	<hr>
	
	<h3>Artisti</h3>
	<div class="container">
	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr> 
			<th scope="col">Id</th>
			<th scope="col">Nome</th>
			<th scope="col"></th>
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
			<td><%=artista.getFoto() %></td>
		</tr>
	<%	
		}
		}
	
		%>
		
		</tbody>
		</table>
		</div></div></div>
		
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>