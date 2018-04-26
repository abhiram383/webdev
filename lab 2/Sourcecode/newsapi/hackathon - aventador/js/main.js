
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var title = $('.validate-input input[name="title"]');
    var createdBy = $('.validate-input input[name="createdBy"]');
    var discount = $('.validate-input input[name="subject"]');
    var link = $('.validate-input textarea[name="link"]');
    var price = $('.validate-input textarea[name="price"]');
    var image = $('.validate-input textarea[name="image"]');
    var description = $('.validate-input textarea[name="description"]');



    $('.validate-form').on('submit',function(){
        var check = true;

        if($(title).val().trim() == ''){
            showValidate(title);
            check=false;
        }

        if($(createdBy).val().trim() == ''){
            showValidate(createdBy);
            check=false;
        }


        if($(discount).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
            showValidate(discount);
            check=false;
        }

        if($(link).val().trim() == ''){
            showValidate(link);
            check=false;
        }
        if($(price).val().trim() == ''){
            showValidate(price);
            check=false;
        }
        if($(image).val().trim() == ''){
            showValidate(image);
            check=false;
        }
        if($(description).val().trim() == ''){
            showValidate(description);
            check=false;
        }


        return check;
    });


    $('.validate-form .input1').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);