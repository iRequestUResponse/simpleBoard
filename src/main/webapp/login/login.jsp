<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.login {
		position: fixed;
		left: 0;
		top: 0;
		width: 100vw;
		height: 100vh;
		background: linear-gradient(180deg, rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.5));
	}
	
	.login form {	
		display: block;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		background: #FFF;
		padding: 2em;
		border-radius: 16px;
	}
</style>
</head>
<body>
	<div class="login">
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
		<script>
			document.forms[0].userId.focus();
		</script>
	</div>
</body>
</html>