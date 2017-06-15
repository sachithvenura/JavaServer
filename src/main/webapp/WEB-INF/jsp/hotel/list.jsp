<%-- 
    Document   : list
    Created on : Jun 15, 2017, 6:31:43 AM
    Author     : Sachith
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../header.jsp"/>
    <body>
        <table class="table">
            <thead>
                <tr>
                    <th>Hotel ID</th>
                    <th>Hotel Name</th>
                    <th>Hotel Address</th>
                    <th>Hotel City</th>
                </tr>
            </thead>
            <tbody id="hotel_list">

            </tbody>
        </table>
        <button class="btn btn-primary fixedbutton"  data-toggle="modal" data-target="#AddHotel">+</button>
        <!-- Modal -->
        <div id="AddHotel" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add new hotel</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="hotelName">Hotel Name:</label>
                                <input type="text" class="form-control" id="hotelName">
                            </div>
                            <div class="form-group">
                                <label for="hotelAddress">Hotel Address:</label>
                                <input type="text" class="form-control" id="hotelAddress">
                            </div>
                            <div class="form-group">
                                <label for="sel1">City:</label>
                                <select class="form-control" id="hotelCity"></select>
                            </div>
                            <button type="button" class="btn btn-success" id="saveHotelBtn">Submit</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> 
        <script type="text/javascript">
            $(document).ready(function () {
                generateHotelTable();
                generateCityList();
            });
            function generateHotelTable() {
                $.ajax({
                    url: "/SpringRestFul/hotel/list",
                    type: "get",
                    success: function (data, textStatus, jqXHR) {
                        $('#hotel_list').html('');
                        for (var i = 0; i < data.length; i++) {
                            $('#hotel_list').append('<tr><td>' + data[i].id + '</td><td>' + data[i].hotelName + '</td><td>' + data[i].hotelAddress + '</td><td>' + data[i].cities.cityName + '</td></tr>');
                        }
                        console.log(data);
                    }
                });
            }
            function generateCityList() {
                $.ajax({
                    url: "/SpringRestFul/city/list",
                    type: "get",
                    success: function (data, textStatus, jqXHR) {
                        $('#hotelCity').html('');
                        for (var i = 0; i < data.length; i++) {
                            $('#hotelCity').append('<option value="' + data[i].cityId + '">' + data[i].cityName + '</option>');
                        }
                        console.log(data);
                    }
                });
            }
            $('#saveHotelBtn').click(function () {
                var sendData = '{"hotel":{"hotelName":"' + $("#hotelName").val() + '","hotelAddress" :"' + $("#hotelAddress").val() + '"},"city":{"cityId":"' + $("#hotelCity").val() + '"}}';
                $.ajax({
                    url: "/SpringRestFul/hotel/add2",
                    contentType: 'application/json',
                    data: sendData,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        $('#AddHotel').modal('hide');
                        generateHotelTable();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#AddHotel').modal('hide');
                        generateHotelTable();
                    }
                });
            });
        </script>
    </body>
</html>
