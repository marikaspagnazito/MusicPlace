<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,it.model.*,it.control.*"%>
    
    <%
        Collection <OrdineBean> ordini=(Collection<OrdineBean>) request.getAttribute("ordini");
    
    if (ordini == null) {
		response.sendRedirect(
		response.encodeRedirectURL(request.getContextPath() + "/ordini"));
		return;
    }
    
    Collection <OrdineDettaglioBean> dettagli=(Collection<OrdineDettaglioBean>) request.getAttribute("dettagli");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>MusicPlace</title>	   
</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px; 
}

.table { width: 100%; }

#InputData {
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#InputUser {
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
</style>
<body>


<%@include file="../fragments/navbarAdmin.jsp"%>


	<h1  style="text-align:center; padding: 20px;">ORDINI</h1>
	<hr>
	
  

<div class="container">

  <input type="text" id="InputData" onkeyup="DateFunction()" placeholder="Ricerca per Data." title="Type in a name">
  <input type="text" id="InputUser" onkeyup="UserFunction()" placeholder="Ricerca per Utente." title="Type in a name">

	<div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	<div class="table-responsive-xl" align="center" >
	<table class="table table-hover table-bordered" id="myTable">
	 <thead class="thead-dark">
		<tr class="header"> 
			<th scope="col">Numero</th>
			<th scope="col">Data</th>
			<th scope="col">Prezzo Complessivo</th>
			<th scope="col">di cui IVA</th>
			<th scope="col">Username </th>
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
			<td><%=ordine.getNumeroOrdine()%></td>		
			<td><%=data.get(Calendar.DAY_OF_MONTH)%>/<%=data.get(Calendar.MONTH)+1%>/<%=data.get(Calendar.YEAR)%></td>
			<td><%=ordine.getPrezzo() %></td>
			<td><%=ordine.getIVA()%></td>
			<td><%=ordine.getUserName() %></td>
			<td><a href="ordini?order=<%=ordine.getNumeroOrdine()%>">Dettagli</a></td>
		</tr>
		<%
			}
			}
		%>
		</tbody>
	</table>
	 </div></div></div>
	 
<script>
function DateFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("InputData");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  
  for(i=0;i<tr.length;i++){
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
    }       
}

function UserFunction() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("InputUser");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  
	  for(i=0;i<tr.length;i++){
	    td = tr[i].getElementsByTagName("td")[4];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	    }       
	}
</script>

	
	
	
	<%
		if (dettagli != null) {
	%>
            <div id="dettagli">
			<%@include file="./OrdiniDettaglioView.jsp"%>
		    </div>

<%
		}
	%>
	
          	<div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>



</html>