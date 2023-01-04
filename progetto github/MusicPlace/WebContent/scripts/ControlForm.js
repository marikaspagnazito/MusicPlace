


//onsumbit inserimento Album

function controlAlbumForm(form){
	
	    var flag=true;
		
		var idalbum= $("#IDAlbum").val();
		var titolo= $("#titolo").val();
		var casadiscografica= $("#casad").val();
		var anno= $("#anno").val();
		var prezzo= $("#prezzo").val();
		var idartista= $("#IDArtista").val();
		var copertina=$("#copertina").val();
		
		
		$(".error").remove();
	
	
	    //Id album
 		if (idalbum.length <5 || idalbum.length>5) {
			flag=false;
			$("#IDAlbum").addClass("is-invalid");
			console.log("id false");
		} else {
			$("#IDAlbum").addClass("is-valid");
			console.log("id true");
		}
		
		//titolo
		if (titolo.length<1 || titolo.length>18) {
			flag=false;
			$("#titolo").removeClass("is-valid");
			$("#titolo").addClass("is-invalid");
			console.log("titolo false");
		} else {
			$("#titolo").removeClass("is-invalid");
			$("#titolo").addClass("is-valid");
			console.log("name true");
		}
	
	    //Casa discografica
		if (casadiscografica.length<1 || casadiscografica.length>18) {
			flag=false;
			$("#casad").removeClass("is-valid");
			$("#casad").addClass("is-invalid");
			console.log("titolo false");
		} else {
			$("#casad").removeClass("is-invalid");
			$("#casad").addClass("is-valid");
			console.log("name true");
		}
		
		//prezzo
		if (prezzo<1 || prezzo>30){
			flag=false;
			$("#prezzo").removeClass("is-valid");
			$("#prezzo").addClass("is-invalid");
			console.log("titolo false");
		} else {
			$("#prezzo").removeClass("is-invalid");
			$("#prezzo").addClass("is-valid");
			console.log("name true");
		}
		
		//anno
		if (anno<1990 || anno>2021){
			flag=false;
			$("#anno").removeClass("is-valid");
			$("#anno").addClass("is-invalid");
			console.log("titolo false");
		} else {
			$("#anno").removeClass("is-invalid");
			$("#anno").addClass("is-valid");
			console.log("name true");
		}
		
		 //Id artista
 		if (idartista<1 || idartista>200) {
			flag=false;
			$("#IDArtista").removeClass("is-valid");
			$("#IDArtista").addClass("is-invalid");
			console.log("id false");
		} else {
			$("#IDArtista").removeClass("is-invalid");
			$("#IDArtista").addClass("is-valid");
			console.log("id true");
		}
	
		//copertina
		var patternURL=/[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)/;
		if(!patternURL.test(copertina)){
		flag=false;
			$("#copertina").removeClass("is-valid");
			$("#copertina").addClass("is-invalid");
		} else {
			$("#copertina").removeClass("is-invalid");
			$("#copertina").addClass("is-valid");
		}
		
		if (flag) {
			form.submit();
		}
}

// on change inserimenti album
function validInvalidfeedback(){
	
	
	   var idalbum= $("#IDAlbum").val();
       var idartista= $("#IDArtista").val();

	    //feedback idAlbum
		if (idalbum.length <5 || idalbum.length>5) {
			$("#IDAlbum").removeClass("is-valid");
			$('#errorid').show();
		} else {
			$("#IDAlbum").removeClass("is-invalid");
			$('#errorid').hide();
		}
		
		  //feedback idArtista
		if (idalbum.length <1 || idalbum.length>200) {
			$("#IDArtista").removeClass("is-valid");
			$('#errorid').show();
		} else {
			$("#IDArtista").removeClass("is-invalid");
			$('#errorid').hide();
		}
	
}

//on submit modifica album
function controlAlbumFormModifica(form){
	
    var flag=true;
	
	var idalbum= $("#IDAlbum1").val();
	var titolo= $("#titolo1").val();
	var casadiscografica= $("#casad1").val();
	var anno= $("#anno1").val();
	var prezzo= $("#prezzo1").val();
	
	
	$(".error").remove();


    //Id album
		if (idalbum.length <5 || idalbum.length>5) {
		flag=false;
		$("#IDAlbum1").addClass("is-invalid");
		console.log("id false");
	} else {
		$("#IDAlbum1").addClass("is-valid");
		console.log("id true");
	}
	
	//titolo
	if (titolo.length<1 || titolo.length>18) {
		flag=false;
		$("#titolo1").removeClass("is-valid");
		$("#titolo1").addClass("is-invalid");
		console.log("titolo false");
	} else {
		$("#titolo1").removeClass("is-invalid");
		$("#titolo1").addClass("is-valid");
		console.log("titolo true");
	}

    //Casa discografica
	if (casadiscografica.length<1 || casadiscografica.length>18) {
		flag=false;
		$("#casad1").removeClass("is-valid");
		$("#casad1").addClass("is-invalid");
		console.log("casad false");
	} else {
		$("#casad1").removeClass("is-invalid");
		$("#casad1").addClass("is-valid");
		console.log("casad true");
	}
	
	//prezzo
	if (prezzo<1 || prezzo>30){
		flag=false;
		$("#prezzo1").removeClass("is-valid");
		$("#prezzo1").addClass("is-invalid");
		console.log("prezzo false");
	} else {
		$("#prezzo1").removeClass("is-invalid");
		$("#prezzo1").addClass("is-valid");
		console.log("prezzo true");
	}
	
	//anno
	if (anno<1990 || anno>2021){
		flag=false;
		$("#anno1").removeClass("is-valid");
		$("#anno1").addClass("is-invalid");
		console.log("anno false");
	} else {
		$("#anno1").removeClass("is-invalid");
		$("#anno1").addClass("is-valid");
		console.log("anno true");
	}
	
	if(flag){
		form.submit();
	}
	
}

//on change modifica album
function validInvalidfeedbackIDAlbum(){
	
	   var idalbum= $("#IDAlbum1").val();
       var prezzo=$("#prezzo1").val();

	    //feedback idAlbum
	     var patternID = /^[0-9]{5}$/;
	     if (!idalbum.match(patternID) )
		 {
			$("#IDAlbum1").removeClass("is-valid");
		    $('#errorid').show();
		} else {
			$("#IDAlbum1").removeClass("is-invalid");
			$('#errorid').hide();
		}
	
	//prezzo
	var numberpattern= /^[-+]?[0-9]+$/;
	if(!prezzo.match(numberpattern) || prezzo>30){
		flag=false;
		$("#prezzo1").removeClass("is-valid");
		$("#prezzo1").addClass("is-invalid");
		
	} else {
		$("#prezzo1").removeClass("is-invalid");
		$("#prezzo1").addClass("is-valid");
	}

}


//on submit inserimento brano
function controlFormBrano(form){
	var flag=true;
	
	var titolo=$("#titolo").val();
	var prezzo=$("#prezzo").val();
	var idalbum=$("#IDAlbum").val();
	
	$(".error").remove();
	
	//titolo
	if (titolo.length<1 || titolo.length>18) {
		flag=false;
		$("#titolo").removeClass("is-valid");
		$("#titolo").addClass("is-invalid");
		console.log("titolo false");
	} else {
		$("#titolo").removeClass("is-invalid");
		$("#titolo").addClass("is-valid");
		console.log("titolo true");
	}
	
	//prezzo
	if( prezzo<1 ){
		flag=false;
		$("#prezzo").removeClass("is-valid");
		$("#prezzo").addClass("is-invalid");
	} else {
		$("#prezzo").removeClass("is-invalid");
		$("#prezzo").addClass("is-valid");
	}
	
	//Id album
	if (idalbum.length <5 || idalbum.length>5) {
		flag=false;
		$("#IDAlbum").addClass("is-invalid");
	} else {
		$("#IDAlbum").addClass("is-valid");
	}
		
		if(flag){
			form.submit();
		}
}



	//on change inserimento Brano
function validInvalidfeedbackbrano(){
	
	  var prezzo=$("#prezzo").val();
	  var idalbum=$("#IDAlbum").val();

	    //feedback idAlbum
	     var patternID = /^[0-9]{5}$/;
	     if (!idalbum.match(patternID) )
		 {
			$("#IDAlbum1").removeClass("is-valid");
		    $('#errorid').show();
		} else {
			$("#IDAlbum1").removeClass("is-invalid");
			$('#errorid').hide();
		}
	
	//prezzo
	var numberpattern= /^[-+]?[0-9]+$/;
	if(!prezzo.match(numberpattern) || prezzo>30){
		flag=false;
		$("#prezzo1").removeClass("is-valid");
		$("#prezzo1").addClass("is-invalid");
		
	} else {
		$("#prezzo1").removeClass("is-invalid");
		$("#prezzo1").addClass("is-valid");
	}
}




//on submit modifica brano
function controlFormBranoModifica(form){
	var flag=true;
	
	var idbrano=$("#IDBrano1").val();
	var titolo=$("#titolo1").val();
	var prezzo=$("#prezzo1").val();
	
	
	$(".error").remove();
	
	//titolo
	if (titolo.length<1 || titolo.length>18) {
		flag=false;
		$("#titolo1").removeClass("is-valid");
		$("#titolo1").addClass("is-invalid");
		console.log("titolo false");
	} else {
		$("#titolo1").removeClass("is-invalid");
		$("#titolo1").addClass("is-valid");
		console.log("titolo true");
	}
	
	//prezzo
	if( prezzo<1 ){
		flag=false;
		$("#prezzo1").removeClass("is-valid");
		$("#prezzo1").addClass("is-invalid");
	} else {
		$("#prezzo1").removeClass("is-invalid");
		$("#prezzo1").addClass("is-valid");
	}
	
	//Id brano
		if (idbrano.length <1 ) {
		flag=false;
		$("#IDBrano1").addClass("is-invalid");
	} else {
		$("#IDBrano1").addClass("is-valid");
	}
		
		if(flag){
			form.submit();
		}
}



// onsubmit Artista
function controlFormArtista(form){
	
	var flag=true;
	var nome=$("#nome").val();
	var foto=$("#foto").val();
	
	$(".error").remove();


    //Nome
		if (nome.length <1) {
		flag=false;
		$("#nome").addClass("is-invalid");
	} else {
		$("#nome").addClass("is-valid");
	}
	
		//foto artista
		var patternURL=/[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)/;
		if(!patternURL.test(foto)){
		flag=false;
		    $("#foto").removeClass("is-valid");
			$("#foto").addClass("is-invalid");
		} else {
		    $("#foto").removeClass("is-invalid");
			$("#foto").addClass("is-valid");
		}
		
		if (flag) {
			form.submit();
		}
}
		
//onchangeArtista		
function validInvalidfeedbackArtista(){
			
			var nome=$("#nome").val();

		    //Nome
				if (nome.length <1) {
				$("#nome").removeClass("is-valid");
				$('#errorid').show();
			} else {
				$("#nome").removeClass("is-invalid");
				$('#errorid').hide();
			}
			
		}






