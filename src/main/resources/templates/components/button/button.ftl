<button
    type="${config.type}"
    class="${component.cssClasses()}"
    <#if config.id??>id="${config.id}"</#if>
    <#if config.name??>name="${config.name}"</#if>
    <#if config.value??>value="${config.value}"</#if>
    <#if config.disabled>disabled</#if>
    <#if config.onClick??>onclick="${config.onClick}"</#if>
>
    <#if config.icon??>
        <i class="${config.icon}"></i>
    </#if>
    ${config.label}
</button>