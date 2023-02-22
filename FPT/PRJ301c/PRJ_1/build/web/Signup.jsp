<%-- 
    Document   : Signup
    Created on : Feb 18, 2023, 9:29:32 AM
    Author     : myths
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="style/style.css"/>
        
    </head>
    <body>
    <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Signup</h2>
              <p class="text-white-50 mb-5">Access now by signing-up!</p>

              <div class="form-outline form-white mb-4">
                <input type="text" name="username" class="form-control form-control-lg" />
                <label class="form-label" for="typeEmailX">Username</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" name="password" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Password</label>
              </div>
              <div class="form-outline form-white mb-4">
                <input type="password2" name="password2" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Re-type password</label>
              </div>
              <div class="form-outline form-white mb-4">
                <input type="email" name="email" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Email</label>
              </div>
              <div class="form-outline form-white mb-4">
                  <input type="date" name="DOB" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Date of birth</label>
              </div>
              <button class="btn btn-outline-light btn-lg px-5" type="submit">Signup</button>

              <div class="d-flex justify-content-center text-center mt-4 pt-1">
                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </body>
</html>
