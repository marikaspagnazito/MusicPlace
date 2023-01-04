<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.model.AlbumBean,it.model.BranoBean"%>
    
    
   <% 
   BranoBean brano= (BranoBean) request.getAttribute("brano");
   AlbumBean album= (AlbumBean) request.getAttribute("album");
   
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><%=brano.getTitolo()%></title>

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

.btn-danger {
    background-color: #ff0000 !important;
    border-color: #ff0000 !important
}

.btn-danger:hover {
    background-color: #da0606 !important;
    border-color: #da0606 !important
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#fotoal").hover(function(){
    $(this).css('transform', 'scale(1.1)');
    }, function(){
    $(this).css('transform', 'scale(1)');
  });
});
</script>
</head>
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
                            <div class="text-center p-3"> <img id="fotoal" src="<%=album.getCopertina() %>" alt="Not found" width="250" style="padding-top: 65px "> </div>
                            <div class="thumbnail text-center">  </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product p-4">
                            <div class="d-flex justify-content-between align-items-center">         
                            </div>
                            <div class="mt-4 mb-3"> <span class="text-uppercase text-muted brand">BRANO</span>
                                <h5 class="text-uppercase"><%=brano.getTitolo()%></h5>
                                <div class="price d-flex flex-row align-items-center"> <span class="act-price">dall'album <b><%=album.getTitolo()%></b> <a href="DettaglioControl?product=<%=album.getID()%>&type=album">Scopri di più</a></span> </div><br>
                                <div class="price d-flex flex-row align-items-center"> <span class="act-price">di <b><%=album.getArtista()%></b> <a href="DettaglioControl?product=<%=album.getID()%>&type=artista">Scopri di più</a></span> </div><br>
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Casa discografica: <b><%=album.getCasa_discografica()%></b></div> <br>
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Anno produzione: <b><%=album.getAnnoProduzione()%></b></div> <br>
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> Prezzo: <b>€<%=brano.getPrezzo()%></b></div> <br>
                                 <div class="price d-flex flex-row align-items-center">  <span class="act-price"> di cui IVA: <b>€<%=brano.getIVA()%></b>
                                </div>
                            </div>                
                            <div class="cart mt-4 align-items-center"> <a href="CarrelloControl?product=<%=brano.getID()%>&type=brano&action=add" class="btn btn-danger text-uppercase mr-2 px-4" >Aggiungi al carrello</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

	
	
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