<html>
<head>
    <title>Sign Up</title>
</head>
<body>
 <form action="/signUp" method="post">
     <input name="nickName" placeholder="name">
     <input name="email" type="email" placeholder="email">
     <input name="password" type="password" placeholder="password">
     <input name="passwordRepeat" type="password" placeholder="repeat password">
     <#if errorList??>
         <#list errorList as error>
             ${error}
         </#list>
     </#if>
     <input type="submit" placeholder="sign up">
 </form>
</body>
</html>