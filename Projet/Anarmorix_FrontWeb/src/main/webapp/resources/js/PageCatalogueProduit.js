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
    $( "#AccordeonNiveauPrincipal .list-group-item" ).click(function() {
    	var panneauOuvert = $(this).next();
    	
    	var caret = panneauOuvert.prev().find("i");
        
        caret.toggleClass('fa-caret-up fa-caret-down');
        
    	});
    /*fin*/
    
    /*sélecteur de quantité*/
    $(document).ready(function(){

    	var quantitiy=0;
    	   $('.quantity-right-plus').click(function(e){
    	        
    	        // Stop acting like a button
    	        e.preventDefault();
    	        // Get the field name
    	        var quantity = parseInt($('#quantity').val());
    	        
    	        // If is not undefined
    	            
    	            $('#quantity').val(quantity + 1);

    	          
    	            // Increment
    	        
    	    });

    	     $('.quantity-left-minus').click(function(e){
    	        // Stop acting like a button
    	        e.preventDefault();
    	        // Get the field name
    	        var quantity = parseInt($('#quantity').val());
    	        
    	        // If is not undefined
    	      
    	            // Increment
    	            if(quantity>0){
    	            $('#quantity').val(quantity - 1);
    	            }
    	    });
    	    
    	});
    /*fin*/
  });
