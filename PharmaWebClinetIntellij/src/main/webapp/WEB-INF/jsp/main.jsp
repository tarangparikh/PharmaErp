<%--
  Created by IntelliJ IDEA.
  User: tarang
  Date: 23/2/18
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include  page="../header/cssHeader.jsp"></jsp:include>

    <style>
        div.vert-align{
            margin-top: 50px;
        }
        .bs-popover-right .arrow::after, .bs-popover-auto[x-placement^="right"] .arrow::after {
            left: 1px;
            border-right-color:  #fff;
        }
        .material-icons.red600 { color: #fb1e31; }

        #login_body { background-color: #f9f9f9; }

    </style>





</head>
<body>
    <!--[if lte IE 9]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
    <![endif]-->

    <!-- Add your site or application content here -->

    <div class="container vert-align">
        <div class="row align-self-center ">
            <div class="col-md-3"></div>
            <div class="col-md-6 mx-auto">
                <div class="card" id="login_card">
                    <div class="card-header bg-dark">
                        <div class="row">
                            <div class="col-md-4"></div>
                            <div class="col-md-4 text-center">
                                <img class="img-fluid" src="img/logo.png">
                            </div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                    <div class="card-body" id="login_body">
                        <form id="login_form" action="/login">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1">@</span>
                                    </div>

                                    <input type="text" id="email" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1"
                                           data-trigger="manual" />

                                </div>

                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <div class="input input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon2">&#128274</span>
                                    </div>

                                    <input type="password" class="form-control" id="pwd" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox"> Remember me
                                </label>
                            </div>
                            <div class="row">
                                <div class="col-md-4"></div>
                                <div class="col-md-4 text-center">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                                <div class="col-md-4"></div>

                            </div>

                        </form>
                    </div>
                </div>



            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
    <jsp:include page="../header/scriptHeader.jsp"></jsp:include>

    <script type="text/javascript">

        $(document).ready(function () {
            $.fn.errorFunciton = function () {
                var _title = 'Error';
                var _icon = 'error';
                var _error_message = 'The email address or username that you\'ve entered doesn\'t match any account. ';
                $('#email').popover({
                    placement: 'right',
                    html: true,
                    template: '<div class="popover" role="tooltip">' +
                    '<div class="arrow"></div>' +

                    '<div class="popover-header"></div>' +

                    '<div class="popover-body"></div>' +
                    '</div>',
                    title: '<div title="container">' +
                    '<div class="row">' +
                    '<div class="col-md-1">' +
                    '<i class="material-icons red600">'+_icon+'</i>' +
                    '</div><div class="col-md-5 text-danger">' +
                    _title +
                    '</div> ' +
                    '</div>' +
                    '</div>',
                    content: '<div class="text-danger">'+_error_message+'</div>'



                });
                $('#email').popover('show');
                //$('#email').addClass("border border-danger");

                $('#email').on("blur",function () {
                    $('#email').addClass("border border-danger");

                });

                $('#email').on("click", function () {
                    $('#email').removeClass("border border-danger");
                });
            };


            $.fn.extend({
                makepopper: function (_error_message,_title,_icon,_placement) {
                    $(this).popover({
                        placement: _placement,
                        html: true,
                        trigger: 'manual',
                        template: '<div class="popover" role="tooltip">' +
                        '<div class="arrow"></div>' +

                        '<div class="popover-header"></div>' +

                        '<div class="popover-body"></div>' +
                        '</div>',
                        title: '<div title="container">' +
                        '<div class="row">' +
                        '<div class="col-md-1">' +
                        '<i class="material-icons red600">'+_icon+'</i>' +
                        '</div><div class="col-md-5 text-danger">' +
                        _title +
                        '</div> ' +
                        '</div>' +
                        '</div>',
                        content: '<div class="text-danger">'+_error_message+'</div>'
                    });



                }
            });
            $.fn.extend({
                showpopover: function () {
                    $(this).popover('show');
                }
            })


            //$.fn.errorFunciton();
            $('#email').makepopper('The email address or username that you\'ve entered doesn\'t match any account. ','Error','error','right');
            $('#email').showpopover();
            $('#pwd').makepopper('The password that you\'ve entered is incorrect. ','Error','error','right');
            $('#pwd').showpopover();
            //alert('hu');

        });

    </script>


</body>
</html>
