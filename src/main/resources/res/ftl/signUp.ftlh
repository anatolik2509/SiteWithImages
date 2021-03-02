<html>
<#import "spring.ftl" as spring/>
<head>
    <title><@spring.message 'sign_up.title'/></title>
</head>
<body>
${springMacroRequestContext.contextPath}
<@spring.bind "signUpForm"/>
<form action="/site/signUp" method="post">
    <@spring.formInput "signUpForm.nickName" "placeholder="/>
    <@spring.formInput "signUpForm.email"/>
    <@spring.formPasswordInput "signUpForm.password"/>
    <@spring.formPasswordInput "signUpForm.passwordRepeat"/>
    <#if errorList??>
        <p>
            <#list errorList as error>
                ${error}
            </#list>
        </p>
    </#if>
    <input type="submit" placeholder="sign up">
</form>
<a href="?lang=ru">ru</a>
<a href="?lang=en">en</a>
</body>
</html>