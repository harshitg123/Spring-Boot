const toggleButton = () => {
    if ($(".side-bar").is($(":visible"))) {
        
        $(".side-bar").css("display", "none");
        $(".content").css("margin-left", "0%");
        $(".closeHam").css("visibility", "visible");

    } else {
        
        $(".side-bar").css("display", "block");
        $(".content").css("margin-left", "20%");
        $(".closeHam").css("visibility", "hidden")

    }
}