<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,it.model.*,it.control.*"%>

<%
Collection<AlbumBean> prodottiA = (Collection<AlbumBean>) request.getAttribute("album");
Collection<BranoBean> prodottiB = (Collection<BranoBean>) request.getAttribute("brani");
Collection<AlbumBean> prodottiC = (Collection<AlbumBean>) request.getAttribute("playlistArtista");
Collection<AlbumBean> prodottiD = (Collection<AlbumBean>) request.getAttribute("playlistAnno");

String messaggio= (String) session.getAttribute("messaggio");

if (prodottiA == null || prodottiB == null || prodottiC == null || prodottiD == null) {
	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/prodottiControl"));
	return;
}



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>MusicPlace</title>
<style>
body { 
    padding-top: 65px; 
   
}
.MultiCarousel { float: left; overflow: hidden; padding: 15px; width: 100%; position:relative; }
.MultiCarousel .MultiCarousel-inner { transition: 1s ease all; float: left; }
.MultiCarousel .MultiCarousel-inner .item { float: left;}
.MultiCarousel .MultiCarousel-inner .item > div { text-align: center; height: 250px; width: 95%; padding:20px; margin: 10px; background:#f1f1f1; color:#666;}
.MultiCarousel .leftLst, .MultiCarousel .rightLst { position:absolute; border-radius:50%;top:calc(50% - 20px); }
.MultiCarousel .leftLst { left:0; }
.MultiCarousel .rightLst { right:0; }
.MultiCarousel .leftLst.over, .MultiCarousel .rightLst.over { pointer-events: none; background:#ccc; }

</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $(".lead").hover(function(){
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
	
	
	<%
	if(messaggio!=null){
			%>	
			<div class= "container" style="padding-top: 100px">
			<div class="alert alert-success alert-dismissible">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          <strong>Success!</strong> <%=messaggio%>
           </div>
  				 </div>
	<%			
		session.removeAttribute("messaggio");
		}
			
	%>
	

	     <div class="container mt-3" ">
            <div class="d-flex justify-content-center mb-3"  >
			<img class="logo" src="img/logo.png"  alt="Music Place"  width="300" height="250" ></img>
			</div>
			 </div>





<div class="container">
<h3>Gli album più amati</h3>
	<div class="row">
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">
            
	
		<%
		if (prodottiA != null && prodottiA.size() != 0) {
			Iterator<?> it = prodottiA.iterator();
			while (it.hasNext()) {
				AlbumBean album = (AlbumBean) it.next();
		%>
		
		 <div class="item"  >
                    <div class="pad15">
                        <p class="lead"> <img alt="Not found" src="<%=album.getCopertina()%>" width="140" height="140"></p>
                        <h6><%=album.getTitolo()%></h6>
         
                        <p><a href="DettaglioControl?product=<%=album.getID()%>&type=album">Dettagli</a> </p>
                    </div>
                </div>
		<%
		}
		}
		%>
	
	
	    </div>
            <button class="btn btn-primary leftLst"><</button>
            <button class="btn btn-primary rightLst">></button>
        </div>
	</div>
	<div class="row">
	    <div class="col-md-12 text-center">
	        <br/><br/><br/>
	</div>
</div>
</div>


<div class="container">
<h3> I Brani più ascoltati</h3>
	<div class="row">
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">

		<%
		if (prodottiB != null && prodottiB.size() != 0) {
			Iterator<?> it = prodottiB.iterator();
			while (it.hasNext()) {
				AlbumBean album= new AlbumBean();
				AlbumModelDM model= new AlbumModelDM();
				BranoBean brano = (BranoBean) it.next();
				String id= String.valueOf(brano.getIdAlbum());
				album= model.doRetrieveByKey(id);
		%>
		
		<div class="item" >
                    <div class="pad15">
                        <p class="lead"> <img alt="Not found" src="<%=album.getCopertina()%>" width="140" height="140"></p>
                        <h6><%=brano.getTitolo()%></h6>
                        <p><a href="DettaglioControl?product=<%=brano.getID()%>&type=brano">Dettagli</a> </p>
                    </div>
                </div>
		
		<%
		}
		}
		%>
		
		
		    </div>
            <button class="btn btn-primary leftLst"><</button>
            <button class="btn btn-primary rightLst">></button>
        </div>
	</div>
	<div class="row">
	    <div class="col-md-12 text-center">
	        <br/><br/><br/>
	</div>
</div>
</div>


<div class="container">
<h3> THIS IS DRAKE</h3>
	<div class="row">
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">
	

		<%
		if (prodottiC != null && prodottiC.size() != 0) {
			Iterator<?> it = prodottiC.iterator();
			while (it.hasNext()) {
				AlbumBean album = (AlbumBean) it.next();
		%>
		 <div class="item"  >
                    <div class="pad15">
                        <p class="lead"> <img alt="Not found" src="<%=album.getCopertina()%>" width="140" height="140"></p>
                        <h6><%=album.getTitolo()%></h6>
         
                        <p><a href="DettaglioControl?product=<%=album.getID()%>&type=album">Dettagli</a> </p>
                    </div>
                </div>
		<%
		}
		}
		%>
		
		
		    </div>
            <button class="btn btn-primary leftLst"><</button>
            <button class="btn btn-primary rightLst">></button>
        </div>
	</div>
	<div class="row">
	    <div class="col-md-12 text-center">
	        <br/><br/><br/>
	</div>
</div>
</div>
		
		
		<div class="container">
<h3> IL MEGLIO DEL 2021</h3>
	<div class="row">
		<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel"  data-interval="1000">
            <div class="MultiCarousel-inner">


		<%
		if (prodottiD != null && prodottiD.size() != 0) {
			Iterator<?> it = prodottiD.iterator();
			while (it.hasNext()) {
				AlbumBean album = (AlbumBean) it.next();
		%>
		 <div class="item"  >
                    <div class="pad15">
                        <p class="lead"> <img alt="Not found" src="<%=album.getCopertina()%>" width="140" height="140"></p>
                        <h6><%=album.getTitolo()%></h6>
         
                        <p><a href="DettaglioControl?product=<%=album.getID()%>&type=album">Dettagli</a> </p>
                    </div>
                </div>
		<%
		}
		}
		%>
	</div>
            <button class="btn btn-primary leftLst"><</button>
            <button class="btn btn-primary rightLst">></button>
        </div>
	</div>
	<div class="row">
	    <div class="col-md-12 text-center">
	        <br/><br/><br/>
	</div>
</div>
</div>
		

            <div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>

<script type="text/javascript" src="scripts/Home.js"></script>  
	    	    
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>