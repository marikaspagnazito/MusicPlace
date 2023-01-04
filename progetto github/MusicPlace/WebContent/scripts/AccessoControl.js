/**
 * 
 */







function loginControl(form){
	
	var flag=true;
	var username= $("#username").val();
	var password= $("#password").val();
	
	$(".error").remove();
	
	//username
		if (username.length<1 ) {
			flag=false;
		  $("#username").removeClass("is-valid");
		  $("#username").addClass("is-invalid");
		} else {
		  $("#titolo").removeClass("is-invalid");
		  $("#username").addClass("is-valid");
		}
		
	//password
	if (password.length<1 ) {
			flag=false;
		$("#password").removeClass("is-valid");
		$("#password").addClass("is-invalid");
		} else {
		$("#password").removeClass("is-invalid");
		$("#password").addClass("is-valid");
		}
	
	if (flag) {
			form.submit();
		}
	
}


function registrazioneControl(form){

	var flag= true;
	
	var nome= $("#nome").val();
	var cognome= $("#cognome").val();
	var data= $("#datan").val();
	var indirizzo= $("#indirizzo").val();
	var civico= $("#civico").val();
	var citta = $("#city").val();
	var provincia= $("#provincia").val();
	var cap= $("#cap").val();
	var email=$("#email").val();
	var telefono=$("#telefono").val();
	var username=$("#user").val();
	var password=$("#password").val();
	
	
	
	$(".error").remove(); 
    
    //nome
    if( nome.length < 1 ) {
		 flag=false;
		  $("#nome").removeClass("is-valid");
		  $("#nome").addClass("is-invalid");
		} else {
		  $("#nome").removeClass("is-invalid");
		  $("#nome").addClass("is-valid");
		}
	
	//cognome
	if( cognome.length < 1){
	flag=false;
		  $("#cognome").removeClass("is-valid");
		  $("#cognome").addClass("is-invalid");
		} else {
		  $("#cognome").removeClass("is-invalid");
		  $("#cognome").addClass("is-valid");
		}
		
	//data nascita
	if(data== ""){
	      flag=false;
		  $("#datan").removeClass("is-valid");
		  $("#datan").addClass("is-invalid");
		} else {
		  $("#datan").removeClass("is-invalid");
		  $("#datan").addClass("is-valid");
		}

	//indirizzo
	if (indirizzo.length < 1 ) {
		 flag=false;
		  $("#indirizzo").removeClass("is-valid");
		  $("#indirizzo").addClass("is-invalid");
		} else {
		  $("#indirizzo").removeClass("is-invalid");
		  $("#indirizzo").addClass("is-valid");
		}
	
	//civico
	if(civico.length < 1){
	      flag=false;
		  $("#civico").addClass("is-invalid");
		} else {
		  $("#civico").addClass("is-valid");
		}
		
		
		//città
	if (citta.length < 1 ) {
		 	flag=false;
		 	 $("#city").removeClass("is-valid");
			 	 $("#city").addClass("is-invalid");
			} else {
		 	 $("#city").removeClass("is-invalid");
		 	 $("#city").addClass("is-valid");
			} 
			
			
			
		//provincia
	   if(provincia == "Select"){
	      flag=false;
		  $("#provincia").removeClass("is-valid");
		  $("#provincia").addClass("is-invalid");
		} else {
		  $("#provincia").removeClass("is-invalid");
		  $("#provincia").addClass("is-valid");
		}	
			
		//cap
 		if (cap.length < 5 || cap.length > 5) {
			flag=false;
			$("#cap").addClass("is-invalid");
		} else {
			$("#cap").addClass("is-valid");
		}	
		
		//email
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!email.match(mailformat)){
		flag=false;
		  $("#email").removeClass("is-valid");
		  $("#email").addClass("is-invalid");
		} else {
		  $("#email").removeClass("is-invalid");
		  $("#email").addClass("is-valid");
		}	
			
		//numero telefono
		var telformat = /^\(([0-9]{3})\)[-\.\s]([0-9]{3})[-\.\s]([0-9]{4})$/;
		if(!telefono.match(telformat) || telefono.lenght < 1){
		flag=false;
		  $("#telefono").removeClass("is-valid");
		  $("#telefono").addClass("is-invalid");
		} else {
		  $("#telefono").removeClass("is-invalid");
		  $("#telefono").addClass("is-valid");
		}	
		
		//username
		if (username.length < 1 ) {
		 	flag=false;
		 	 $("#user").removeClass("is-valid");
			 	 $("#user").addClass("is-invalid");
			} else {
		 	 $("#user").removeClass("is-invalid");
		 	 $("#user").addClass("is-valid");
			} 
		
		//password
		if(password.lenght < 6 ){
		flag=false;
		  $("#password").removeClass("is-valid");
		  $("#password").addClass("is-invalid");
		} else {
		  $("#password").removeClass("is-invalid");
		  $("#password").addClass("is-valid");
		}	
		
		
		if (flag) {
			form.submit();
			window.confirm("Registrazione avvenuta con successo");
		}
			
			
}



function validationchange(){


    var nome= $("#nome").val();
    var cognome= $("#cognome").val();
    var indirizzo= $("#indirizzo").val();
    var citta = $("#city").val();
	var civico=$("#civico").val();
	var cap= $("#cap").val();
	var username=$("#user").val();
	var password=$("#password").val();
	
	
		
	//nome
	var patternName = /^[a-zA-Z ]+$/;
	if(!nome.match(patternName) || nome.length < 1 ) {
		 flag=false;
		  $("#nome").removeClass("is-valid");
		  $("#nome").addClass("is-invalid");
		} else {
		  $("#nome").removeClass("is-invalid");
		  $("#nome").addClass("is-valid");
		}
	
	//cognome
	var patternCognome = /^[a-zA-Z ]+$/;
	if(!cognome.match(patternCognome) || cognome.length < 1){
	flag=false;
		  $("#cognome").removeClass("is-valid");
		  $("#cognome").addClass("is-invalid");
		} else {
		  $("#cognome").removeClass("is-invalid");
		  $("#cognome").addClass("is-valid");
		}
		
		//indirizzo
	var patternAddress = /^[a-zA-Z ]+$/;
	if (!indirizzo.match(patternAddress)  || indirizzo.length < 1 ) {
		 flag=false;
		  $("#indirizzo").removeClass("is-valid");
		  $("#indirizzo").addClass("is-invalid");
		} else {
		  $("#indirizzo").removeClass("is-invalid");
		  $("#indirizzo").addClass("is-valid");
		}
		
			
		//città
		var patternCity = /^[a-zA-Z ]+$/;
		if (!citta.match(patternCity) || citta.length < 1 ) {
		 	flag=false;
		 	 $("#city").removeClass("is-valid");
			 	 $("#city").addClass("is-invalid");
			} else {
		 	 $("#city").removeClass("is-invalid");
		 	 $("#city").addClass("is-valid");
			}
			 
	
	var numberpattern= /^[-+]?[0-9]+$/;
	if(!civico.match(numberpattern)){
			$("#civico").removeClass("is-valid");
			$('#errorcivico').show();
		} else {
			$("#civico").removeClass("is-invalid");
			$('#errorcivico').hide();
		}

	 //feedback cap
	  var patternCAP = /^[0-9]{5}$/;
		if (!cap.match(patternCAP) ) {
			$("#cap").removeClass("is-valid");
		    $('#errorcap').show();
		} else {
			$("#cap").removeClass("is-invalid");
			$('#errorcap').hide();
		}
		
		
		// feedback username
		if (username.length < 1 ) {
		 	flag=false;
		 	 $("#user").removeClass("is-valid");
			 $("#user").addClass("is-invalid");
			} else {
		 	 $("#user").removeClass("is-invalid");
		 	 $("#user").addClass("is-valid");
			} 
		
		//password
		if(password.lenght < 6 ){
		  $("#password").removeClass("is-valid");
		  $("#password").addClass("is-invalid");
		} else {
		  $("#password").removeClass("is-invalid");
		  $("#password").addClass("is-valid");
		}
}


