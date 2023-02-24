<%-- 
    Document   : Compose
    Created on : Feb 24, 2023, 10:30:57 PM
    Author     : myths
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Online diary</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700|Inconsolata:400,700" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style1.css">
    </head>
    <body>
        <div class="wrap">
            <header role="banner">
                <div class="top-bar">
                    <div class="container">
                        <div class="row">
                            <div class="col-4 social">
                                <a href="#"><span class="fa fa-twitter"></span></a>
                                <a href="#"><span class="fa fa-facebook"></span></a>
                                <a href="#"><span class="fa fa-instagram"></span></a>
                                <a href="#"><span class="fa fa-youtube-play"></span></a>
                            </div>
                            <div class="col-5 header">
                                <a href="Login.jsp">Login now</a>
                                <a href="Signup.jsp">New user? Register now</a>

                            </div>
                            <div class="col-3 search-top">
                                <!-- <a href="#"><span class="fa fa-search"></span></a> -->
                                <form action="#" class="search-top-form">
                                    <span class="icon fa fa-search"></span>
                                    <input type="text" id="s" placeholder="Type keyword to search...">
                                </form>
                            </div>
                        </div>

                    </div>
                    <div class="container">
                        <div class="journals__header__content">
                            <div class="journals__header__actions">

                                <select  name="ThemeColor" id="ThemeColor">
                                    <option value="">Choose background color</option>
                                    <option name="color" class="yellow">Yellow</option>
                                    <option name="color" class="red">Red</option>
                                    <option name="color"class="white">White</option>
                                    <option name="color"class="dark">Dark</option>
                                    <option name="color"class="pink">Pink</option>
                                </select>
                                <button onclick="colorBackGround()">Change theme </button>
                                </a>

                            </div>

                        </div>
                    </div>
                </div>

        </div>

        <div class="book">
            <div class="modal-title" style="align-items:center; margin-top: 50px;">
                <a class="ng-binding" href="">Journal</a>
            </div>
            <div class="modal-footer">
                <a class="New-Entry" href="Entry.jsp">New entry </a>
                <a href="#0" class="modalbttn">Journal setting</a>
            </div>
        </div>



    </body>
    <script>
        function colorBackGround() {
            var x = document.getElementById("ThemeColor");
            var bgColor = x.options[x.selectedIndex].value;
            document.body.style.backgroundColor = bgColor;
        }
    </script>
</html>
