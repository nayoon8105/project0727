<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/dropzone/upload_form.jsp</title>
<link rel="stylesheet" href="dropzone.css" />
<script src="dropzone.js"></script>
</head>
<body>
<h3>dropzone js 테스트</h3>
<form action="upload.jsp" method="post" 
	class="dropzone" id="myForm" enctype="multipart/form-data">
	<input type="file" name="myFile"/>
</form>
<script>
	Dropzone.options.myForm={
		paramName:"myFile",
		success:function(file, responseData){
			console.log(responseData);
		}	
	};
</script>
</body>
</html>







