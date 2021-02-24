<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<form action="/site/signUp" method="post">
    <input name="nickName" placeholder="name">
    <input name="email" type="email" placeholder="email">
    <input name="password" type="password" placeholder="password">
    <input name="passwordRepeat" type="password" placeholder="repeat password">
    <#if errorList??>
        <p>
            <#list errorList as error>
                ${error}
            </#list>
        </p>
    </#if>
    <input type="submit" placeholder="sign up">
</form>
</body>
</html>