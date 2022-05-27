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
        게시글 목록
        <button id="regBtn" type="button" class="btn btn-xs pull-right" onclick="move_page('register')">글 쓰기</button>
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
              <td><a href="javascript:remove(${item.bookId})">${item.bookName }</a></td>
              <td>${item.publisher }</td>
              <td>${item.price }</td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
        <!-- /.table-responsive -->

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

<script>
  function move_page(url){
    location.href = url;
  }

  function remove(book_id){
      if(confirm('해당 자료를 삭제할까요?')){
         // yes
          $.ajax({
              url: book_id,
              type: 'DELETE',
              success: function(result){
                  location.reload();
              },
          });
      } else {
          //no
          $.ajax({
              url: book_id,
              type: 'GET',
              success: function(result){
                  alert(result);
                  console.log(result);
              },
          });
      }

  }
</script>
</html>
 