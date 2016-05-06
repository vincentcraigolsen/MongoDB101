<html>
<head>
<title>Welcome to Fruit Picker !!!</title>
</head>
<body>
	<h1>Hello ${name} person in my db</h1>
	<form action="/favorite_fruit" method="POST">
		<p>What is your favorite fruit?</p>
		<#list fruits as fruit>
			<p>
				<input type="radio" name="fruit" value="${fruit}"></input>
			</p>
		</#list>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>