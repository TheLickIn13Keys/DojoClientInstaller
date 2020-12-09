$(document).ready(function(){

    $("#intro").fadeIn(1000).delay(2000).fadeOut(function(){

        $("#load").fadeIn(1000);

    });

});

function finished(){

    $("#load").fadeOut(function(){
        $(".loader").fadeOut(1000);
        $("#done").fadeIn(1000).delay(2000).fadeOut(function(){
            $("#close").fadeIn(1000);
        })
    });

}