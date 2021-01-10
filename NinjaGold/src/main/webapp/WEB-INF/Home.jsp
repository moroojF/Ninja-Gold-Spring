<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body>
<div class="container">
<div class="row my-3">
	<h1>Your Gold: <c:out value="${golds}"/></h1>
</div>
<div class="row my-3">
<div class="col-3">
    <div class="card text-center py-4">
        <form action="/process_money" method="post">
            <h3>Farm</h3>
            <p>(earns 10-20 golds)</p>
            <input type="hidden" name="building" value="farm" />
            <input type="submit" value="Find Gold!" class="btn-dark text-light"/>
        </form>
    </div>
    </div>
    <div class="col-3">
    <div class="card text-center py-4">
        <form action="/process_money" method="post">
            <h3>Cave</h3>
            <p>(earns 5-10 golds)</p>
            <input type="hidden" name="building" value="cave" />
            <input type="submit" value="Find Gold!" class="btn-dark text-light"/>
        </form>
    </div>
    </div>
    <div class="col-3">
    <div class="card text-center py-4">
        <form action="/process_money" method="post">
            <h3>House</h3>
            <p>(earns 2-5 golds)</p>
            <input type="hidden" name="building" value="house" />
            <input type="submit" value="Find Gold!" class="btn-dark text-light" />
        </form>
    </div>
    </div>
    <div class="col-3">
    <div class="card text-center py-4">
        <form action="/process_money" method="post">
            <h3>Casino</h3>
            <p>(earns/takes 0-50 golds)</p>
            <input type="hidden" name="building" value="casino" />
            <input type="submit" value="Find Gold!" class="btn-dark text-light"/>
        </form>
    </div>
    </div>
    <div class="col-3">
    <div class="card text-center py-4 mt-3">
        <form action="/process_money" method="post">
            <h3>Spa</h3>
            <p>(earns 5-20 golds)</p>
            <input type="hidden" name="building" value="spa" />
            <input type="submit" value="Find Gold!" class="btn-dark text-light" />
        </form>
    </div>
    </div>
    </div>
    <div class="row my-3">
    <h2>Activities:</h2>
    </div>
    <div class="row my-3">
    <div class="card p-4 block" style="overflow-y: scroll; height:400px;">    
    <c:forEach items="${messages}" var="msg">
    <p>${msg}</p>
    </c:forEach>
    </div>
    </div>
    <div class="row my-3">
    <form action='/reset' method='post' class="my-4">
        <input type='submit' value='Reset' class="btn-dark text-light">
    </form>
    </div>
</div>
</body>
</html>