<#import "/layout/base.ftl" as base>

<#macro main>
    <@base.page>
        <main class="container-fluid">
            <#nested>
        </main>
    </@base.page>
</#macro>