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

const deleteAlert = (cId) => {
    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#009688",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
      }).then((result) => {
        if (result.isConfirmed) {
            
          Swal.fire({
            title: "Deleted!",
            text: "Your contact has been deleted.",
            icon: "success",
            showConfirmButton: false
          });

          setTimeout(() => {
            window.location = "/user/delete/" + cId
          }, 2000);
          

        
        }else{
            Swal.fire({
                text: "Your contact is safe.",
                icon: "success"
              });
        }
      });
}