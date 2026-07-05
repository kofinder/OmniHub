<#import "/layout/base.ftl" as base>
<#macro main>
    <@base.main>
        <div class="container">
            <#nested>
        </div>
    </@base.main>
</#macro>