<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>book</title>
  <jsp:include page="header.jsp"/>

</head>
<body>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">List Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        책 등록
      </div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <form role="form" action="/book" method="post">
          <div class="form-group">
            <label>bookName</label>
            <input class="form-control" name="bookName">
          </div>
          <div class="form-group">
            <label>publisher</label><textarea class="form-control" rows="3" name="publisher"></textarea>
          </div>
          <div class="form-group">
            <label>price</label><textarea class="form-control" name="price"></textarea>
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
          <button type="reset" class="btn btn-default">Reset</button>
        </form>
      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.panel-body -->
  </div>
  <!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
<!-- /.row -->
</body>
</html>
