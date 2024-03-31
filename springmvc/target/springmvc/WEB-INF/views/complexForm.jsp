<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <script src="<c:url value="/resources/js/script.js" />"></script>

    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container mx-auto mt-5" style="width: 50%;">
        <h1>Complex form</h1>

        <%
            String st = (String) request.getAttribute("errors");
            if( st == "true"){
        %>
                
            <div class="alert alert-danger" role="alert">
                <form:errors path="complexForm.*" />
            </div>

        <%
            }
        %>

        <form action="submitComplexForm" method="post">
            <div class="form-group">
              <label for="exampleFormControlInput1">Email address</label>
              <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" name="email">
            </div>

            <div class="form-group">
              <label for="id">Id</label>
              <input type="text" class="form-control" id="id" placeholder="" name="id">
            </div>

            <div class="form-group">
              <label for="id">DOB</label>
              <input type="date" class="form-control" id="id" placeholder="dd/mm/yyyy" name="date">
            </div>

            <div class="form-group">
              <label for="Select courses">Example multiple select</label>
              <select multiple class="form-control" id="Select courses" name="courses">
                <option>Java</option>
                <option>Python</option>
                <option>Spring</option>
                <option>Spring boot</option>
                <option>Django</option>
              </select>
            </div>

            <div class="form-group">
                <label for="Platforms">Example select</label>
                <select class="form-control" id="Platforms" name="platform">
                  <option>Udemy</option>
                  <option>Coursera</option>
                  <option>Youtube</option>
                  <option>Couching</option>
                </select>
              </div>

              <div class="d-flex">
                <div class="mr-4">Select gender</div>
                <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" id="customRadioInline1" name="gender" class="custom-control-input" value="Male">
                    <label class="custom-control-label" for="customRadioInline1">Male</label>
                  </div>
                  <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" id="customRadioInline2" name="gender" class="custom-control-input" value="Female">
                    <label class="custom-control-label" for="customRadioInline2">Female</label>
                  </div>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput1">State</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Enter your state" name="address.state">
            </div>

            <div class="form-group">
            <label for="exampleFormControlInput1">City</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Enter your city" name="address.city">
            </div>

            <div class="form-group">
            <label for="exampleFormControlInput1">Pin code</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Enter your pin code" name="address.pinCode">
            </div>

            <button type="submit" class="btn btn-primary mt-4">Submit</button>

          </form>
    </div>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
  </body>
</html>