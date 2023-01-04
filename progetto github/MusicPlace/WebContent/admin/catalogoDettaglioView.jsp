<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.model.AlbumBean,it.model.BranoBean"%>
    
 <%
	Collection<BranoBean> products = (Collection<BranoBean>) request.getAttribute("brani");
	AlbumBean album = (AlbumBean) request.getAttribute("album");
	
	if (album == null || products==null) {
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath() + "/catalogodett"));
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
<title><%=album.getTitolo()%></title>
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}
</style>
<body>

			<!-- Navbar -->
          <div id="navbar">
			<%@include file="../fragments/navbarAdmin.jsp"%>
		    </div>


<div class="container">
<br>
<h1 style="text-align:center;"><%=album.getTitolo()%></h1>
	<p style="text-align:center;">
		di <b><%=album.getArtista()%></b>
	</p>
	<hr>
	<p style="text-align:center;" >
		Casa discografica: <b><%=album.getCasa_discografica()%></b>
	</p>
	<hr>
	</div>
	<br>
	<h3>Tracklist</h3>
	<div class="container">
	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div style="height: 600px;overflow: scroll;">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Titolo</th>
			<th scope="col">Copertina</th>
			<th scope="col">Prezzo</th>
			<th scope="col">Di cui IVA</th>
			<th scope="col"></th>
		</thead>
		<tbody>
		</tr>
		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				int n = 1;
				while (it.hasNext()) {
					BranoBean brano = (BranoBean) it.next();
		%>
		<tr>
		
			<th scope="row"><%=brano.getID() %></th>
			<td><%=brano.getTitolo()%></td>
			<td><img src="<%=album.getCopertina() %>" alt="Not found" weight="100" height="100"></td>
			<td><%=brano.getPrezzo()%></td>
			<td><%=brano.getIVA()%></td>
			<td><a href="catalogodett?action=delete&product=<%=brano.getID()%>&id=<%=album.getID()%>">Delete</a><br></td>
		</tr>
		<%
			n++;
				}
			}
		%>
	</tbody>
	</table>
	</div></div></div>
	
	</div>
	<div id="dettagli">
			<%@include file="insertBrano.jsp"%>
		    </div>
		    
		       <div id="modifica">
			<%@include file="ModificaBrano.jsp"%>
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