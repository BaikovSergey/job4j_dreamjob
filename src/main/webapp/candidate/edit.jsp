<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <title>Dream job!</title>
    <script>
        function validate() {
            var result = true;
            var fields = [document.getElementById("Name")];

            for (var i = 0; i < fields.length; i++) {
                if (fields[i].value === "") {
                    result = false;
                    break;
                }
            }

            if (!result) {
                for (var j = 0; j < fields.length; j++) {
                    if (fields[j].value === "") {
                        alert("Please fill this field: " + $(fields[j]).attr('name'));
                    }
                }
            }
            return result;
        }

         $(document).ready(function() {
             var load = true;
             $("#CitySelect").click(function () {
                    if (load === true) {
                        $.ajax({
                            type: "GET",
                            url: "http://localhost:8080/index.do/cities.do"
                        }).done(function(data) {
                            var cities = JSON.parse(data);
                            var cityList = $("#CitySelect");
                            $.each(cities, function (key, value) {
                                cityList.append("<option value=" + key + ">" + value + "</option>");
                            });
                            load = false;
                        }).fail(function(){
                            alert("Could not load data")
                        });
                    }
             });
         });

    </script>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts/edit.do">Добавить вакансию</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates/edit.do">Добавить кандидата</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/auth.do"> <c:out value="${user.name}"/> | Войти</a>
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Новаый кандидат
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do" method="post">
                    <div class="form-group">
                        <label for="Name">Имя</label>
                        <input type="text" class="form-control" name="Имя" id="Name">
                    </div>
                    <div class="form-group">
                        <label for="CitySelect">Город</label>
                        <select class="browser-default custom-select" id="CitySelect">
                            <option value="none" hidden>Выберите город</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validate();">
                        Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>