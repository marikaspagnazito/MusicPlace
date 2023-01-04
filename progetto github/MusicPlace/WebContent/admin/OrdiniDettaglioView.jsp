<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    	import="java.util.*,it.model.*,it.control.*"%>
   

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>MusicPlace</title>
<title>MusicPlace</title>
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}
</style>
<body>
	<hr>
	<h3>Dettagli Ordine</h3>
	<div class="container">
	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr> 
			<th scope="col">Numero Articolo</th>
			<th scope="col">Numero Ordine</th>
			<th scope="col">Titolo</th>
			<th scope="col">Prezzo</th>
			<th scope="col">di cui IVA</th>
		</thead>
		<tbody>
		</tr>
		
		<%
		   
			if (dettagli != null && dettagli.size() != 0) {
				Iterator<?> it = dettagli.iterator();
				while (it.hasNext()) {
					OrdineDettaglioBean ordine = (OrdineDettaglioBean) it.next();
				
			
		%>
		
			<tr>
			<th scope="row"><%=ordine.getId()%></th>			
			<td><%=ordine.getIdOrdine()%></td>
			<td><%=ordine.getTitolo() %>
			<td><%=ordine.getPrezzo()%></td>
			<td><%=ordine.getIVA() %>
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
</body>
</html>