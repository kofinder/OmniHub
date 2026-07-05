<#import "/layout/base.ftl" as base>
<#macro main>
    <@base.page>
        <div class="container">
            <#nested>
        </div>
    </@base.page>
</#macro>