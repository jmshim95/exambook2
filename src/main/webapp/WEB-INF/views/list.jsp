<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>book</title>
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
        게시글 목록
        <button id="regBtn" type="button" class="btn btn-xs pull-right">글 쓰기</button>
      </div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
          <thead>
          <tr>
            <th>BookId</th>
            <th>BookName</th>
            <th>Publisher</th>
            <th>Price</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${bookList }" var="item">
            <tr class="odd gradeX">
              <td>${item.bookId }</td>
              <td>${item.BookName }</td>
              <td>${item.Publisher }</td>
              <td>${item.Price }</td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
        <!-- /.table-responsive -->

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModallabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
              </div>
              <div class="modal-body">처리가 완료되었습니다.</div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-default" >Save Changes</button>
              </div>
            </div>
          </div>
        </div>
        <!-- /.modal fade -->

      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.panel-body -->
  </div>
  <!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
</body>
</html>
 