<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/img/logo.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Login Page</title>
<style>
body { 
    padding-top: 65px; 
   
}

</style>
</head>


<%@include file="../fragments/navbar.jsp"%>

	<body>
	
<form action="LoginControl" method="post" onsubmit="event.preventDefault(); loginControl(this)" novalidate>	
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Inserisci il tuo username e la tua password!</p>

              <div class="form-outline form-white mb-4">
              <label class="form-label" for="typeUsername">Username</label>
                <input type="text" id="username" name="un" maxlength="10"  placeholder="Username" class="form-control form-control-lg" required />
               <div class="invalid-feedback" id="error">Inserisci l'Username</div>
                
              </div>
               
              <div class="form-outline form-white mb-4">
               <label class="form-label" for="typePasswordX">Password</label>
                <input type="password" id="password" name="pw"  maxlength="16"  placeholder="Password" class="form-control form-control-lg" required />
                <div class="invalid-feedback" id="error">Inserisci la password</div>
               
                
              </div>

              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

            </div>
            

            <div>
              <p class="mb-0">Don't have an account? <a href="RegistrazioneView.jsp" class="text-white-50 fw-bold">Sign Up</a></p>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>
		
		<%
	
	 if(request.getSession().getAttribute("validation")=="false"){
	%>
		
		<p style="Color:red">Password o Username errati, riprova o registrati</p>
		</div>
		
	<%
		request.getSession().removeAttribute("validation");
	 }
		 
		 
		 
	%>
	

		
		 <div id="footer">
			<%@include file="../fragments/footer.jsp"%>
		    </div>
	
	
<script type="text/javascript"	src="scripts/AccessoControl.js"></script>	
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>
