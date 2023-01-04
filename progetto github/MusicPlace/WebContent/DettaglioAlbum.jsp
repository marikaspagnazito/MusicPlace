<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.model.AlbumBean,it.model.BranoBean"%>
    
 <%
	Collection<BranoBean> products = (Collection<BranoBean>) request.getAttribute("brani");
	AlbumBean album = (AlbumBean) request.getAttribute("album");
	
%>   
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

<title><%=album.getTitolo()%></title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#main-image").hover(function(){
    $(this).css('transform', 'scale(1.1)');
    }, function(){
    $(this).css('transform', 'scale(1)');
  });
});
</script>

</head>
<style>
h3 { color: #111; font-family: 'Open Sans Condensed', sans-serif; font-size: 50px; font-weight: 700; line-height: 64px; margin: 0 0 0; padding: 20px 30px; text-align: center; text-transform: uppercase; }
body { 
    padding-top: 65px;
}
body {
    background-color: #000
}
 
.card {
    border: none
}

.brand {
    font-size: 13px
}

.dis-price {
    text-decoration: line-through
}

.color {
    margin-bottom: 10px
}



.btn-danger {
    background-color: #ff0000 !important;
    border-color: #ff0000 !important
}

.btn-danger:hover {
    background-color: #da0606 !important;
    border-color: #da0606 !important
}

.btn-danger:focus {
    box-shadow: none
}

.cart i {
    margin-right: 10px
} 

</style>
<body>

<%
	String username = (String) request.getSession().getAttribute("currentUser");

	if (username == null || username.equals("")) {
	%>
	
	<%@include file="../fragments/navbar.jsp"%>
	
	<%
	
	} else {
	%>
	
	<%@include file="../fragments/navbarLog.jsp"%>
	
	<%
	}
	%>
     
    <div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="row">
                    <div class="col-md-6">
                        <div class="images p-3">
                            <div class="text-center p-4"> <img id="main-image" src="<%=album.getCopertina() %>" alt="Not found" width="250"> </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product p-4">
                            <div class="d-flex justify-content-between align-items-center"> 
                          
                            <div class="mt-4 mb-3">
                                <h4 class="text-uppercase"><%=album.getTitolo()%></h4>
                                <div class="price d-flex flex-row align-items-center"> <span class="act-price">di <b><%=album.getArtista()%></b> <a href="DettaglioControl?product=<%=album.getID()%>&type=artista">Scopri di più</a></span> </div>
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Casa discografica: <b><%=album.getCasa_discografica()%></b></div> 
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Anno produzione: <b><%=album.getAnnoProduzione()%></b></div> 
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Prezzo: <b>€<%=album.getPrezzo()%> </b></div> 
                          <div class="cart mt-4 align-items-center"> <a href="CarrelloControl?action=add&product=<%=album.getID()%>&type=album" class="btn btn-danger text-uppercase mr-2 px-4" >Aggiungi al carrello</a>  </div>
                                </div>
                          </div>
                            </div>                
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    
    
	<h3>Tracklist</h3>
	
	 <div class="container">
	 <div class="shadow-lg p-3 mb-5 bg-white tab-pane fade show active rounded" id="shadowProducts">
	 <div class="table-responsive-xl" align="center" >
	 <table class="table table-hover table-bordered">
	 <thead class="thead-dark">
		<tr>
		    <th scope="col">Copertina</th>
			<th scope="col">Titolo</th>
			<th scope="col">Prezzo</th>
			<th scope="col">Di cui IVA</th>
			<th scope="col"> </th>
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
		    <td><img src="<%=album.getCopertina() %>" alt="Not found" weight="100" height="100"></td>
			<th scope="row"><%=brano.getTitolo()%></th>
			<td><%=brano.getPrezzo()%></td>
			<td><%=brano.getIVA()%></td>
			<td><a href="CarrelloControl?product=<%=brano.getID()%>&type=brano&action=add">Aggiungi
					al carrello</a></td>
		</tr>
		<%
			n++;
				}
			}
		%>
		</tbody>
	</table>
	</div></div></div>


	
            <div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>
		    
		    

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"</script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>