<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
  <head>
    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container mx-auto mt-5" style="width: 50%;">
        <h1>Complex form</h1>

        <form action="interceptorSucces" method="post" enctype="multipart/form-data">
            <div class="form-group">
              <label for="exampleFormControlInput1">Your name</label>
              <input type="text" class="form-control" id="exampleFormControlInput1" name="userName">
            </div>

            <button type="submit" class="btn btn-primary mt-4">Submit</button>

          </form>
    </div>
  </body>
</html>