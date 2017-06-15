<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <jsp:include page="../header.jsp"/>
    <body>
        <table class="table">
    <thead>
      <tr>
        <th>City ID</th>
        <th>City Name</th>
      </tr>
    </thead>
            <tbody id="city_list">

            </tbody>
        </table>
        <button class="btn btn-primary fixedbutton"  data-toggle="modal" data-target="#AddCity">+</button>
        <!-- Modal -->
        <div id="AddCity" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add new city</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="cityName">City Name:</label>
                                <input type="text" class="form-control" id="cityName">
                            </div>
                            <button type="button" class="btn btn-success" id="saveCityBtn">Submit</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> 
        <script type="text/javascript">
            $(document).ready(function () {
                generateCityTable();
            });

            function generateCityTable() {
                $.ajax({
                    url: "/SpringRestFul/city/list",
                    method: "get",
                    success: function (data, textStatus, jqXHR) {
                        $('#city_list').html('');
                        for (var i = 0; i < data.length; i++) {
                            $('#city_list').append('<tr><td>'+data[i].cityId+'</td><td>'+data[i].cityName+'</td></tr>');
}
                        console.log(data);
                    }
                });
            }
            $('#saveCityBtn').click(function () {
                var sendData = '{"cityName":"' + $("#cityName").val() + '"}';
                $.ajax({
                    url: "/SpringRestFul/city/add",
                    contentType: 'application/json',
                    data: sendData,
                    type: 'POST',
                    success: function (data, textStatus, jqXHR) {
                        $('#AddCity').modal('hide');
                        generateCityTable();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#AddCity').modal('hide');
                        generateCityTable();
                    }
                });
            });
        </script>
    </body>
</html>