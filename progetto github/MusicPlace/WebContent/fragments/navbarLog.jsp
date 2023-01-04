<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>MusicPlace</title>
<style>


  #result {
   
   position: absolute;
   width: 100%;
   max-width:250px;
   cursor: pointer;
   overflow-y: auto;
   max-height: 200px;
   box-sizing: border-box;
   z-index: 1001;
  }
  .link-class:hover{
   background-color:#f1f1f1;
  }
  

  </style>
</head>
<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color:black; ">
  <a class="navbar-brand" href="/MusicPlace/HomeView.jsp">MusicPlace</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="/MusicPlace/HomeView.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/MusicPlace/Libreria.jsp">La mia libreria</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/MusicPlace/OrdiniUtente.jsp">I miei ordini</a>
      </li>
      </ul>
        <ul class="navbar-nav ml-auto">
        <li class="nav-item">
         <a class="nav-link" style="color:white;">Ciao, <%=username %> :)</a>
          </li>
        <li class="nav-item">
        <a class="nav-link"  href="/MusicPlace/CarrelloView.jsp"><i class="fas fa-shopping-cart" style='font-size:24px;color:white'></i></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <i class="fas fa-user" style='font-size:24px;color:white'></i>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="LogoutControl">Logout</a>
        </div>
      </li>
      <li>
      <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search"  id="inputSearch" placeholder="Search" aria-label="Search">
     </form>
     <div class="list-group" id="result"></div>
      </li>
      </ul>
    </div>
    

</nav>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script type="text/javascript" src="scripts/ajax/sendInformation.js?2"></script> 
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>