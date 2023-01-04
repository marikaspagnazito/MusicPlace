/**
 * 
 */

function pagamentiControl(form){
	
	var flag=true;

	var numero= $("#numero").val();
	var titolare= $("#titolare").val();
	var circuito=$("#circuito").val();
	var scadenza=$("#scadenza").val();
	var cvv=$("#cvv").val();
	
	
	$(".error").remove();
	
	//numero
	var patternumber= /^(\d{4}[- ]){3}\d{4}|\d{16}$/;
	if(!numero.match(patternumber)){
		flag=false;
			$("#numero").removeClass("is-valid");
			$("#numero").addClass("is-invalid");
		} else {
			$("#numero").removeClass("is-invalid");
			$("#numero").addClass("is-valid");
		}
		
	//titolare	
	
  	//titolare
	var patternName = /^[a-zA-Z ]+$/;
	if(!titolare.match(patternName)  ) {
		 flag=false;
		  $("#titolare").removeClass("is-valid");
		 $('#errort').show();
		} else {
		  $("#titolare").removeClass("is-invalid");
		  $('#errort').hide();
		}
	
	//circuito
	var patternName = /^[a-zA-Z ]+$/;
	if(!circuito.match(patternName) ) {
		 flag=false;
		  $("#circuito").removeClass("is-valid");
		 $('#errorc').show();
		} else {
		  $("#circuito").removeClass("is-invalid");
		 $('#errorc').hide();
		}
	
	
	 
	 var patternscadenza=/\b(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})\b/;
		if(!scadenza.match(patternscadenza)){
			flag=false;
				$("#scadenza").removeClass("is-valid");
				$("#scadenza").addClass("is-invalid");
			} else {
				 var exDate=new Array();
			     exDate= scadenza.split("/");
			     var exMonth=exDate[0];
			     var exYear=exDate[1];
			     var date=new Date();
			     var month=date.getMonth()+1;
			     var year=date.getFullYear();
			     
			     if(exYear>year){
			    	 $("#scadenza").removeClass("is-invalid");
					 $("#scadenza").addClass("is-valid");
			     }
			     else if(year == exYear && exMonth>= month){
			    		$("#scadenza").removeClass("is-invalid");
						$("#scadenza").addClass("is-valid");
			     }
			   else{
				   flag=false;
			       $("#scadenza").removeClass("is-valid");
				   $("#scadenza").addClass("is-invalid");
			   }
			}
	
	//cvv
 		if (cvv.length < 3 || cvv.length > 3) {
			flag=false;
			$("#cvv").addClass("is-invalid");
		} else {
			$("#cvv").addClass("is-valid");
		}	
	if (flag) {
			form.submit();
			
		} 
}

function validationChange(){
	
	var numero= $("#numero").val();
	var titolare= $("#titolare").val();
	var circuito=$("#circuito").val();  
	var cvv=$("#cvv").val();
	
	//numero
	var numberpattern= /^(\d{4}[- ]){3}\d{4}|\d{16}$/;
	if(!numero.match(numberpattern)){
			$("#numero").removeClass("is-valid");
			$('#errorn').show();
		} else {
			$("#numero").removeClass("is-invalid");
			$('#errorn').hide();
		}
	
	//titolare
	var patternName = /^[a-zA-Z ]+$/;
	if(!titolare.match(patternName)  ) {
		 flag=false;
		  $("#titolare").removeClass("is-valid");
		 $('#errort').show();
		} else {
		  $("#titolare").removeClass("is-invalid");
		  $('#errort').hide();
		}
	
	//circuito
	var patternName = /^[a-zA-Z ]+$/;
	if(!circuito.match(patternName) ) {
		 flag=false;
		  $("#circuito").removeClass("is-valid");
		 $('#errorc').show();
		} else {
		  $("#circuito").removeClass("is-invalid");
		 $('#errorc').hide();
		}
	
	//cvv
	  var patterncvv = /^[0-9]{3}$/;
		if (!cvv.match(patterncvv) ) {
			$("#cvv").removeClass("is-valid");
		    $('#errorcvv').show();
		} else {
			$("#cvv").removeClass("is-invalid");
			$('#errorcvv').hide();
		}
		
	
}