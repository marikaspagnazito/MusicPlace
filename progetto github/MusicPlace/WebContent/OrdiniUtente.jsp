<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,it.model.*,it.control.*"%>
    
    <%
    String username = (String) request.getSession().getAttribute("currentUser");
    Collection <OrdineBean> ordini= (Collection<OrdineBean>) request.getAttribute("ordiniUtente");
    Collection <OrdineDettaglioBean> dettagli=(Collection<OrdineDettaglioBean>) request.getAttribute("dettagli");
    
    if (username == null || username.equals("")) {
    	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/LoginView.jsp"));
    	return;
    }
    
    if (ordini == null) {
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath() + "/OrdiniUtenteControl"));
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
<title>Ordini</title>
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}
</style>
<body>

<%@include file="../fragments/navbarLog.jsp"%>


<%
	if (ordini.isEmpty()) {
	%>
	
	
	     <div class="container mt-3" style="padding-top:150px;">
            <div class="d-flex justify-content-center mb-3"  >
			<img class="logo" src="img/ordinivuoti.png"  alt="Nessun ordine"  width="580" height="366"></img>
			</div>
			 </div>

<%
} else {
%>



	<h1>MusicPlace</h1>
	<hr>
	<h3>Ordini</h3>
	<div class="container">
	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr> 
			<th scope="col">Numero</th>
			<th scope="col">Data</th>
			<th scope="col">Prezzo Complessivo</th>
			<th scope="col">di cui IVA</th>
			<th scope="col"></th>
		</thead>
		<tbody>
		</tr>
		
		<%
		   
			if (ordini != null && ordini.size() != 0) {
				Iterator<?> it = ordini.iterator();
				while (it.hasNext()) {
					OrdineBean ordine = (OrdineBean) it.next();
					Calendar data = ordine.getData();
			
		%>
		
			<tr>
			<th scope="row"><%=ordine.getNumeroOrdine()%></th>			
			<td><%=data.get(Calendar.DAY_OF_MONTH)%>/<%=data.get(Calendar.MONTH)+1%>/<%=data.get(Calendar.YEAR)%></td>
			<td><%=ordine.getPrezzo() %>
			<td><%=ordine.getIVA()%></td>
			<td><a href="OrdiniUtenteControl?order=<%=ordine.getNumeroOrdine()%>">Dettagli</a></td>
		</tr>
		<%
			}
			}
		
		%>
	</tbody>
	</table>
	</div></div></div>
<%}

		if (dettagli != null) {
	%>
            <div id="dettagli">
			<%@include file="./OrdiniDettaglioUtente.jsp"%>
		    </div>

<%
		}
	%>
	
	
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