<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ cp }/login" method="POST">
		id : <input class="input" type="text" name="userId" required value="${ userId }"> <br>
		pw : <input class="input" type="password" name="pass" required> <br>
		<button type="submit">로그인</button>
		<script>
			document.addEventListener('keydown', function(e) {
				if (e.key == 'Enter' && e.target.classList.has('input') && document.forms[0].userId.value && document.forms[0].pass.value ) {
					document.forms[0].submit();
				}
			});
		</script>
	</form>
</body>
</html>