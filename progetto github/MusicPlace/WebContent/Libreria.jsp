 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,it.model.*,it.control.*"%>

<%
String username = (String) request.getSession().getAttribute("currentUser");
Collection<Object> prodotti = (Collection<Object>) request.getAttribute("prodotti");

if (username == null || username.equals("")) {
	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/LoginView.jsp"));
	return;
}

if (prodotti == null) {
	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/LibreriaControl"));
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La mia libreria</title>
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style >
body { 
    padding-top: 65px; 
}
@import url('https://fonts.googleapis.com/css?family=Quicksand:400,700');

/* Design */
*,
*::before,
*::after {
  box-sizing: border-box;
}



body {
  color: #272727;
  font-family: 'Quicksand', serif;
  font-style: normal;
  font-weight: 400;
  letter-spacing: 0;
  
}

.main{
  max-width: 1200px;
  margin: 0 auto;
}

h1 {
    font-size: 24px;
    font-weight: 400;
    text-align: center;
}

img {
  height: auto;
  max-width: 100%;
  vertical-align: middle;
}


.btn:hover {
  background-color: rgba(255, 255, 255, 0.12);
}

.cards {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
  margin: 0;
  padding: 0;
}

.cards_item {
  display: flex;
  padding: 1rem;
}

@media (min-width: 40rem) {
  .cards_item {
    width: 50%;
  }
}

@media (min-width: 56rem) {
  .cards_item {
    width: 33.3333%;
  }
}

.card {
  background-color: white;
  border-radius: 0.25rem;
  box-shadow: 0 20px 40px -14px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  overflow: hidden;
}

.card_content {
  padding: 1rem;
  background: white;
}

.card_title {
  color: #ffffff;
  font-size: 1.1rem;
  font-weight: 700;
  letter-spacing: 1px;
  text-transform: capitalize;
  margin: 0px;
}

.card_text {
  color: #ffffff;
  font-size: 0.875rem;
  line-height: 1.5;
  margin-bottom: 1.25rem;    
  font-weight: 400;
}


</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $(".card").hover(function(){
    $(this).css('transform', 'scale(1.1)');
    }, function(){
    $(this).css('transform', 'scale(1)');
  });
});
</script>
</head>

<body>


	<%@include file="../fragments/navbarLog.jsp"%>

	
	<%
	if (prodotti.isEmpty()) {
	%>
	
	
	     <div class="container mt-3" style="padding-top:150px;">
            <div class="d-flex justify-content-center mb-3"  >
			<img class="logo" src="img/libreriavuota.jpg"  alt="Libreria vuota"  width="580" height="366" ></img>
			</div>
			 </div>

<%
} else {
%>



<div class="main" style="padding-top: 100px">
<h1>La mia libreria</h1>
    <ul class="cards">
<%
	for (Object e : prodotti) {
		if (e instanceof AlbumBean) {
			AlbumBean album = new AlbumBean();
			album = (AlbumBean) e;
			if(album.getCopertina()!=null){
	%>
	
	
	 <li class="cards_item">
    <div class="card">
      <div class="card_image"><img src="<%=album.getCopertina() %>" class="card-img-top" alt="..." width="400" ></div>
       <div class="card_content">
        <h5 class="card-title"><%=album.getTitolo()%></h5>
      </div>
    </div>
</li>
	

	<%
			}
	} else {
	BranoBean brano = new BranoBean();
	AlbumBean album= new AlbumBean();
	AlbumModelDM model= new AlbumModelDM();
	brano = (BranoBean) e;
	String id= String.valueOf(brano.getIdAlbum());
	album= model.doRetrieveByKey(id);
	if(album.getCopertina()!=null){
	
	%>

 <li class="cards_item">
    <div class="card">
      <div class="card_image"><img src="<%=album.getCopertina() %>" class="card-img-top" alt="..." weight="100" height="100"></div>
       <div class="card_content">
        <h5 class="card-title"><%=brano.getTitolo()%></h5>
      </div>
    </div>
</li>
        
        

	<%
	}
	}
	}
	%>
 </ul>
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