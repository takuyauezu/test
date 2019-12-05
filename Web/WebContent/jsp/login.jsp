<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body><form action="http://localhost:8080/Web/Login" method="post">
		<h1>ログイン</h1>

			<table>
				<tr>
					<td>ログインコード</td>
					<td><input type="text" name="login_cd"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="login_pw"></td>
				</tr>
			</table>
			<input type="submit" value="ログイン">
		</form>

</body>
</html>