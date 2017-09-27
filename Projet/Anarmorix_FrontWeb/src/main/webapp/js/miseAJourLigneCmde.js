/*
$(function(){
	$("form[name='form-Maj']").on("submit",function(){
		let params ="dateFinPreparation=" + encodeURI($("input[name='saisie-dateFinPreparation']").val());
		$.ajax({
			type:"POST",
			url:"majLigneCommande.aspx",
			async:true,
			contentType:"application/x-www-form-urlencoded",
			data:params,
			success : function(data){
				$("input[name='saisie-dateFinPreparation']").html(data);
			}
		})
		
		
	});

});
*/