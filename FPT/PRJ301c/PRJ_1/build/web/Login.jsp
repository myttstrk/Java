<%-- 
    Document   : Login
    Created on : Feb 18, 2023, 9:10:41 AM
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
    <body  style="
background-color: #DBF9FC;">
 <div class="container">
        <div class="body d-md-flex align-items-center justify-content-between">
            <div class="box-1 mt-md-0 mt-5">
                <img src="https://images.pexels.com/photos/2033997/pexels-photo-2033997.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                    class="" alt="">
            </div>
            <div class=" box-2 d-flex flex-column h-100">
                <div class="mt-5">
                    <p class="mb-1 h-1">Create Account.</p>
                    <p class="text-muted mb-2">Share your thouhts with the world form today.</p>
                    <div class="d-flex flex-column ">
                        <p class="text-muted mb-2">Continue with...</p>
                        <div class="d-flex align-items-center">
                            <a href="#" class="box me-2 selectio">
                                <span class="fab fa-facebook-f mb-2"></span>
                                <p class="mb-0">Facebook</p>
                            </a>
                            <a href="#" class="box me-2">
                                <span class="fab fa-google mb-2"></span>
                                <p class="mb-0">Google</p>
                            </a>  
                        <div class="mt-3">
                            <p class="mb-0 text-muted">Already have an account?</p>
                            <a href="LoginByAcc.jsp">Login </a>
                                </div>
                </div>
                <div class="mt-auto">
                    <p class="footer text-muted mb-0 mt-md-0 mt-4">By register you agree with our
                        <span class="p-color me-1">terms and conditions</span>and
                        <span class="p-color ms-1">privacy policy</span>
                    </p>
                </div>
            </div>
            <span class="fas fa-times"></span>
        </div>
    </div>
    </body>
</html>
