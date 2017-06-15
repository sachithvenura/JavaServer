<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <jsp:include page='header.jsp'/>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <div id="imaginary_container"> 
                        <div class="input-group stylish-input-group">
                            <input type="text" class="form-control"  placeholder="Search" id="searchInput">
                            <span class="input-group-addon">
                                <!--<button type="button">-->
                                <span class="glyphicon glyphicon-search"></span>
                                <!--</button>-->  
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table hidden" id="searchTable">
                <thead>
                    <tr>
                        <th>Hotel Name</th>
                        <th>Hotel Address</th>
                        <th>City</th>
                    </tr>
                </thead>
                <tbody id="searchList">

                </tbody>
            </table>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> 
    <script type="text/javascript">
        $(document).ready(function () {
            $('#searchInput').keyup(function () {
                var text = $('#searchInput').val();
                if (text.length > 0) {
                    $.ajax({
                        url: "/SpringRestFul/hotel/search/" + text,
                        type: "get",
                        success: function (data, textStatus, jqXHR) {
                            if (data.length > 0) {
                                $('#searchList').html('');
                                for (var i = 0; i < data.length; i++) {
                                    $('#searchList').append('<tr><td>' + data[i].hotelName + '</td><td>' + data[i].hotelAddress + '</td><td>' + data[i].cities.cityName + '</td></tr>');
                                }
                                $('#searchTable').removeClass('hidden');
                            }
                        }
                    });
                } else {
                    $('#searchTable').addClass('hidden');
                }
            });
        });
    </script>
</html>