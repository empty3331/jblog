<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/write">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			<table id="admin-cate-list">
				<colgroup>
					<col style="width: 50px;">
					<col style="width: 200px;">
					<col style="width: 100px;">
					<col style="width: 500px;">
					<col style="width: 50px;">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
				
				</thead>
				<!-- 원래 테이블 있던자리 -->
				<tbody id='cateList'></tbody>
				<!-- 원래 테이블 있던자리 -->
				</table>
				
				
				
      		
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value="" id="inCateName"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc" id="inCateDes"></td>
		      		</tr>
		      	</table> 
				
				<input type="hidden" id="inCateId" value="${blogVo.id}">
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">

//카테고리 추가하기
$("#btnAddCate").on("click",function(){
	//이벤트 체크
	console.log("추가버튼");
	
	//데이터 수집
	var name = $("#inCateName").val();
	var des = $("#inCateDes").val();
	var id = $("#inCateId").val();

	
	//데이터 전송
	$.ajax({
		url : "${pageContext.request.contextPath }/${blogVo.id}/admin/catewrite",
		type : "post",
		data : {cateName:name,
		       description:des,
		       id:id},
	
		//받을 때 옵션
		dataType : "json",
		success : function(cateVo) {
			render(guestbookVo,"up");
			$("#inCateName").val("");
			$("#inCateDes").val("");
			$("#inCateId").val("");
			
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
});





//////////////////////////////////////////////////////////////////////////////////
//리스트 불러오기
$(document).ready(function(){
	fetchList();
});


function fetchList() {
	$.ajax({

		url : "${pageContext.request.contextPath }/${blogVo.id}/admin/list",
		type : "post",
		//contentType : "application/json",
		//data : {name: ”홍길동"},

		dataType : "json",
		success : function(caVo) {
			console.log(caVo);
			for (var i = 0; i < caVo.length; i++) {
				render(caVo[i],"down");
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
}

//리스트 그리기(1개씩)
function render(caVo,direction) {
	var str = "";
	str += "    <tr>";
	str += "      <td>"+caVo.cateNo+"</td>";
	str += "      <td>"+caVo.cateName+"</td>";
	str += "      <td>"+caVo.cateCount+"</td>";
	str += "      <td>"+caVo.description+"</td>";
	str += "      <td class='text-center' data-delcate='"+caVo.cateNo+"'>";
	str += "      <img class='btnCateDel' src='${pageContext.request.contextPath}/assets/images/delete.jpg'>";
	str += "      </td>";	
	str += "</tr>";
	
	
	if(direction== "up"){
		$("#cateList").prepend(str);
	}else if(direction== "down") {
		$("#cateList").append(str);
	} else{ console.log("없음");}
}

////////////////////////////////////////////////////////////////////////////////


</script>


</html>