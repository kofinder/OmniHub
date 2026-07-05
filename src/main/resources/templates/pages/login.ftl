<#import "/layout/auth.ftl" as auth>

<@auth.main>

    <h1>Login Page</h1>

    <#if page.data?? && page.data.isLoading>
        <p>Loading...</p>
    </#if>

    <#if page.data?? && page.data.errorMessage??>
        <div class="alert alert-danger">
            ${page.data.errorMessage}
        </div>
    </#if>

    <form method="post" action="/login">
        <input name="username" class="form-control"/>
        <input name="password" type="password" class="form-control"/>
        <button class="btn btn-primary">Login</button>
    </form>

</@auth.main>