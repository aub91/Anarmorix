$(function () {

    var goToCartIcon = function($addTocartBtn){
      var $cartIcon = $(".my-cart-icon");
      var $image = $('<img width="30px" height="30px" src="' + $addTocartBtn.data("image") + '"/>').css({"position": "fixed", "z-index": "999"});
      $addTocartBtn.prepend($image);
      var position = $cartIcon.position();
      $image.animate({
        top: position.top,
        left: position.left
      }, 500 , "linear", function() {
        $image.remove();
      });
    };

    $('.my-cart-btn').myCart({
      currencySymbol: '€',
      classCartIcon: 'my-cart-icon',
      classCartBadge: 'my-cart-badge',
      classProductQuantity: 'my-product-quantity',
      classProductRemove: 'my-product-remove',
      classCheckoutCart: 'my-cart-checkout',
      affixCartIcon: true,
      showCheckoutModal: true,
      numberOfDecimals: 2,
      cartItems: [
        
      ],
      clickOnAddToCart: function($addTocart){
        goToCartIcon($addTocart);
      },
      afterAddOnCart: function(products, totalPrice, totalQuantity) {
        console.log("afterAddOnCart", products, totalPrice, totalQuantity);
      },
      clickOnCartIcon: function($cartIcon, products, totalPrice, totalQuantity) {
        console.log("cart icon clicked", $cartIcon, products, totalPrice, totalQuantity);
      },
      checkoutCart: function(products, totalPrice, totalQuantity) {
        var checkoutString = "Total Price: " + totalPrice + "\nTotal Quantity: " + totalQuantity;
        checkoutString += "\n\n id \t name \t summary \t price \t quantity \t image path";
        $.each(products, function(){
          checkoutString += ("\n " + this.id + " \t " + this.name + " \t " + this.summary + " \t " + this.price + " \t " + this.quantity + " \t " + this.image);
        });
        alert(checkoutString);
        console.log("checking out", products, totalPrice, totalQuantity);
      },
      getDiscountPrice: function(products, totalPrice, totalQuantity) {
        console.log("calculating discount", products, totalPrice, totalQuantity);
        return totalPrice * 0.5;
      }
    });
/*caret haut et bas*/
//    $( "#AccordeonNiveauPrincipal .list-group-item" ).click(function() {
//    	var panneauOuvert = $(this).next();
//    	
//    	var caret = panneauOuvert.prev().find("i");
//        
//        caret.toggleClass('fa-caret-up fa-caret-down');
//        
//    	});
    /*fin*/
    
    /*sélecteur de quantité*/
    $(document).ready(function(){

    	var quantitiy=0;
    	   

    	     $('.quantity-left-minus').click(function(e){
    	        
    	    	 var $this = $(this);
     	        var $input = $this.closest('span').next('input');
    	    	 
    	    	 
    	    	 // Stop acting like a button
    	        e.preventDefault();
    	        // Get the field name
    	        var quantity = parseInt($input.val());
    	        
    	        // If is not undefined
    	      
    	            // Increment
    	            if(quantity>0){
    	            $input.val(quantity - 1);
    	            }
    	    });
    	     
    	     $('.quantity-right-plus').click(function(e){
     	        
      		   var $this = $(this);
      	        var $input = $this.closest('div').find('input');
      		   
      		   
      	        // Stop acting like a button
      	        e.preventDefault();
      	        // Get the field name
      	        var quantity = parseInt($input.val());
      	        
      	        // If is not undefined
      	            
      	            $input.val(quantity + 1);

      	          
      	            // Increment
      	        
      	    });
    	    
    	});
    /*fin*/
    
    
    /*barre de recherche*/
    $(document).ready(function(){
        var submitIcon = $('.searchbox-icon');
        var inputBox = $('.searchbox-input');
        var searchBox = $('.searchbox');
        var isOpen = false;
        submitIcon.click(function(){
            if(isOpen == false){
                searchBox.addClass('searchbox-open');
                inputBox.focus();
                isOpen = true;
            } else {
                searchBox.removeClass('searchbox-open');
                inputBox.focusout();
                isOpen = false;
            }
        });  
         submitIcon.mouseup(function(){
                return false;
            });
        searchBox.mouseup(function(){
                return false;
            });
        $(document).mouseup(function(){
                if(isOpen == true){
                    $('.searchbox-icon').css('display','block');
                    submitIcon.click();
                }
            });
    });
        function buttonUp(){
            var inputVal = $('.searchbox-input').val();
            inputVal = $.trim(inputVal).length;
            if( inputVal !== 0){
                $('.searchbox-icon').css('display','none');
            } else {
                $('.searchbox-input').val('');
                $('.searchbox-icon').css('display','block');
            }
        }
    /*fin*/
        $("a[href*='Accordeon']").on('click', function () {
        	let i =0;
        	$("i.fa").each(function(){
        		if($(this).hasClass("fa-caret-up")){
        			$(this).toggleClass('fa-caret-up fa-caret-down');
        			i++;
        		}
        	});
        	
        	if($(this).find("i.fa").hasClass("fa-caret-down") &&  i===0){
    			$(this).find("i.fa").removeClass("fa-caret-down");
    			$(this).find("i.fa").addClass("fa-caret-up");
    		}
        	
        	/*
        	 * Afficher les images.
        	 */
        	
        	// recupere la categorie selectionnée
        	setTimeout(function(){
        		var eltCollapseInSecondaire = $('[id*="Secondaire"].collapse.in')
            	if(eltCollapseInSecondaire.length > 0) {
            		var eltCollapseInTertiaire = eltCollapseInSecondaire[0].children[1];
            		var categorieProduit;
            		if(eltCollapseInTertiaire.classList.contains("in")) {
            			categorieProduit = eltCollapseInTertiaire.firstChild.textContent;
            			console.log(categorieProduit);
            		} else  {
            			categorieProduit =eltCollapseInSecondaire[0].firstChild.textContent;
            			console.log(categorieProduit);
            		}
            	}
        	}, 500);
        });
  });










