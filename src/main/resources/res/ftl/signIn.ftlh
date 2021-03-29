<html>
<#import "spring.ftl" as spring/>
<head>
    <title>Sign In</title>
</head>
<body>
<@spring.bind "signInForm"/>
<form action="${springMacroRequestContext.contextPath}/signIn" method="get">
    <@spring.formInput "signUpForm.email"/>
    <@spring.formPasswordInput "signUpForm.password"/>
    <#if errorList??>
        <p>
            <#list errorList as error>
                ${error}
            </#list>
        </p>
    </#if>
    <input type="submit" placeholder="sign in">
</form>
</body>
</html>