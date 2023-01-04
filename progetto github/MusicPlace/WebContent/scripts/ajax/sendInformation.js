
/*
*
*
*
*
*/

$(document).ready(function() {

 $.ajaxSetup({ cache: false });
 
 $('#inputSearch').keyup(function(){
  $('#result').html('');
  $('#state').val('');
  
  var searchField = $('#inputSearch').val();
  var expression = new RegExp(searchField, "i");
  $.getJSON('AjaxRetrieveInformation', function(data) {
  $('#result').html('');
   $.each(data, function(key, value){
    if (value.nome.search(expression) != -1 )
    {
     $('#result').append('<a class="list-group-item list-group-item-action list-group-item-light" onclick="clickSuggerimento('+value.ID+',\'' + value.tipo + '\')"> '+value.nome+' | <span class="text-muted">'+value.tipo+'</span></a>');
    }
   });   
  });
 });
 
 $('#result').on('click', 'li', function() {
  var click_text = $(this).text().split('|');
  $('#search').val($.trim(click_text[0]));
  $("#result").html('');
 });
});

	
function clickSuggerimento(ID,tipo) {
	console.log("ID: "+ ID + " tipo: " + tipo);
	if(tipo=='Album'){
		location.href= encodeURI("DettaglioControl?type=album&product=" + ID);
	}else if (tipo=='Artista'){
		location.href= encodeURI("DettaglioControl?type=artistaAjax&product=" + ID);
	}else if (tipo=='Brano'){
	    location.href= encodeURI("DettaglioControl?type=brano&product=" + ID);
	}
}