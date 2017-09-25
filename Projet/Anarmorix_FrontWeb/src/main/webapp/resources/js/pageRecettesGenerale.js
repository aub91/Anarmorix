$(function () {
	
	$(document).ready(function(){
		
			
    	     $('.btn-entrees').click(function(){
    	    	var $title="prout"; 
    	        $('.col-md-3').each(function() {
    	        	
					var $this = $(this);
					$this.show();
     	         $title = $this.find('.box-img').next().find('.title').text();
     	        
     	        
     	        if ($title !== "ENTRÉE") {
					$this.hide();
				}
				});
    	    	 
    	    	
    	     });	 
    	     
    	     $('.btn-plats').click(function(){
     	    	var $title="prout"; 
     	        $('.col-md-3').each(function() {
 					var $this = $(this);
 					$this.show();
      	         $title = $this.find('.box-img').next().find('.title').text();
      	        
      	        
      	        if ($title !== "PLAT") {
 					$this.hide();
 				}
 				});
     	    	 
     	    	
     	     });	
    	     
    	     
    	     $('.btn-desserts').click(function(){
     	    	var $title="prout"; 
     	        $('.col-md-3').each(function() {
 					var $this = $(this);
 					$this.show();
      	         $title = $this.find('.box-img').next().find('.title').text();
      	        
      	        
      	        if ($title !== "DESSERT") {
 					$this.hide();
 				}
 				});
     	    	 
     	    	
     	     });	
    	     
    	     $('.btn-tous').click(function(){
      	    	var $title="prout"; 
      	        $('.col-md-3').each(function() {
  					var $this = $(this);
  					
       	         $this.show();
  				});
      	    	 
      	    	
      	     });	
    	    	
    	});
  });
