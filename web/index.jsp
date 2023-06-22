<%@ page import="java.util.ArrayList" %>
<%@ page import="narxoz.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Демо Bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-5">
    <h3 class="text-center mb-3">BITLAB SHOP</h3>
    <div class="row g-3">
        <% ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("items"); %>
        <% if (items != null) {
            for (Items item : items) {
        %>
        <div class="col-12 col-md-6 col-lg-4">
            <div class="card">
                <div class="card-body">
                    <p class="card-text text-center display-6" style="font-size: 33px"><%=item.getName()  %>
                    </p>
                    <hr>
                    <p class="card-text text-center">
                        <%=item.getDescription()  %>
                    </p>
                    <p class="card-text text-center">
                        <%=item.getPrice()  %> $
                    </p>
                </div>
            </div>
        </div>
        <% }
        }%>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>